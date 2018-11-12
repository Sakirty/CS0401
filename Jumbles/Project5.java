import java.io.*;
import java.util.*;

public class Project5 {
    static HashMap<String, String> hashBrown = new HashMap<>(); //class variable so that any changes in decision statements stick
    public static void main(String[] args) throws Exception
    {
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

        BufferedReader jFile = new BufferedReader(new FileReader(new File(args[1]))); //new Buffered reader to take input of jumbled words

        while(jFile.ready())
        {
            jumbled.add(jFile.readLine());
        }
        Collections.sort(jumbled);
        Collections.sort(dictionary);

        for (String dWord : dictionary)
        {
            String sortedDword = alphabetize( dWord );
            if (!hashBrown.containsKey(sortedDword))
            {
            hashBrown.put(sortedDword, dWord);
            }
            else
            {
            hashBrown.put(sortedDword, hashBrown.get(sortedDword) + " " + dWord );
            }
        }
        // NOW JUST "LOOKUP" EACH JUMBLED WORD IN THE ANSWER KEY TABLE
        for (String jWord : jumbled)
        {
            String sortedJword = alphabetize( jWord );
            System.out.print(jWord + " ");
            if(hashBrown.containsKey(sortedJword))
            {
            System.out.println(hashBrown.get(sortedJword));
            }
            else
            {
            System.out.println("");
            }
        }



    }
    public static String alphabetize(String s1)
    {
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        String f = new String(chars1);
        return f;

    }
}
