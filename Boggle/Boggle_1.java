import java.io.*;
import java.util.*;

public class Boggle_1
{
	static ArrayList<String> dictionary = new ArrayList<String>();
	static TreeSet<String> finalDictonary = new TreeSet<String>();
    public static void main(String[] args) throws Exception
	{
		
		
		BufferedReader dictFile = new BufferedReader(new FileReader("dictionary.txt"));

		while(dictFile.ready())
		{
			dictionary.add(dictFile.readLine());
		}
		dictFile.close();
		Collections.sort(dictionary);
		String[][] board = loadBoggleBoard(args[0]);  
			for(int row = 0; row < board.length; row++)
			{
				for(int col = 0; col < board[row].length; col++)
				{
					dfs(row, col, board, "");
				}
			}

   		Iterator iterator;
   		iterator = finalDictonary.iterator();
      
  		 while (iterator.hasNext()){
   		System.out.println(iterator.next());
}
			
	} // END MAIN

	private static String[][] loadBoggleBoard( String infileName) throws Exception
	{	
		Scanner infile = new Scanner( new File(infileName) );
		infile.nextLine();//number skip
		int rows = 0;
		while(infile.hasNextLine()) 
		{    
    		rows++;
    		infile.nextLine();
		}
		int col = rows;
		infile.close();

		infile = new Scanner( new File(infileName) );
		infile.nextLine();
		String[][] boggleBoard = new String[rows][col];
		for(int r = 0; r < rows  ; r++)
			for(int c = 0; c < col; c++)
			{
				boggleBoard[r][c] = infile.next();
			}
		infile.close();
		return boggleBoard;
	}
	 private static void dfs(int r, int c, String[][] boggleBoard, String path )
    {	

   		path = path + boggleBoard[r][c];
   		int index = Collections.binarySearch(dictionary, path);
   		if(index < 0)
   		{
   			if(!(dictionary.get(-index-1).startsWith(path)))
   			{
   				return;
   			}
   		} 
   		else
   		{
   			if(dictionary.get(index).length() >= 3)
   			finalDictonary.add(dictionary.get(index));
   		}
   		
		
		if(r-1 >= 0)
		if(boggleBoard[r-1][c].equals(boggleBoard[r-1][c].toLowerCase()))//north
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r-1, c, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
		if((r-1 >= 0)  && (c + 1 < boggleBoard[r].length))
		if(boggleBoard[r-1][c+1].equals(boggleBoard[r-1][c+1].toLowerCase()))//northwest
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r-1, c+1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
		if(c+1 < boggleBoard[r].length)
		if(boggleBoard[r][c+1].equals(boggleBoard[r][c+1].toLowerCase()))//west
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r, c+1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
		if((r+1  < boggleBoard.length) && (c+1  < boggleBoard[r].length))
		if(boggleBoard[r+1][c+1].equals(boggleBoard[r+1][c+1].toLowerCase()))//southwest
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r+1, c+1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
		if(r+1  < boggleBoard.length)
		if(boggleBoard[r+1][c].equals(boggleBoard[r+1][c].toLowerCase()))//south
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r+1, c, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
		if((c-1 >= 0) && (r+1  < boggleBoard.length))
		if(boggleBoard[r+1][c-1].equals(boggleBoard[r+1][c-1].toLowerCase()))//southeast
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r+1, c-1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
		if(c-1 >= 0)
		if(boggleBoard[r][c-1].equals(boggleBoard[r][c-1].toLowerCase()))//east
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r, c-1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
		if((r-1 >= 0) && (c -1 >= 0))
		if(boggleBoard[r-1][c-1].equals(boggleBoard[r-1][c-1].toLowerCase()))//northeast
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r-1, c-1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
	
		return;
	}


	
}
	
	


