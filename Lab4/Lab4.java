/* Lab4.java  Reads two files into two arrays then checks both arrays for dupes */

import java.io.*;
import java.util.*;

public class Lab4
{
	static final int INITIAL_CAPACITY = 10;
	static final int NOT_FOUND = -1; // indexOfFirstDupe returns this value if no dupes found
	public static void main (String[] args) throws Exception
	{
		// ALWAYS TEST FIRST TO VERIFY USER PUT REQUIRED INPUT FILE NAME ON THE COMMAND LINE
		if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Lab4 <numbers file> <words filename>\n\n"); // i.e. C:\> java Lab4 10000ints.txt 172822words.txt
			System.exit(0);
		}

		String[] wordList = new String[INITIAL_CAPACITY];
		int[] intList  =  new int[INITIAL_CAPACITY];
		int wordCount = 0, intCount=0;

		Scanner intFile = new Scanner( new File(args[0]) );
		BufferedReader wordFile = new BufferedReader( new FileReader(args[1]) );

		// P R O C E S S   I N T   F I L E 
		while ( intFile.hasNextInt() ) // i.e. while there are more ints in the file
		{	if ( intCount == intList.length ) 
				intList = upSizeArr( intList );
			intList[intCount++] = intFile.nextInt();
		} //END WHILE intFile
		intFile.close(); 
		System.out.format( "%s loaded into intList array. size=%d, count=%d\n",args[0],intList.length,intCount );
		int dupeIndex = indexOfFirstDupe( intList, intCount );
		if ( dupeIndex == NOT_FOUND )
			System.out.format("No duplicate values found in intList\n");
		else
			System.out.format("First duplicate value in intList found at index %d\n",dupeIndex);


		// P R O C E S S   S T R I N G    F I L E
		while ( wordFile.ready() ) // i.e. while there is another line (word) in the file
		{	if ( wordCount == wordList.length ) 
				wordList = upSizeArr( wordList );
			wordList[wordCount++] = wordFile.readLine();
		} //END WHILE wordFile
		wordFile.close(); 
		System.out.format( "%s loaded into word array. size=%d, count=%d\n",args[1],wordList.length,wordCount );
		dupeIndex = indexOfFirstDupe( wordList, wordCount );
		if ( dupeIndex == NOT_FOUND )
			System.out.format("No duplicate values found in wordList\n");
		else
			System.out.format("First duplicate value in wordList found at index %d\n",dupeIndex);

	} // END MAIN

	//##################################################################################################
	// FYI. Methods that don't say private are by default, private.

	// copy/adapt your working code from lab3 || project3
	static String[] upSizeArr( String[] fullArr )
	{
		String[] arrnew = new String[fullArr.length*2];
          
        for(int i = 0; i < fullArr.length; ++i){
            arrnew[i] = fullArr[i];
        }
        return arrnew;

	}
	// copy/adapt your working code from lab3 || project3
	static int[] upSizeArr( int[] fullArr )
	{
		int[] arrnew = new int[fullArr.length*2];
 
        for (int i = 0; i < fullArr.length; i++){
            arrnew[i] = fullArr[i];
        }
        return arrnew;
	}

	// use Arrays.sort() before scanning for dupe
	static int indexOfFirstDupe( int[] arr, int count )
	{	int[] arrnew = new int[count];
		for (int i = 0; i < count; i++){
			arrnew[i] = arr[i];
		}	
		Arrays.sort(arrnew);
		for (int i = 0; i < arrnew.length; i++){
			for (int k = i +1; k < arrnew.length; k++){
				if (arrnew[i] == arrnew[k]){
					return k;
				}
			}
		}
		return NOT_FOUND;
	}

	// use Array.sort() before scanning for dupe
	static int indexOfFirstDupe( String[] arr, int count )
	{	
		String[] arrnew = new String[count];
		for (int i = 0; i < count; i++){
			arrnew[i] = arr[i];
		}	
		Arrays.sort(arrnew);
		/*String tempo;
		for (int i = 0; i < arrnew.length; i++){
			for (int o = i + 1; o < arrnew.length; o++){
			if (arrnew[o] < arrnew[i]){
				tempo = arrnew[i];
				arrnew[i] = arrnew[o];
				arrnew[o] = tempo;
				}
			}
		}*/
		for (int i = 0; i < arrnew.length; i++){
			for (int k = i +1; k < arrnew.length; k++){
				if (arrnew[i].equals(arrnew[k])){
					return k;
				}
			}
		}
			return NOT_FOUND;
}

} // END CLASS LAB#4