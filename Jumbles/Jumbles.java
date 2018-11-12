import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Jumbles{


   public static String toCanon(String st){
        char[] chars = st.toCharArray();
        Arrays.sort(chars);
        String c = new String(chars);
        return c;

   }

   static int bsearch(ArrayList<String>answerKey, String canonPrefix){
      int low=0;
      int high=answerKey.size()-1;

      while(low<=high){
         int mid = low +((high-low)/2);

         if(answerKey.get(mid).startsWith(canonPrefix+""))
            return mid;
         if(answerKey.get(mid).compareTo(canonPrefix+"")<0)
            high = mid-1; 
         if(answerKey.get(mid).compareTo(canonPrefix+"")>0)
            low = mid+1; 
      }
      return -(low+1);
   }

   public static void main(String[] args)throws Exception{
      if(args.length < 2)
        {
            System.out.println("You must type the file name along with the run command. \n ie: java Project5 dictionary.txt jumbles.txt");
            System.exit(0);
        }
        ArrayList<String> dictionary = new ArrayList<String>(10);
        ArrayList<String> jumbled = new ArrayList<String>(10);
        BufferedReader dFile = new BufferedReader(new FileReader(new File(args[0])));

        while(dFile.ready())
        {
            dictionary.add(dFile.readLine());
        }
        dFile.close();

        BufferedReader jFile = new BufferedReader(new FileReader(new File(args[1])));
        while(jFile.ready())
        {
            jumbled.add(jFile.readLine());
        }
        Collections.sort(jumbled);
        Collections.sort(dictionary);

        ArrayList<String> answerKey=new ArrayList<String>();


                for (int i=0; i<dictionary.size();i++)
        {
            String dWord = dictionary.get(i);
            String dCanon = toCanon(dWord);
            int index=bsearch(answerKey,dCanon+" "); 

            if(index>=0)
               answerKey.set(index, answerKey.get(index) + " " + dWord );
            else{
               index = -(index+1);
               answerKey.add(index,dCanon + " " + dWord);
            }
        }

        for(int i=0;i<jumbled.size();i++){
            String jWord=jumbled.get(i);
            System.out.print(jWord+" "); 
            String jCanon = toCanon(jWord);

            int index=bsearch(answerKey,jCanon+" "); 

            if(index>=0)
               System.out.println(answerKey.get(index).substring(jWord.length() + 1)); 
            else
               System.out.println();
        }

        }
}
