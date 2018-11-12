// Demonstrates JPanel, GridLayout and a few additional useful graphical features.
// adapted from an example by john ramirez (cs prof univ pgh)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;
public class SimpleCalc //implements ActionListener
{
	JFrame window;  // the main window which contains everything
	Container content ;
	JButton[] digits = new JButton[12]; 
	JButton[] ops = new JButton[4];
	JTextField expression;
	JButton equals;
	JTextField result;
   ArrayList<String> operatorList = new ArrayList<String>();
	ArrayList<String> operandList = new ArrayList<String>();
	int operatorTier = 0;
	int operatorTier2 = 0;
   

 	public SimpleCalc()
	{
		window = new JFrame( "Simple Calc");
      	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = window.getContentPane();
		content.setLayout(new GridLayout(2,1)); // 2 row, 1 col
		ButtonListener listener = new ButtonListener();
		
		// top panel holds expression field, equals sign and result field  
		// [4+3/2-(5/3.5)+3]  =   [3.456]
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,3)); // 1 row, 3 col
		
		expression = new JTextField();
		expression.setFont(new Font("verdana", Font.BOLD, 16));
		expression.setText("");
		
		equals = new JButton("=");
		equals.setFont(new Font("verdana", Font.BOLD, 20 ));
		equals.addActionListener( listener ); 
		
		result = new JTextField();
		result.setFont(new Font("verdana", Font.BOLD, 16));
		result.setText("");
		
		topPanel.add(expression);
		topPanel.add(equals);
		topPanel.add(result);
						
		// bottom panel holds the digit buttons in the left sub panel and the operators in the right sub panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,2)); // 1 row, 2 col
	
		JPanel  digitsPanel = new JPanel();
		digitsPanel.setLayout(new GridLayout(4,3));	
		
		for (int i=0 ; i<10 ; i++ )
		{
			digits[i] = new JButton( ""+i );
			digitsPanel.add( digits[i] );
			digits[i].addActionListener( listener ); 
		}
		digits[10] = new JButton( "C" );
		digitsPanel.add( digits[10] );
		digits[10].addActionListener( listener ); 

		digits[11] = new JButton( "CE" );
		digitsPanel.add( digits[11] );
		digits[11].addActionListener( listener ); 		
	
		JPanel opsPanel = new JPanel();
		opsPanel.setLayout(new GridLayout(4,1));
		String[] opCodes = { "+", "-", "*", "/" };
		for (int i=0 ; i<4 ; i++ )
		{
			ops[i] = new JButton( opCodes[i] );
			opsPanel.add( ops[i] );
			ops[i].addActionListener( listener ); 
		}
		bottomPanel.add( digitsPanel );
		bottomPanel.add( opsPanel );
		
		content.add( topPanel );
		content.add( bottomPanel );
	
		window.setSize( 640,480);
		window.setVisible( true );
      //expression.setText("0");
	}

	

	// We are again using an inner class here so that we can access
	// components from within the listener.  Note the different ways
	// of getting the int counts into the String of the label
	
	class ButtonListener implements ActionListener
	{
      
		public void actionPerformed(ActionEvent e)
		{
			Component whichButton = (Component) e.getSource();
			
			for (int i=0 ; i<10 ; i++ ){
            if (whichButton == digits[i]){
					expression.setText( expression.getText() + i );
               }
			}
         if (whichButton == ops[0])
            expression.setText( expression.getText() + "+" );
         else if(whichButton == ops[1])
            expression.setText( expression.getText() + "-" );
         else if(whichButton == ops[2])
            expression.setText( expression.getText() + "*" );
         else if(whichButton == ops[3])
            expression.setText( expression.getText() + "/" );
         
         if (whichButton == digits[10]){
            expression.setText("");
            result.setText("");

         }
          
         if (whichButton == digits[11]){
            ButtonCE();  
         }
         
         if (whichButton == equals){
               result.setText(equal(expression.getText()));   
         }
         
         
			// need to add tests for other controls that may have been
			// click that got us in here. Write code to handle those
			
         
                  
			
		}
	}

 
   private void ButtonCE(){
        String text = expression.getText();
        result.setText("");
        int i = text.length();
        if (i > 0) {
            text = text.substring(0, i - 1);
            if (text.length() == 0) {
                expression.setText("");
                
            } else {
                expression.setText(text);
            }

      }
   }
	
   public String equal(String s)
		{
			ArrayList<String> operatorList = new ArrayList<String>();
			ArrayList<String> operandList = new ArrayList<String>();
			operatorList.clear();
			operandList.clear();
			StringTokenizer st = new StringTokenizer(s,"+-*/", true);//pass string, divide operators and numbers
			while (st.hasMoreTokens())
			{
				String token = st.nextToken();
				if ("+-/*".contains(token))
					operatorList.add(token);

				else
					operandList.add(token);
			}


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
			return operandList.get(0);//return the value
		}

   
   
   
   public static void main(String [] args)
	{
		new SimpleCalc();
	}
}

