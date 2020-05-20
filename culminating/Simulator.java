package culminating;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simulator extends JFrame
{
    private JPanel contentPanel, contentInputPanel, contentOutputPanel, buttonInputPanel
	, inputPanel, statsPanel, sliderPanel;
    static JFrame frame;
    static JSlider angleSlider, velocitySlider, massSlider;
    static JLabel angleLabel, velocityLabel, massLabel;
    private JButton graphButton;
    public static int angle, velocity, mass;
    public static int time = 0, heightMax = 0, distanceMax = 0, kineticEnergy = 0
	, gravitationalEnergy = 0;
    ProjectilePanel graphics;

    public JLabel[] statsLabels = {
	new JLabel ("- STATS -", JLabel.CENTER),
	new JLabel ("Time (s): 0", JLabel.LEFT),
	new JLabel ("Height Max (px): 0", JLabel.LEFT),
	new JLabel ("Distance Max (px): 0", JLabel.LEFT),
	new JLabel ("Kinetic Energy (J): 0", JLabel.LEFT),
	new JLabel ("Gravitational Energy (J): 0", JLabel.LEFT),
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
	graphics = new ProjectilePanel();
	
	//////////////////// SLIDERS ///////////////////////////////////////

	angleSlider = new JSlider (0, 60, 30);
	angleLabel = new JLabel ("Angle (°): 30");
	angleLabel.setFont (Style.TEXT_FONT);
	angleSlider.setPaintTrack (true);
	angleSlider.setPaintTicks (true);
	angleSlider.setPaintLabels (true);
	angleSlider.setMajorTickSpacing (15);
	angleSlider.addChangeListener (new ChangeListener ()
	{
	    public void stateChanged (ChangeEvent e)
	    {
		angle = angleSlider.getValue ();
		angleLabel.setText ("Angle (°): " + angle);
	    }
	}
	);

	velocitySlider = new JSlider (0, 5, 2);
	velocityLabel = new JLabel ("Velocity (px/s): 2");
	velocityLabel.setFont (Style.TEXT_FONT);
	velocitySlider.setPaintTrack (true);
	velocitySlider.setPaintTicks (true);
	velocitySlider.setPaintLabels (true);
	velocitySlider.setMajorTickSpacing (1);
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

	graphButton = new JButton ("Graph");
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


	contentPanel.add (graphics, BorderLayout.CENTER);
	contentPanel.add (contentInputPanel, BorderLayout.SOUTH);
	contentPanel.add (statsPanel, BorderLayout.EAST);

	frame = new JFrame ("Test");
	frame.getContentPane ().add (contentPanel);
	frame.setSize (800, 700);
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
		angle = angleSlider.getValue();
		velocity = velocitySlider.getValue();
		mass = massSlider.getValue();
		graphics.startSimulation();
		
	    }
	    else if (buttonClicked == controlButtons [2]) // Resets slider values
	    {
		angleSlider.setValue (30);
		velocitySlider.setValue (50);
		massSlider.setValue (5);

		time = 0;
		heightMax = 0;
		distanceMax = 0;
		kineticEnergy = 0;
		gravitationalEnergy = 0;

		statsLabels [1].setText ("Time (s): 0");
		statsLabels [2].setText ("Height Max (px): 0");
		statsLabels [3].setText ("Distance Max (px): 0");
		statsLabels [4].setText ("Kinetic Energy (J): 0");
		statsLabels [5].setText ("Gravitational Energy (J): 0");

	    }
	    else if (buttonClicked == graphButton)
	    {
	    // Graph the stats
	    }
	}
    }
} // NikkiGuo_Culminating class


