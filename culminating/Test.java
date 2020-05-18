package culminating;

import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame
{
    private JPanel contentPanel, contentInputPanel, contentOutputPanel, buttonInputPanel
	, inputPanel, statsPanel, sliderPanel, realTimePanel, graphicsPanel;
    static JFrame frame;
    static JSlider angleSlider, velocitySlider, massSlider, heightSlider;
    static JLabel angleLabel, velocityLabel, massLabel, heightLabel;
    private JButton graphButton;

    private JLabel[] statsLabels = {
	new JLabel ("- STATS -", JLabel.CENTER),
	new JLabel (" Time (s): ", JLabel.LEFT),
	new JLabel (" Height Max (m): ", JLabel.LEFT),
	new JLabel (" Distance Max (m): ", JLabel.LEFT),
	new JLabel (" Kinetic Energy (J): ", JLabel.LEFT),
	new JLabel (" Gravitational Energy (J): ", JLabel.LEFT),
	new JLabel (" "),
	new JLabel (" "),
	new JLabel (" ")
	};

    private JButton[] controlButtons = {
	new JButton ("Home"),
	new JButton ("Simulate!"),
	new JButton ("Reset"),
	};

    public Test ()
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
	graphicsPanel.setBackground (Color.WHITE);

	angleSlider = new JSlider (0, 200, 120);
	angleLabel = new JLabel ("Angle (°): ");
	angleLabel.setFont (Style.TEXT_FONT);
	angleSlider.setPaintTrack (true);
	angleSlider.setPaintTicks (true);
	angleSlider.setPaintLabels (true);
	angleSlider.setMajorTickSpacing (50);
	angleSlider.setMinorTickSpacing (5);

	velocitySlider = new JSlider (0, 200, 120);
	velocityLabel = new JLabel ("Velocity (px/s): ");
	velocityLabel.setFont (Style.TEXT_FONT);
	velocitySlider.setPaintTrack (true);
	velocitySlider.setPaintTicks (true);
	velocitySlider.setPaintLabels (true);
	velocitySlider.setMajorTickSpacing (50);
	velocitySlider.setMinorTickSpacing (5);

	heightSlider = new JSlider (0, 140, 2);
	heightLabel = new JLabel ("Height (px): ");
	heightLabel.setFont (Style.TEXT_FONT);
	heightSlider.setPaintTrack (true);
	heightSlider.setPaintTicks (true);
	heightSlider.setPaintLabels (true);
	heightSlider.setMajorTickSpacing (50);
	heightSlider.setMinorTickSpacing (5);

	// angleSlider.addChangeListener (s);
	massSlider = new JSlider (0, 140, 2);
	massLabel = new JLabel ("Mass (g): ");
	massLabel.setFont (Style.TEXT_FONT);
	massSlider.setPaintTrack (true);
	massSlider.setPaintTicks (true);
	massSlider.setPaintLabels (true);
	massSlider.setMajorTickSpacing (50);
	massSlider.setMinorTickSpacing (5);

	sliderPanel.add (angleLabel);
	sliderPanel.add (velocityLabel);
	sliderPanel.add (heightLabel);
	sliderPanel.add (massLabel);

	sliderPanel.add (angleSlider);
	sliderPanel.add (velocitySlider);
	sliderPanel.add (heightSlider);
	sliderPanel.add (massSlider);


	for (int i = 0 ; i < 9 ; i++)
	{
	    statsPanel.add (statsLabels [i]);
	    statsLabels [i].setFont (Style.TEXT_FONT);
	}
	graphButton = new JButton ("Graph!");
	graphButton.setFont (Style.CONTROL_BUTTON_FONT);

	statsPanel.add (graphButton);

	contentInputPanel.add (sliderPanel);
	contentInputPanel.add (buttonInputPanel);
	
	 for (int i = 0 ; i < 3 ; i++)
	{
	    buttonInputPanel.add (controlButtons [i]);
	    controlButtons [i].setFont (Style.CONTROL_BUTTON_FONT);
	    controlButtons [i].setBackground (Color.YELLOW);
	}

	//contentPanel.add (homeButton, BorderLayout.NORTH);
	contentPanel.add (graphicsPanel, BorderLayout.CENTER);
	contentPanel.add (contentInputPanel, BorderLayout.SOUTH);
	contentPanel.add (statsPanel, BorderLayout.EAST);

	frame = new JFrame ("Test");
	frame.getContentPane ().add (contentPanel);
	frame.setSize (800, 700);
	frame.setVisible (true);
    } // Constructor


    public void paint (Graphics g)
    {
	// Place the drawing code here
    } // paint method
} // NikkiGuo_Culminating class


