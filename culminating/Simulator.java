package culminating;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.Timer;
import java.text.DecimalFormat;

public class Simulator extends JFrame
{
    private JPanel contentPanel, contentInputPanel, contentOutputPanel, buttonInputPanel
	, inputPanel, statsPanel, sliderPanel, graphicsPanel;
    static JFrame frame;
    static JSlider angleSlider, velocitySlider, massSlider;
    static JLabel angleLabel, velocityLabel, massLabel;
    private JButton graphButton;

    private int animationSpeed = 1;
    private Timer timer;
    private static final double GRAVITY = -9.81;
    private static double velocityX, velocityY, positionX, positionY, startX = 10, startY = 415;
    public static double angle, velocity, mass
	, heightMax = 0, distanceMax = 0, kineticEnergy = 0, gravitationalEnergy = 0
	, time, changeInTime = 0.02;
    GraphicsCanvas graphics;

    private static JLabel[] statsLabels = {
	new JLabel ("- STATS -", JLabel.CENTER),
	new JLabel ("Time (s): 0", JLabel.LEFT),
	new JLabel ("Height Max (px): 0", JLabel.LEFT),
	new JLabel ("Distance Max (px): 0", JLabel.LEFT),
	new JLabel ("Kinetic Energy (J): 0", JLabel.LEFT),
	new JLabel ("Gravitational Energy (J): 0     ", JLabel.LEFT),
	new JLabel (" "),
	new JLabel (" "),
	new JLabel (" ")
	};

    private JButton[] controlButtons = {
	new JButton ("Home"),
	new JButton ("Simulate!"),
	new JButton ("Reset"),
	};

    public Simulator ()
    {
	// Initialize JPanel objects
	contentPanel = new JPanel ();
	contentPanel.setBackground (Style.BERMUDA);
	contentPanel.setLayout (new BorderLayout (10, 10));
	contentPanel.setBorder (new EmptyBorder (10, 10, 10, 10));

	statsPanel = new JPanel ();
	statsPanel.setLayout (new GridLayout (10, 0, 0, 0));
	statsPanel.setBorder (new EmptyBorder (10, 10, 10, 10));
	statsPanel.setBackground (Color.GREEN);

	contentInputPanel = new JPanel (new GridLayout (2, 0, 0, 15));
	contentInputPanel.setBorder (new EmptyBorder (0, 10, 0, 10));
	buttonInputPanel = new JPanel ();
	sliderPanel = new JPanel (new GridLayout (2, 1));

	graphicsPanel = new JPanel ();
	graphicsPanel.setBackground (Color.white);
	GraphicsCanvas graphics = new GraphicsCanvas ();
	graphicsPanel.add (graphics);
	positionX = 10;
	positionY = 415;


	//////////////////// SLIDERS ///////////////////////////////////////

	angleSlider = new JSlider (1, 92, 45);
	angleLabel = new JLabel ("Angle (°): 30");
	angleLabel.setFont (Style.TEXT_FONT);
	angleSlider.setPaintTrack (true);
	angleSlider.setPaintTicks (true);
	angleSlider.setPaintLabels (true);
	angleSlider.setMajorTickSpacing (13);
	angleSlider.addChangeListener (new ChangeListener ()
	{
	    public void stateChanged (ChangeEvent e)
	    {
		angle = angleSlider.getValue ();
		angleLabel.setText ("Angle (°): " + angle);
	    }
	}
	);

	velocitySlider = new JSlider (1, 101, 101);
	velocityLabel = new JLabel ("Velocity (px/s): 100");
	velocityLabel.setFont (Style.TEXT_FONT);
	velocitySlider.setPaintTrack (true);
	velocitySlider.setPaintTicks (true);
	velocitySlider.setPaintLabels (true);
	velocitySlider.setMajorTickSpacing (25);
	velocitySlider.addChangeListener (new ChangeListener ()
	{
	    public void stateChanged (ChangeEvent e)
	    {
		velocity = velocitySlider.getValue ();
		velocityLabel.setText ("Velocity (px/s): " + velocity);
	    }
	}

	);

	massSlider = new JSlider (0, 10, 5);
	massLabel = new JLabel ("Mass (g): 5");
	massLabel.setFont (Style.TEXT_FONT);
	massSlider.setPaintTrack (true);
	massSlider.setPaintTicks (true);
	massSlider.setPaintLabels (true);
	massSlider.setMajorTickSpacing (2);
	massSlider.addChangeListener (new ChangeListener ()
	{
	    public void stateChanged (ChangeEvent e)
	    {
		mass = massSlider.getValue ();
		massLabel.setText ("Mass (g): " + mass);
	    }
	}
	);

	sliderPanel.add (angleLabel);
	sliderPanel.add (velocityLabel);
	sliderPanel.add (massLabel);
	sliderPanel.add (angleSlider);
	sliderPanel.add (velocitySlider);
	sliderPanel.add (massSlider);


	for (int i = 0 ; i < 9 ; i++)
	{
	    statsPanel.add (statsLabels [i]);
	    statsLabels [i].setFont (Style.TEXT_FONT);
	}

	graphButton = new JButton ("Show Table");
	graphButton.setFont (Style.CONTROL_BUTTON_FONT);

	statsPanel.add (graphButton);

	contentInputPanel.add (sliderPanel);
	contentInputPanel.add (buttonInputPanel);

	for (int i = 0 ; i < 3 ; i++)
	{
	    buttonInputPanel.add (controlButtons [i]);
	    controlButtons [i].setFont (Style.CONTROL_BUTTON_FONT);
	    controlButtons [i].setBackground (Color.YELLOW);
	    controlButtons [i].addActionListener (new ControlBttnListener ());
	}

	contentPanel.add (graphicsPanel, BorderLayout.CENTER);
	contentPanel.add (contentInputPanel, BorderLayout.SOUTH);
	contentPanel.add (statsPanel, BorderLayout.EAST);

	frame = new JFrame ("Test");
	frame.getContentPane ().add (contentPanel);
	frame.setSize (1250, 700);
	frame.setResizable (false);
	frame.setVisible (true);

    } // Constructor


    // Handles button click events
    private class ControlBttnListener implements ActionListener
    {
	public void actionPerformed (ActionEvent event)
	{
	    Object buttonClicked = event.getSource ();
	    if (buttonClicked == controlButtons [0]) // Navigates back to home
	    {
		frame.dispose ();
		SimulatorMenu simulatorFrame = new SimulatorMenu ();
	    }
	    else if (buttonClicked == controlButtons [1]) // Runs simulate class
	    {
		angle = angleSlider.getValue ();
		velocity = velocitySlider.getValue ();
		mass = massSlider.getValue ();
		timer = new Timer (animationSpeed, new TimerListener ());
		startSimulation ();

	    }
	    else if (buttonClicked == controlButtons [2]) // Resets slider values
	    {
		resetValues ();
	    }
	    else if (buttonClicked == graphButton)
	    {
		// Graph the stats
	    }
	}
    }


    public void startSimulation ()
    {
	setUserInput ();
	timer.start ();
    }


    public static void setUserInput ()
    {
	DecimalFormat df = new DecimalFormat ("#######.0");
	kineticEnergy = (0.5 * mass * (Math.pow (velocity, 2)));
	gravitationalEnergy = (mass * GRAVITY * 30);

	statsLabels [1].setText ("Time (s): 0");
	statsLabels [2].setText ("Height Max (px): 0");
	statsLabels [3].setText ("Distance Max (px): 0");
	statsLabels [4].setText ("Kinetic Energy (J): " + df.format (kineticEnergy));
	statsLabels [5].setText ("Gravitational Energy (J): " + df.format (gravitationalEnergy));

	velocityX = velocity * Math.cos (angle * (Math.PI / 180));
	velocityY = velocity * Math.sin (angle * (Math.PI / 180));
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
	angleSlider.setValue (30);
	velocitySlider.setValue (50);
	massSlider.setValue (5);
	
	positionX = 10;
	positionY = 415;

	time = 0;
	heightMax = 0;
	distanceMax = 0;
	kineticEnergy = 0;
	gravitationalEnergy = 0;

	statsLabels [1].setText ("Time (s): 0");
	statsLabels [2].setText ("Height Max (px): 0");
	statsLabels [3].setText ("Distance Max (px): 0");
	statsLabels [4].setText ("Kinetic Energy (J): 0");
	statsLabels [5].setText ("Gravitational Energy (J): 0      ");

	if (time > 0)
	{
	    timer.stop (); 
	}

    }


    private boolean isInScreen ()
    {
	if ((positionX < 0 || positionX > 906) || (positionY > 429))
	{
	    return false;
	}
	// System.out.println ("X: " + positionX + " Y: " + positionY);
	return true;
    }


    public class GraphicsCanvas extends JPanel
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
	    repaint ();

	    // Place the drawing code here
	} // paint method
    }


    class TimerListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    launchBall ();

	    if (!isInScreen ())
	    {
		timer.stop ();
	    }

	}
    }
} // NikkiGuo_Culminating class


