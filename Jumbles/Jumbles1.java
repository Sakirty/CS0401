import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
  
public class Jumbles1
{
   public static void main(String[] args)throws Exception
   {
      if (args.length < 2) die( "Must pass name of input files on cmd line." );
      
      long startTime = System.currentTimeMillis();
      ArrayList<String> dictionary = new ArrayList<>();
      ArrayList<String> jumbled = new ArrayList<>();
      BufferedReader wordList = new BufferedReader(new FileReader(new File(args[0])));   
      while(wordList.ready())
      {
         dictionary.add(wordList.readLine());
      }
      wordList.close();
      BufferedReader jumbledList = new BufferedReader(new FileReader(new File(args[1]))); 
      while(jumbledList.ready())
      {
         jumbled.add(jumbledList.readLine());
      }
      Collections.sort(jumbled);
      Collections.sort(dictionary);      
      ArrayList<String> answerKey = new ArrayList<>(); 
      for (int i = 0; i<dictionary.size();i++)
      {
         String dWord = dictionary.get(i);
         String dCanon = toCanon(dWord);
         int index = bsearch(answerKey,dCanon);   
         if(index>=0)
            answerKey.set(index, answerKey.get(index) + " " + dWord );
         else{
            index = -(index+1);
            answerKey.add(index,dCanon + " " + dWord);
         }
      }      
      for(int i = 0;i<jumbled.size();i++)
      {
         String jWord = jumbled.get(i);
         System.out.print(jWord+"");
         String jCanon = toCanon(jWord);    
         int index = bsearch(answerKey,jCanon);   
         if(index>=0)
            System.out.println(answerKey.get(index).substring(jWord.length()));
         else
            System.out.println();
      }
        long ms = System.currentTimeMillis() - startTime;
        System.out.printf("Elapsed time in seconds: %.3f\n", ms / 1000.0);
   }
   static String toCanon(String st)
   {
      char[] chars = st.toCharArray();
      Arrays.sort(chars);
      return new String(chars);   
   }
   static int bsearch(ArrayList<String>answerKey, String canonPrefix)
   {
      int low = 0;
      int high = answerKey.size()-1;
      while(low<=high)
      {
        int mid = low +((high-low)/2);     
        if(answerKey.get(mid).startsWith(canonPrefix+"")) return mid;
         if(answerKey.get(mid).compareTo(canonPrefix+"")<0) low = mid+1;
         if(answerKey.get(mid).compareTo(canonPrefix+"")>0) high = mid-1;
      }
      return -(low+1);
   }
   static void die( String msg )
   {
      System.out.println( "\nFATAL ERROR: " + msg + "\n" );
      System.exit(0);
   }    
        
}
