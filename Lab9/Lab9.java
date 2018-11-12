import java.io.*;
import java.util.*;

public class Lab9
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader infile = new BufferedReader(new FileReader(args[0]));
		HashMap<String,Integer> histogram = new HashMap<String,Integer>();
		String word;
		
		while ( infile.ready() )
		{
			word=infile.readLine();//read file into word
                                               
            if(histogram.containsKey(word))
              histogram.replace(word, histogram.get(word)+1); //if there is word get it and plus one
            else
              histogram.put(word, 1);//else set its number to one
		}
		infile.close();
		
		
		printHistogram( histogram );
	} // END MAIN

	// YOU FILL IN THIS METHOD
	// NO PARTIAL CREDIT. YOU MUST PRINT THEM SORTED LIKE THE OUPTUT
	private static void printHistogram( HashMap<String,Integer> hm )
	{	
		  ArrayList<String> count = new ArrayList<String>(hm.keySet());//set one to count and print out hm
          Collections.sort(count);
          for(int i=0; i<count.size(); i++)
          {
             System.out.println(count.get(i) + "\t" + hm.get(count.get(i)));//get the word and get the occured nmber
          }
		/*ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		
		
		while(infile.hasNext())
		{
			String nextWord = infile.next();
			if(words.contains(nextWord))
			{
				int index = words.indexOf(nextWord);
				count.set(index, count.get(index)+1);
			}	
			else
			{
				words.add(nextWord);
				count.add(1);
			}
		}
		for (int i = 0; i < words.size(); i++)
		{
			System.out.println(words.get(i)+" "+count.get(i));
		}*/
		// YOUR CODE HERE
		/*
		if (!hashBrown.containsKey(sortedDword))
            {
            hashBrown.put(sortedDword, dWord);
            }
            else
            {
            hashBrown.put(sortedDword, hashBrown.get(sortedDword) + " " + dWord );
            }
		*/
		// YOUR CODE HERE
		// Initialize an ArrayList by feeding the keyset of the map into the ArrayList constructor
		// sort the ArrayList
		// for each key in the ArrayList println the key followed by a TAB followed by the freq.  (use hm.get(key))
	}
} // END LAB9 CLASS
/*
returns			method
void			hm.put(key,value);
value			hm.get(key);
set of ways		hm.keyset()
boolean			hm.containskey(key);

put set into arraylist
new ArrayList<String>(hm.keyset());
*/