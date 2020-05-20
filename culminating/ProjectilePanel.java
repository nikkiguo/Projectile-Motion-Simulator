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

    private int animationSpeed = 1;
    private Timer timer;
    public static double kE, gE, time, changeInTime = 0.01;
    private static final double GRAVITY = 9.81;
    private double positionX, positionY, startX = 10, startY = 415;

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
	setUserInput ();
	timer.start ();
    }


    public static void setUserInput ()
    {
	kE = (0.5 * Simulator.mass * (Math.pow (Simulator.velocity, 2)));
	gE = (Simulator.mass * GRAVITY * 30);
	velocityX = Simulator.velocity * Math.cos (Simulator.angle * (Math.PI / 180));
	velocityY = Simulator.velocity * Math.sin (Simulator.angle * (Math.PI / 180));
	System.out.println(velocityX);
	System.out.println(velocityY);
	}


    private void launchBall ()
    {
	positionX = startX + (velocityX * time);
	positionY = Math.abs(startY + ((velocityY * time) - (0.5 * GRAVITY * Math.pow (time, 2))));
	time += changeInTime;
	// System.out.println(positionX  + " " + positionY);
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

	    Graphics2D ball = (Graphics2D) g;
	    ball.setColor (Color.red);
	    ball.fillOval((int) positionX, (int) positionY, 15, 15);
	    

	    // Place the drawing code here
	} // paint method
    }


    class TimerListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    launchBall ();
	    repaint();

	}
    }
} // Projectile class
