/*
 * Nikki Guo - Projectile Motion Simulator - SIMULATOR.JAVA
 * This class contains customized style features in the program that
 * repeat, and these objects are called in the other classes
*/

package CA_NikkiGuo;

// Import select Java packages
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
    // Intialize variables and objects in the JFrame
    private JPanel contentPanel, contentInputPanel, buttonInputPanel
	, statsPanel, sliderPanel, graphicsPanel;
    private JButton graphButton;
    private int animationSpeed = 1;
    private Timer timer;
    private static final double GRAVITY = -9.81;
    private static double velocityX, positionX, positionY, startX = 10, startY = 415;
    private static double angle, velocity, mass
	, heightMax = 0, distanceMax = 0, kineticEnergy = 0, gravitationalEnergy = 0
	, time, changeInTime = 0.02;
    public static double velocityY;
    static JFrame frame;
    static JSlider angleSlider, velocitySlider, massSlider;
    static JLabel angleLabel, velocityLabel, massLabel;
    GraphicsCanvas graphics;

    // Declare JLabel stats array
    private static JLabel[] statsLabels = {
	new JLabel ("- STATS -", JLabel.CENTER),
	new JLabel ("Time (s): 0", JLabel.LEFT),
	new JLabel ("Height Max (px): 0", JLabel.LEFT),
	new JLabel ("Distance Max (px): 0", JLabel.LEFT),
	new JLabel ("Kinetic Energy (J): 0", JLabel.LEFT),
	new JLabel ("Gravitational Energy (J): 0       ", JLabel.LEFT),
	new JLabel (" "),
	new JLabel (" "),
	new JLabel (" ")
	};

    // Declare JButton controls array
    private JButton[] controlButtons = {
	new JButton ("Home"),
	new JButton ("Simulate!"),
	new JButton ("Reset"),
	};

    // Simulator constructor
    public Simulator ()
    {
	// Create JPanel object as parent JPanel and customize colour/layout
	contentPanel = new JPanel ();
	contentPanel.setBackground (Style.CORAL_RED);
	contentPanel.setLayout (new BorderLayout (10, 10));
	contentPanel.setBorder (new EmptyBorder (10, 10, 10, 10));

	// Create JPanel object with layout to store stats during simulation
	statsPanel = new JPanel ();
	statsPanel.setLayout (new GridLayout (10, 0, 0, 0));
	statsPanel.setBorder (new EmptyBorder (10, 10, 10, 10));
	statsPanel.setBackground (Style.SUN_YELLOW);

	// Create JPanel object to oraganise input panels (buttons and sliders)
	contentInputPanel = new JPanel (new GridLayout (2, 0, 0, 15));
	contentInputPanel.setBorder (new EmptyBorder (0, 10, 0, 10));
	contentInputPanel.setBackground (Style.AQUA);

	// Create JPanel objects with layout manager for button and slider
	buttonInputPanel = new JPanel ();
	buttonInputPanel.setBackground (Style.AQUA);
	sliderPanel = new JPanel (new GridLayout (2, 1));
	sliderPanel.setBackground (Style.AQUA);

	// Create JPanel object for graphics and add GraphicsCanvas class
	graphicsPanel = new JPanel ();
	graphicsPanel.setBackground (Style.LAVENDER);
	GraphicsCanvas graphics = new GraphicsCanvas ();
	graphicsPanel.add (graphics);

	// Set initial position of ball
	positionX = 10;
	positionY = 415;

	// Create JSlider object and add min, max, default values
	angleSlider = new JSlider (1, 90, 45);
	angleLabel = new JLabel ("Angle (°): 45");
	angleLabel.setFont (Style.TEXT_FONT);
	angleSlider.setPaintTrack (true);
	angleSlider.setPaintTicks (true);
	angleSlider.setPaintLabels (true);
	angleSlider.setMajorTickSpacing (13);
	angleSlider.setBackground (Style.AQUA);
	// Add change listener to slider to change JLabel number
	angleSlider.addChangeListener (new SlideChangeListener ());

	// Create JSlider object and add min, max, default values
	velocitySlider = new JSlider (1, 100, 100);
	velocityLabel = new JLabel ("Velocity (px/s): 100");
	velocityLabel.setFont (Style.TEXT_FONT);
	velocitySlider.setPaintTrack (true);
	velocitySlider.setPaintTicks (true);
	velocitySlider.setPaintLabels (true);
	velocitySlider.setMajorTickSpacing (25);
	velocitySlider.setBackground (Style.AQUA);
	// Add change listener to slider to change JLabel number
	velocitySlider.addChangeListener (new SlideChangeListener ());

	// Create JSlider object and add min, max, default values
	massSlider = new JSlider (0, 10, 5);
	massLabel = new JLabel ("Mass (g): 5");
	massLabel.setFont (Style.TEXT_FONT);
	massSlider.setPaintTrack (true);
	massSlider.setPaintTicks (true);
	massSlider.setPaintLabels (true);
	massSlider.setMajorTickSpacing (2);
	massSlider.setBackground (Style.AQUA);
	// Add change listener to slider to change JLabel number
	massSlider.addChangeListener (new SlideChangeListener ());

	// Add JSliders and JLabels in the JPanel
	sliderPanel.add (angleLabel);
	sliderPanel.add (velocityLabel);
	sliderPanel.add (massLabel);
	sliderPanel.add (angleSlider);
	sliderPanel.add (velocitySlider);
	sliderPanel.add (massSlider);

	// Loop through statsLabels array and add to statsPanel JPanel
	for (int i = 0 ; i < 9 ; i++)
	{
	    statsPanel.add (statsLabels [i]);
	    statsLabels [i].setFont (Style.TEXT_FONT);
	}

	// Add sliderPanel and buttonInputPanel to input JPanel
	contentInputPanel.add (sliderPanel);
	contentInputPanel.add (buttonInputPanel);

	// Loop through controlButtons array, customize button, add listener
	for (int i = 0 ; i < 3 ; i++)
	{
	    buttonInputPanel.add (controlButtons [i]);
	    controlButtons [i].setFont (Style.CONTROL_BUTTON_FONT);
	    controlButtons [i].setBackground (Style.SUN_YELLOW);
	    controlButtons [i].addActionListener (new ControlBttnListener ());
	}

	// Add child JPanels to main parent JPanel and organise layout spacing
	contentPanel.add (graphicsPanel, BorderLayout.CENTER);
	contentPanel.add (contentInputPanel, BorderLayout.SOUTH);
	contentPanel.add (statsPanel, BorderLayout.EAST);

	// Create frame object and add parent JPanel, set size and visibility
	frame = new JFrame ("Simulate!");
	frame.getContentPane ().add (contentPanel);
	frame.setSize (1250, 700);
	frame.setResizable (false);
	frame.setVisible (true);

    } // Constructor


    // Handles slider change events
    private class SlideChangeListener implements ChangeListener
    {
	public void stateChanged (ChangeEvent e)
	{
	    // Get slider object
	    Object sliderSelected = e.getSource ();

	    // Sets text based on slider chosen
	    if (sliderSelected == angleSlider)
	    {
		angle = angleSlider.getValue ();
		angleLabel.setText ("Angle (°): " + angle);
	    }
	    else if (sliderSelected == velocitySlider)
	    {
		velocity = velocitySlider.getValue ();
		velocityLabel.setText ("Velocity (px/s): " + velocity);
	    }
	    else if (sliderSelected == massSlider)
	    {
		mass = massSlider.getValue ();
		massLabel.setText ("Mass (g): " + mass);
	    }

	}

    }


    // Handles button click events
    private class ControlBttnListener implements ActionListener
    {
	public void actionPerformed (ActionEvent event)
	{
	    Object buttonClicked = event.getSource ();
	    if (buttonClicked == controlButtons [0])
	    {
		// Close current frame and run new frame class
		// Navigates back to home
		frame.dispose ();
		SimulatorMenu simulatorFrame = new SimulatorMenu ();
		resetValues ();
	    }
	    else if (buttonClicked == controlButtons [1])
	    {
		// Gets values inputted on slider and start simulation
		// Set timer for animation
		// Runs simulate method
		angle = angleSlider.getValue ();
		velocity = velocitySlider.getValue ();
		mass = massSlider.getValue ();
		timer = new Timer (animationSpeed, new TimerListener ());
		startSimulation ();

	    }
	    else if (buttonClicked == controlButtons [2])
	    {
		// Calls resetValues method
		// Resets slider values
		resetValues ();
	    }
	}
    }


    // Method to start simulation, set input and start timer
    public void startSimulation ()
    {
	// Set Simulate! button to invisible
	controlButtons [1].setVisible (false);
	controlButtons [1].setEnabled (false);
	// calculates stats on statsPanel JPanel
	setUserInput ();
	// Start timer
	timer.start ();
    }


    // Method to calculate values based on user input of velocity, angle, mass
    public static void setUserInput ()
    {
	// Declare variables and format object to round values
	double maxHeight, maxDistance, timeElapsed;
	DecimalFormat df = new DecimalFormat ("#######.0");

	// Calculate height, distance, kinetic/gravitational energy
	maxHeight = (Math.pow (velocity, 2))
	    * (Math.pow ((Math.sin (angle * (Math.PI / 180))), 2))
	    / (-2 * GRAVITY);
	maxDistance = (Math.pow (velocity, 2)
		* Math.sin (2 * (angle * (Math.PI / 180))) / (-1 * GRAVITY));
	kineticEnergy = (0.5 * mass * (Math.pow (velocity, 2)));
	gravitationalEnergy = (mass * GRAVITY * maxHeight);

	// Calculate velocity in x and y direction, uses java math class
	velocityX = velocity * Math.cos (angle * (Math.PI / 180));
	velocityY = velocity * Math.sin (angle * (Math.PI / 180));

	// Calculate time it takes for ball to land in real life
	timeElapsed = 2 * velocityY / (GRAVITY * -1);

	// Display stats in stats panel, round numbers to 1 decimal place
	statsLabels [1].setText ("Time (s): " + df.format (timeElapsed));
	statsLabels [2].setText ("Height Max (px): " + df.format (maxHeight));
	statsLabels [3].setText ("Distance Max (px): " + df.format (maxDistance));
	statsLabels [4].setText ("Kinetic Energy (J): " + df.format (kineticEnergy));
	statsLabels [5].setText ("Gravitational Energy (J): " + df.format (gravitationalEnergy));
    }


    // Method to calculate horizontal and vertical position of ball
    private void launchBall ()
    {
	// Calculates positions based on physics kinematic equations
	positionX = startX + (velocityX * time);
	positionY = Math.abs (startY - ((velocityY * time) - (0.5 * GRAVITY * Math.pow (time, 2))));
	// Increments time value
	time += changeInTime;
    }


    // Method to reset values upon clicking reset JButton
    private void resetValues ()
    {
	// Reset sliders to default values
	angleSlider.setValue (45);
	velocitySlider.setValue (100);
	massSlider.setValue (5);

	// Resets stats JLabels
	statsLabels [1].setText ("Time (s): 0");
	statsLabels [2].setText ("Height Max (px): 0");
	statsLabels [3].setText ("Distance Max (px): 0");
	statsLabels [4].setText ("Kinetic Energy (J): 0");
	statsLabels [5].setText ("Gravitational Energy (J): 0       ");

	// Reposition and repaint ball
	positionX = 10;
	positionY = 415;
	frame.repaint ();

	// Stops animation if in the middle of simulation
	if (time > 0)
	{
	    timer.stop ();
	    controlButtons [1].setVisible (true);
	    controlButtons [1].setEnabled (true);
	}


	// Reset stats values for future calculations
	time = 0;
	heightMax = 0;
	distanceMax = 0;
	kineticEnergy = 0;
	gravitationalEnergy = 0;

    }


    // Method to check if ball is in screen
    private boolean isInScreen ()
    {
	if ((positionX < 0 || positionX > 906) || (positionY > 429))
	{
	    return false;
	}

	return true;
    }


    // Displays custom graphics
    public class GraphicsCanvas extends JPanel
    {
	// GraphicsCanvas constructor
	public GraphicsCanvas ()
	{
	    this.setPreferredSize (new Dimension (916, 444));
	    this.setBackground (Style.SKY_BLUE);
	}


	// Paint method for repainting the ball
	public void paint (Graphics g)
	{
	    // Paints background
	    super.paint (g);
	    g.setColor (Style.SEA_GREEN);
	    g.drawRect (0, 390, 967, 53);
	    g.fillRect (0, 390, 967, 53);

	    // Paints the ball
	    Graphics2D ball = (Graphics2D) g;
	    ball.setColor (Color.red);
	    ball.fillOval ((int) positionX, (int) positionY, 15, 15);

	    // Place the drawing code here
	} // paint method
    }


    // Handles timing of projectile motion animation
    class TimerListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    // Calculates ball position and repaints the ball
	    launchBall ();
	    frame.repaint ();

	    // Stops timer if out of bounds, runs Table class
	    if (!isInScreen ())
	    {
		timer.stop ();
		Table tableFrame = new Table ();
		// Displays position-time values and acceleration-time values

	    }
	}
    }
} // NikkiGuo_Culminating class


