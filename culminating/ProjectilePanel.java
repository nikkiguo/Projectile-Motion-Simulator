package culminating;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.event.ActionEvent;

public class ProjectilePanel extends JPanel 
{
    //private int newX, newY, newVelocityX, newVelocityY;
    GraphicsCanvas graphics;
    
    public ProjectilePanel ()
    {
       //this.setBackground(Color.WHITE); 
       this.add(graphics); 

    } // Constructor


    class GraphicsCanvas extends JPanel
    {
	public GraphicsCanvas ()
	{
	    this.setPreferredSize (new Dimension (518, 444)); 
	    this.setBackground (Color.orange); 
	}

	public void paint (Graphics g)
	{
	    super.paint (g);
	    g.setColor (Color.green);
	    g.drawRect (0, 390, 517, 53);
	    g.fillRect (0, 390, 517, 53);
	    
	    // Place the drawing code here
	} // paint method
    }
} // Projectile class
