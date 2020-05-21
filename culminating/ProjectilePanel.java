package culminating;

import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;

public class ProjectilePanel extends JPanel
{
    GraphicsCanvas graphics;
    static int startMass, startHeight, velocity;
    static double startAngle, velocityX, velocityY;

    private int animationSpeed = 1;
    private Timer timer;
    public static double kE, gE, time, changeInTime = 0.02;
    private static final double GRAVITY = -9.81;
    private double positionX, positionY, startX = 10, startY = 415;

    public ProjectilePanel ()
    {
	GraphicsCanvas graphics = new GraphicsCanvas ();
	this.add (graphics);
	this.setPreferredSize (new Dimension (906, 444));
	this.setBackground (Color.WHITE);
	timer = new Timer (animationSpeed, new TimerListener ());
	positionX = 10;
	positionY = 415;

    } // Constructor


    public void startSimulation ()
    {
	setUserInput ();
	timer.start ();
    }


    public static void setUserInput ()
    {
	DecimalFormat df = new DecimalFormat ("#######.0");
	kE = (0.5 * Simulator.mass * (Math.pow (Simulator.velocity, 2)));
	gE = (Simulator.mass * GRAVITY * 30);

	Simulator.statsLabels [1].setText ("Time (s): 0");
	Simulator.statsLabels [2].setText ("Height Max (px): 0");
	Simulator.statsLabels [3].setText ("Distance Max (px): 0");
	Simulator.statsLabels [4].setText ("Kinetic Energy (J): " + df.format (kE));
	Simulator.statsLabels [5].setText ("Gravitational Energy (J): " + df.format (gE));

	velocityX = Simulator.velocity * Math.cos (Simulator.angle * (Math.PI / 180));
	velocityY = Simulator.velocity * Math.sin (Simulator.angle * (Math.PI / 180));
    }


    private void launchBall ()
    {
	positionX = startX + (velocityX * time);
	positionY = Math.abs (startY - ((velocityY * time) - (0.5 * GRAVITY * Math.pow (time, 2))));
	time += changeInTime;

	//System.out.println ("X: " + positionX + " Y: " + positionY);
    }


    private void resetValues ()
    {
	positionX = 10;
	positionY = 415;
	/*
	startAngle = 45;
	velocity = 101;
	startMass = 5;
	*/
	
    }


    private boolean isInScreen ()
    {
	if ((positionX < 0 || positionX > getWidth ())
		|| (positionY > (getHeight () - 15)))
	{
	    return false;
	}
	return true;
    }


    class GraphicsCanvas extends JPanel
    {
	public GraphicsCanvas ()
	{
	    this.setPreferredSize (new Dimension (906, 444));
	    this.setBackground (Color.orange);
	}

	public void paint (Graphics g)
	{
	    super.paint (g);
	    g.setColor (Color.green);
	    g.drawRect (0, 390, 967, 53);
	    g.fillRect (0, 390, 967, 53);

	    Graphics2D ball = (Graphics2D) g;
	    ball.setColor (Color.red);
	    ball.fillOval ((int) positionX, (int) positionY, 15, 15);

	    // Place the drawing code here
	} // paint method
    }


    class TimerListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    launchBall ();
	    repaint ();
	    if (!isInScreen ())
	    {
		timer.stop ();
		resetValues ();
	    }

	}
    }
} // Projectile class
