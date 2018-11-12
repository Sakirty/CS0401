import java.util.*;
import java.io.*;

public class ArrayListDemo1
{
	public static void main(String[] args) throws Exception
	{
		if ( args.length<1 ) die("Missing input filename on command line. Try again.");
		ArrayList<String> wordList= new ArrayList<String>();  // Notice we use default C'TOr  - sets starting capacity to be 10
		BufferedReader infile = new BufferedReader( new FileReader(args[0]) );
		long startTime = System.currentTimeMillis();
		while (infile.ready()) 
			wordList.add( infile.readLine() );
		infile.close();

		long endTime = System.currentTimeMillis();
		long ms = endTime-startTime;
		double elapsedSec = ms / 1000.0;
		
		System.out.format("\nElapsed time to load %d words from infile %s into wordList was %.3f secs.\n", wordList.size(), args[0], elapsedSec);
		// the old fashioned loop way to print the elements of an ArrayList

		if ( wordList.size() > 250 ) System.exit(0); // don't print a huge list of words to screen
		
		System.out.format("\n\n***Traditional for loop to echo all %d strings from wordList:\n",wordList.size() );
		for (int i=0 ; i<wordList.size() ; ++i )
			System.out.print( wordList.get(i) + " " );//show the time
		System.out.println();
		 
		// the enhanced for loop way to print the elements of an ArrayList
		 
		System.out.format("\n\n***Enhanced for loop to echo all %d strings from wordList:\n",wordList.size() );
		for (String w: wordList)//temp string, co with wordList,taking every value in wl
			System.out.print( w + " " );
		System.out.println();
		 
		// the iterator way to print the elements of an ArrayList
		
		System.out.format("\n\n***Iterator way to echo all %d strings from wordList:\n",wordList.size() );
		Iterator<String> itr = wordList.iterator();//point to the first element in arra
		while (itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();		
		
	} // END MAIN

    private static void die( String errmsg )
    {
                System.out.println( "\nFATAL ERROR: " + errmsg + "\n" );
                System.exit(0);
    }

}//EOF
