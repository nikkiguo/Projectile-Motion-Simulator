package culminating;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulatorMenu extends JFrame
{
    private JLabel title;
    private JPanel contentPanel;
    static JFrame frame;

    // Create menu JButtons in array
    private JButton[] buttons = {
	new JButton ("Start!"),
	new JButton ("Tutorial"),
	new JButton ("Physics Lesson")
	};

    public SimulatorMenu ()
    {
	// Create JFrame Object
	frame = new JFrame ("Menu");

	// Create JLabel title
	title = new JLabel ("- Projectile Motion -", JLabel.CENTER);
	title.setFont (Style.TITLE_FONT); 

	// Create JPanel, set panel, and add graphical components
	contentPanel = new JPanel ();
	contentPanel.setBorder (new EmptyBorder (new Insets (50, 50, 50, 50)));
	contentPanel.setLayout (new GridLayout (4, 0, 0, 20));
	contentPanel.setBackground (Style.BERMUDA);
	contentPanel.add (title);

	// Loops through button object array to set event handlers and stylize
	for (int i = 0 ; i < 3 ; i++)
	{
	    contentPanel.add (buttons [i]);
	    buttons [i].setFont (Style.BUTTON_FONT); 
	    buttons [i].addActionListener (new ButtonListener ());
	    buttons [i].setBackground (Color.ORANGE);
	}

	// Customize frame and show it
	frame.getContentPane ().add (contentPanel);
	frame.setSize (800, 700);
	frame.setVisible (true);

    } // Constructor


    // Handles actions for button clicked events
    private class ButtonListener implements ActionListener
    {
	public void actionPerformed (ActionEvent event)
	{
	    Object buttonClicked = event.getSource ();
	    if (buttonClicked == buttons [0])
	    {
		frame.dispose ();
		Test simulatorFrame = new Test ();
	    }
	    else if (buttonClicked == buttons [1])
	    {
		frame.dispose ();
		Tutorial tutorialFrame = new Tutorial ();
	    }
	    else if (buttonClicked == buttons [2])
	    {
		frame.dispose ();
		Physics physicsFrame = new Physics ();
	    }
	}

	public void paint (Graphics g)
	{

	} // paint method
    } // SimulatorMenu class
}


