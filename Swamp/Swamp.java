import java.io.*;
import java.util.*;

// DO NOT IMPORT JAVA.LANG

public class Swamp
{
    public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2]; // row and col will be on the 2nd line of input file;
		int[][] swamp = loadSwamp( args[0], dropInPt );
		int row=dropInPt[0], col = dropInPt[1];

		//printSwamp(          "\n   SWAMP: dropped in at: ["+row+","+col+"]\n",swamp );
		System.out.println("\n   ESCAPE PATHS:\n");

		// YOUR CODE HERE. DECLARE WHATEVER OBJECTS AND VARIABLES NEEDED
		// CALL YOUR METHOD(s) TO PRINT ALL ESCAPE PATHS
		dfs(row, col, swamp, "");

	} // END MAIN

	// ###################################################

  	// DO NOT MODIFY THIS METHOD
	// ----------------------------------------------------------------
	private static void printSwamp(String label, int[][] swamp )
	{
		System.out.println( label );
		System.out.print("   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print( c + " " ) ;
		System.out.print( "\n   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");

		for(int r = 0; r < swamp.length; r++)
		{	System.out.print( r + "| ");
			for(int c = 0; c < swamp[r].length; c++)
				System.out.print( swamp[r][c] + " ");
			System.out.println("|");
		}
		System.out.print( "   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");
	}

	// DO NOT MODIFY THIS METHOD
   	// ----------------------------------------------------------------
	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
	{
		Scanner infile = new Scanner( new File(infileName) );
		int rows=infile.nextInt();
		int cols = rows;  		// ASSUME A SQUARE GRID
		dropInPt[0]=infile.nextInt();  dropInPt[1]=infile.nextInt();
		int[][] swamp = new int[rows][cols];
		for(int r = 0; r < rows ; r++)
			for(int c = 0; c < cols; c++)
				swamp[r][c] = infile.nextInt();

		infile.close();
		return swamp;
	}
	 private static void  dfs(int r, int c, int[][] swamp, String path )
    {	
		path = path + "[" + r + ", " + c + "]";

		if(r==0 || r==swamp.length-1 || c == 0 || c == swamp.length-1)
		{
			System.out.println(path);
			return;
		}	
		if(swamp[r+1][c] == 1)
		{
			swamp[r][c] = -1;
			dfs(r+1, c, swamp, path);
			swamp[r][c] = 1;
		}
		if(swamp[r+1][c+1] == 1)
		{
			swamp[r][c] = -1;
			dfs(r+1, c+1, swamp, path);
			swamp[r][c] = 1;
		}
		if(swamp[r][c+1] == 1)
		{
			swamp[r][c] = -1;
			dfs(r, c+1, swamp, path);
			swamp[r][c] = 1;
		}
		if(swamp[r-1][c+1] == 1)
		{
			swamp[r][c] = -1;
			dfs(r-1, c+1, swamp, path);
			swamp[r][c] = 1;
		}
		if(swamp[r-1][c] == 1)
		{
			swamp[r][c] = -1;
			dfs(r-1, c, swamp, path);
			swamp[r][c] = 1;
		}
		if(swamp[r-1][c-1] == 1)
		{
			swamp[r][c] = -1;
			dfs(r-1, c-1, swamp, path);
			swamp[r][c] = 1;
		}
		if(swamp[r][c-1] == 1)
		{
			swamp[r][c] = -1;
			dfs(r, c-1, swamp, path);
			swamp[r][c] = 1;
		}
		if(swamp[r+1][c-1] == 1)
		{
			swamp[r][c] = -1;
			dfs(r+1, c-1, swamp, path);
			swamp[r][c] = 1;
		}

		return;
		
		
		
		}
	}


