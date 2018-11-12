import java.io.*;
import java.util.*;

public class Lab10 {
    static TreeMap<String, String> jum = new TreeMap<String,String>();
    public static void main(String[] args) throws Exception
    {
        if(args.length < 2)
        {
            System.out.println("You must type the file name along with the run command. \n ie: java Project5 dictionary.txt jumbles.txt");
            System.exit(0);
        }
        TreeSet<String> dictionary = new TreeSet<String>();
        TreeSet<String> jumbled = new TreeSet<String>();
        BufferedReader dFile = new BufferedReader(new FileReader(new File(args[0])));
        //TreeMap<String,String> States2CapitolsTree = new TreeMap<String,String>();
        while(dFile.ready())
        {
        	dictionary.add(dFile.readLine());
        }
        //dFile.close();

        BufferedReader jFile = new BufferedReader(new FileReader(new File(args[1]))); 

        while(jFile.ready())
        {
            jumbled.add(jFile.readLine());
        }
        

        for (String dWord : dictionary)
        {
            String sortedDword = toCanon( dWord );
            if (!jum.containsKey(sortedDword))
            {
            jum.put(sortedDword, dWord);
            }
            else
            {
            jum.put(sortedDword, jum.get(sortedDword) + " " + dWord );
            }
        }
        
        for (String jWord : jumbled)
        {
            String sortedJword = toCanon( jWord );
            System.out.print(jWord + " ");
            if(jum.containsKey(sortedJword))
            {
            System.out.println(jum.get(sortedJword));
            }
            else
            {
            System.out.println("");
            }
        }



    }
    public static String toCanon(String st)
    {
        char[] chars = st.toCharArray();
        Arrays.sort(chars);
        String c = new String(chars);
        return c;

    }
}
