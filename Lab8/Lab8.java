import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lab8
{  
	public static void main( String[] args)
	{
		if ( args.length<1) { System.out.println("FATAL ERROR: Missing expression on command line\nexample: java Lab8 3+13/5-16*3\n"); System.exit(0); }
		
		// Stolen directly from stackoverflow with just a few mods :)
		String expr= args[0];  // i.e. somethinig like "4+5-12/3.5-5.4*3.14"; 
		System.out.println( "expr: " + expr );
		ArrayList<String> operatorList = new ArrayList<String>();
		ArrayList<String> operandList = new ArrayList<String>();
      operatorList.clear();
		operandList.clear();
		// StringTokenizer is like an infile and calling .hasNext() that splits on + - / or *
		StringTokenizer st = new StringTokenizer( expr,"+-*/", true );
		while (st.hasMoreTokens())
		{
			String token = st.nextToken();
			if ("+-/*".contains(token))
				operatorList.add(token);
			else
				operandList.add(token);
    		}
 		System.out.println("Operators:" + operatorList);
		System.out.println("Operands:" + operandList);
		
		double result = evaluate( operatorList, operandList );//pass in two lists,write the code to evaluate this,same as SimpleCalc
		System.out.println("The expression: " + expr + " evalutes to " + result + "\n");
	} // END MAIN
	
	
	// ............................................................................................
	// Y O U  W R I T E  T H I S  M E T H O D  (WHCIH YOU MAY TRANSPLANT INTO SIMPLE CALC)
	// ............................................................................................
	
	// TAKES THE LIST Of OPERATORS ANd OPERANDS RETURNS RESULT AS A DOUBLE
	static double evaluate( ArrayList<String> operatorList, ArrayList<String> operandList)
	{
         int operatorTier = 0;
	      int operatorTier2 = 0;

			while(!operatorList.isEmpty())//while the list is not empty
			{
				if(operatorList.contains("*")||operatorList.contains("/"))//check for * and /
				{//find the position of it
					operatorTier = operatorList.indexOf("*");
					operatorTier2 = operatorList.indexOf("/");

					if (((operatorTier2 == -1) || (operatorTier < operatorTier2)) && operatorTier!=-1) //starting on the first instance of either divide or multiply
					{
						operandList.set(operatorTier,  Double.toString(Double.parseDouble(operandList.get(operatorTier))*Double.parseDouble(operandList.get(operatorTier+1))));
						operandList.remove(operatorTier + 1);
						operatorList.remove(operatorTier);

					}
					else
					{
						operandList.set(operatorTier2, Double.toString(Double.parseDouble(operandList.get(operatorTier2)) / Double.parseDouble(operandList.get(operatorTier2 + 1))));
						operandList.remove(operatorTier2 + 1);
						operatorList.remove(operatorTier2);

					}
				}
				else if(operatorList.get(0).equals("-")||operatorList.get(0).equals("+")) //do +- after * and /
				{
					operatorTier = operatorList.indexOf("+");
					operatorTier2 = operatorList.indexOf("-");
					if (operatorTier2==-1)
					{
						operandList.set(operatorTier, Double.toString(Double.parseDouble(operandList.get(operatorTier)) + Double.parseDouble(operandList.get(operatorTier+1))));
						operandList.remove(operatorTier+1);
						operatorList.remove(operatorTier);

					}
					else
					{
						operandList.set(operatorTier2, Double.toString(Double.parseDouble(operandList.get(operatorTier2)) - Double.parseDouble(operandList.get(operatorTier2+1))));
						operandList.remove(operatorTier2+1);
						operatorList.remove(operatorTier2);
					}
				}
			}
			return Double.parseDouble(operandList.get(0)); 
      //do that operater to operands at index and index+1,then overwrite result into operands[index]      
      //remove the 2nd operands and that operators
      //do another loop for -+
      //answer is in operands.get(0)
      
		// STEP #1	SUGGEST YOU COPY/CONVERT THE OPERANDS LIST INTO A LIST OF DOUBLES
	
		// 	NOW YOU HAVE AN ARRAYLIST OF STRINGS (OPERATORS) AND ANOTHER OF DOUBLES (OPERANDS)

		// FIRST PROCESS  ALL * and / operators FROM THE LIST

		// SECOND PROCESS  ALL + and - operators FROM THE LIST
		
		// return operands.get(0); // IT SHOULD BE THE ONLY THING LEFT IN OPERANDS
		
		// just to make it compile. you should return the .get(0) of operands list
	}
} // END LAB8
