import java.io.*;
import java.util.*;

public class Boggle
{   
    static ArrayList<String> dictionary = new ArrayList<String>();
	static TreeSet<String> finalDictionary = new TreeSet<String>();
    
     public static void main(String[] args) throws Exception
    {
        BufferedReader dictFile = new BufferedReader(new FileReader("dictionary.txt"));//read in the dictionary and add it to file

		while(dictFile.ready())
		{
			dictionary.add(dictFile.readLine());
		}
		dictFile.close();
		Collections.sort(dictionary);
		String[][] board = load(args[0]);  
			for(int row = 0; row < board.length; row++)
			{
				for(int col = 0; col < board[row].length; col++)
				{
					dfs(row, col, board, "");
				}
			}

   		Iterator iterator;
   		iterator = finalDictionary.iterator();
      
  		while (iterator.hasNext()){
   		System.out.println(iterator.next());
    }
    }
    private static String[][] load( String infileName) throws Exception
	{	
		Scanner infile = new Scanner( new File(infileName) );
		infile.nextLine();
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
    private static void dfs(int r, int c, String[][] boggleBoard, String path)//To find the word/path for 8 directions
    {	//PROJECT#9

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
   			finalDictionary.add(dictionary.get(index));
   		}
   		
		
		if(r-1 >= 0)
		if(boggleBoard[r-1][c].equals(boggleBoard[r-1][c].toLowerCase()))//UP
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r-1, c, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
		
		if((r-1 >= 0)  && (c + 1 < boggleBoard[r].length))
		if(boggleBoard[r-1][c+1].equals(boggleBoard[r-1][c+1].toLowerCase()))//UP-LEFT
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r-1, c+1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}

		if(c+1 < boggleBoard[r].length)
		if(boggleBoard[r][c+1].equals(boggleBoard[r][c+1].toLowerCase()))//LEFT
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r, c+1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}

		if((r+1  < boggleBoard.length) && (c+1  < boggleBoard[r].length))
		if(boggleBoard[r+1][c+1].equals(boggleBoard[r+1][c+1].toLowerCase()))//DOWN-LEFT
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r+1, c+1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}

		if(r+1  < boggleBoard.length)
		if(boggleBoard[r+1][c].equals(boggleBoard[r+1][c].toLowerCase()))//DOWN
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r+1, c, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
		if((c-1 >= 0) && (r+1  < boggleBoard.length))
		if(boggleBoard[r+1][c-1].equals(boggleBoard[r+1][c-1].toLowerCase()))//DOWN-RIGHT
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r+1, c-1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}

		if(c-1 >= 0)
		if(boggleBoard[r][c-1].equals(boggleBoard[r][c-1].toLowerCase()))//RIGHT
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r, c-1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}

		if((r-1 >= 0) && (c -1 >= 0))
		if(boggleBoard[r-1][c-1].equals(boggleBoard[r-1][c-1].toLowerCase()))//UP-RIGHT
		{
			boggleBoard[r][c] = boggleBoard[r][c].toUpperCase();
			dfs(r-1, c-1, boggleBoard, path);
			boggleBoard[r][c] = boggleBoard[r][c].toLowerCase();
		}
	
		return;
	}

    

   
}
