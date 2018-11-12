import java.util.*;
import java.io.*;

public class C{
    public static void main(String args[])throws Exception
    {
        BufferedReader infile = new BufferedReader(new FileReader(args[0]));
		HashMap<String,Integer> histogram = new HashMap<String,Integer>();
		
		
		
		String word = infile.readLine();
		
        
		if(histogram.containsKey(word))
		{
			histogram.put(word, histogram.get(word)+1);
		}
		else
		{
			histogram.put(word,1);
		}
        System.out.println(histogram);
    }
}