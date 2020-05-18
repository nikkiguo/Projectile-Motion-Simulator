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

public class Simulator extends JFrame
{
    private JPanel contentPanel, contentInputPanel, contentOutputPanel
	, inputPanel, statsPanel, realTimePanel, graphicsPanel;
    static JFrame frame;
    static JSlider angleSlider, velocitySlider, massSlider, heightSlider;
    static JLabel angleLabel, velocityLabel, massLabel, heightLabel;
    private JButton graphButton, homeButton;

    private JLabel[] statsLabels = {
	new JLabel ("- STATS -\n", JLabel.CENTER),
	new JLabel (" Time (s): ", JLabel.LEFT),
	new JLabel (" Height Max (m): ", JLabel.LEFT),
	new JLabel (" Distance Max (m): ", JLabel.LEFT),
	new JLabel (" Kinetic Energy (J): ", JLabel.LEFT),
	new JLabel (" Gravitational Energy (J): ", JLabel.LEFT)
	};

    private JButton[] controlButtons = {
	new JButton ("Default"),
	new JButton ("Simulate!"),
	new JButton ("Reset")
	};

    public Simulator ()
    {
	// Initialize JPanel objects
	contentPanel = new JPanel (new GridLayout (2, 1, 0, 100));
	contentInputPanel = new JPanel ();
	angleSlider = new JSlider (0, 200, 120);
	angleLabel = new JLabel ();

	angleSlider.setPaintTrack (true);
	angleSlider.setPaintTicks (true);
	angleSlider.setPaintLabels (true);

	angleSlider.setMajorTickSpacing (50);
	angleSlider.setMinorTickSpacing (5);
	
	heightSlider = new JSlider (0, 140, 2);
	heightLabel = new JLabel ();

	heightSlider.setPaintTrack (true);
	heightSlider.setPaintTicks (true);
	heightSlider.setPaintLabels (true);

	angleSlider.setMajorTickSpacing (50);
	angleSlider.setMinorTickSpacing (5);
	// angleSlider.addChangeListener (s);

	contentInputPanel.add (angleSlider);
	contentInputPanel.add (angleLabel);

	contentInputPanel.add (heightSlider);
      

	//angleLabel.setText ("Angle (°): " + angleSlider.getValue ());
	//heightLabel.setText ("Height (px): " + heightSlider.getValue ());
	
	contentOutputPanel = new JPanel (new BorderLayout ());
	graphicsPanel = new JPanel ();
	realTimePanel = new JPanel ();
	statsPanel = new JPanel (new GridLayout (7, 1, 0, 0));

	contentInputPanel.setBackground (Color.WHITE);
	contentOutputPanel.setBackground (Color.WHITE);
	statsPanel.setBackground (Color.GREEN);

	for (int i = 0 ; i < 6 ; i++)
	{
	    statsPanel.add (statsLabels [i]);
	    statsLabels [i].setFont (Style.TEXT_FONT);
	}
	graphButton = new JButton ("Graph!");
	graphButton.setFont (Style.CONTROL_BUTTON_FONT);
	statsPanel.add (graphButton);

	// Display customized control buttons in input JPanel
	for (int i = 0 ; i < 3 ; i++)
	{
	    contentInputPanel.add (controlButtons [i]);
	    controlButtons [i].setFont (Style.CONTROL_BUTTON_FONT);
	    controlButtons [i].setBackground (Color.YELLOW);
	    controlButtons [i].addActionListener (new ControlBttnListener ());
	}

	// Add sub JPanels of simulation output JPanel
	contentOutputPanel.add (graphicsPanel, BorderLayout.CENTER);
	contentOutputPanel.add (realTimePanel, BorderLayout.SOUTH);
	contentOutputPanel.add (statsPanel, BorderLayout.EAST);

	contentPanel.add (contentOutputPanel);
	contentPanel.add (contentInputPanel);

	frame = new JFrame ("Projectile Motion Simulator");
	frame.getContentPane ().add (contentPanel);
	frame.setSize (800, 700);
	frame.setVisible (true);
    } // Constructor


    // Event handeller of control buttons
    private class ControlBttnListener implements ActionListener
    {
	public void actionPerformed (ActionEvent event)
	{
	    Object buttonClicked = event.getSource ();
	    if (buttonClicked == controlButtons [0])
	    {
		controlButtons [0].setText ("Ok");
	    }
	    else if (buttonClicked == controlButtons [1])
	    {
		controlButtons [1].setText ("...");
	    }
	    else if (buttonClicked == controlButtons [2])
	    {
		controlButtons [2].setText (".");
	    }
	}

	public void paint (Graphics g)
	{
	    // Place the drawing code here
	} // paint method
    } // NikkiGuo_Culminating class
}

