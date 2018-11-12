import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Etch_A_Sketch implements MouseListener, MouseMotionListener  // NOTE multiple interfaces
{
	JFrame window;
	Container content;
	int mouseX,mouseY,oldX,oldY;
	JLabel coords;

	public Etch_A_Sketch()
	{
		JFrame window = new JFrame("Classic Etch a Sketch");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButto

		content = window.getContentPane();
		content.setLayout( new FlowLayout() );
		coords = new JLabel();
		coords.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 32));
		content.add( coords); 
		content.addMouseListener(this);        // "this" is the class that implements that listener
		content.addMouseMotionListener(this);  // "this" is the class that implements that listener
		window.setSize(640,480);
		window.setVisible(true);
	}
	// ..............................................................
	// IMPLEMENTING MOUSELISTENER REQUIRES YOU TO WRITE (OVER-RIDE) THESE METHODS 

	//when you press & release with NO MOVEMENT while pressed
	public void mouseClicked( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportEventCoords("Mouse clicked at: " + mouseX + "," + mouseY );
		
	}
	
	// when you press 
	public void mousePressed( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportEventCoords("Mouse Pressed at: " + mouseX + "," + mouseY );
		//repaint();
	}

	//when you let release after dragging
	public void mouseReleased( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportEventCoords("Mouse released at: " + mouseX + "," + mouseY );
		//repaint();
	}

	// the mouse just moved off of the JFrame
	public void mouseExited( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportEventCoords("Mouse exited at: " + mouseX + "," + mouseY );
		//repaint();
	}
	
	// the mouse just moved onto the JFrame
	public void mouseEntered( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportEventCoords("Mouse Entered at: " + mouseX + "," + mouseY );
		//repaint();
	}
	// ...............................................................
	// IMPLEMENTING MOUSEMOTIONLISTENER REQUIRES YOU WRITE (OVER-RIDE) THESE METHODS 

	// mouse is moving while pressed
	public void mouseDragged( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

		if (oldX ==0 )
		{
			oldX=mouseX;
			oldY=mouseY;
			return;
		}
		
		// draw  dot (actually small line segment) between old (x,y) and current (x,y)
		
		Graphics g = content.getGraphics(); // use g to draw onto the pane
		g.drawLine( oldX,oldY, mouseX, mouseY );
		oldX = mouseX;
		oldY = mouseY;
		reportEventCoords("Mouse Dragged at: " + mouseX + "," + mouseY );
		//repaint();
	}
	
	// moved mouse but not pressed
	public void mouseMoved( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportEventCoords("Mouse Moved at: " + mouseX + "," + mouseY );
		//repaint();
	}

	// ..............................................................

	public static void main( String[] args)
	{
		new Etch_A_Sketch();
	}
	// a helper utility
	private void reportEventCoords( String msg )
	{
		coords.setText( msg ); 
	}
}//EOF