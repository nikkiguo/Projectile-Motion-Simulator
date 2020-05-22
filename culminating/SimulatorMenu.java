/*
 * Nikki Guo - Projectile Motion Simulator - SIMULATORMENU.JAVA
 * This class contains customized style features in the program that
 * repeat, and these objects are called in the other classes
*/

package culminating;

// Import select Java libraries
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulatorMenu extends JFrame
{
    // Intialize variables and objects in the JFrame
    private JLabel title;
    private JPanel contentPanel;
    static JFrame frame;

    // Declare JButton array
    private JButton[] buttons = {
	new JButton ("Start!"),
	new JButton ("Tutorial"),
	new JButton ("Exit")
	};

    // SimulatorMenu constructor
    public SimulatorMenu ()
    {
	// Create JFrame Object
	frame = new JFrame ("Menu");

	// Create JLabel title
	title = new JLabel ("- Projectile Motion -", JLabel.CENTER);
	title.setFont (Style.TITLE_FONT);

	// Create JPanel, set panel, and add border/layout
	contentPanel = new JPanel ();
	contentPanel.setBorder (new EmptyBorder (new Insets (50, 50, 50, 50)));
	contentPanel.setLayout (new GridLayout (4, 0, 0, 20));
	contentPanel.setBackground (Style.BERMUDA);
	contentPanel.add (title);

	// Loop through button object array to set event handlers and stylize
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
	    if (buttonClicked == buttons [0]) // Button to go to simulator
	    {
		// Close current frame and run new frame class
		frame.dispose ();
		Simulator simulatorFrame = new Simulator ();
	    }
	    else if (buttonClicked == buttons [1]) // Button to go to tutorial
	    {
		// Close current frame and run new frame class
		frame.dispose ();
		Tutorial tutorialFrame = new Tutorial ();
	    }
	    else if (buttonClicked == buttons [2]) // Button to exit
	    {
		// Closes program
		frame.dispose ();
	    }
	}
    } // SimulatorMenu class
}


