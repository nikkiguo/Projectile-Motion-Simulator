package culminating;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.Timer;

public class ProjectilePanel extends JPanel
{
    GraphicsCanvas graphics;
    static int startMass, startHeight, velocity;
    static double startAngle, velocityX, velocityY;

    private int animationSpeed = 20;
    private Timer timer;
    public static double kineticEnergy, gravitationalEnergy;
    private static final double GRAVITY = 9.81;

    public ProjectilePanel ()
    {
	GraphicsCanvas graphics = new GraphicsCanvas ();
	this.add (graphics);
	this.setPreferredSize (new Dimension (518, 444));
	this.setBackground (Color.WHITE);
	timer = new Timer (animationSpeed, new TimerListener ());

    } // Constructor


    public void startSimulation ()
    {
	timer.start ();
    }


    public static void updateStats ()
    {
	kineticEnergy = (0.5 * Simulator.mass *(Math.pow(Simulator.velocity,2)));
    
    }


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
	    g.setColor (Color.black);
	    g.drawOval (10, 415, 15, 15);
	    g.fillOval (10, 415, 15, 15);

	    // Place the drawing code here
	} // paint method
    }


    class TimerListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{


	}
    }
} // Projectile class
