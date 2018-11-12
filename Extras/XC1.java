import java.io.*;
import java.util.*;

// EXPECTS TWO POSITIVE NUMBERS ON THE COMMAND LINE
// C:\> java XC1 3 6
public class XC1
{
	System.out.println("\u8D75");
	public static void main( String[] args )
	{
		int a = Integer.parseInt( args[0] );
		int b = Integer.parseInt( args[1] );

		System.out.println( "Product of " + a + " * " + b + " = " + product(a,b) );
	}
	static int product( int a, int b )
	{
		if (b<1) return 0;
		else return a + product(a,b-1);
		 // YOUR CODE HERE. NO LOOPS NO * OPERATOR
	}
}
