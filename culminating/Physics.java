package culminating;

import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Physics extends JFrame
{
    JFrame frame;
    JPanel cardLayoutHolder = new JPanel ();
    JPanel panelButton = new JPanel ();
    JPanel panelMain = new JPanel (new GridLayout (2, 1, 0, 100));
    JPanel panelOne = new JPanel ();
    JPanel panelTwo = new JPanel ();
    JPanel panelThree = new JPanel ();
    CardLayout cardLayout = new CardLayout ();

    // Create menu JButtons in array
    private JButton[] buttons = {
	new JButton ("< Back"),
	new JButton ("Menu"),
	new JButton ("Next >")
	};

    public Physics ()
    {
	panelButton = new JPanel ();
	panelButton.setBackground (Color.WHITE);

	for (int i = 0 ; i < 3 ; i++)
	{
	    panelButton.add (buttons [i]);
	    //buttons [i].setActionListener (new NavButtonListener ());
	}

	cardLayoutHolder.setBorder (new EmptyBorder (new Insets (50, 50, 50, 50)));
	cardLayoutHolder.add (panelOne);
	cardLayoutHolder.add (panelTwo);
	cardLayoutHolder.add (panelThree);

	panelMain.add (cardLayoutHolder);
	panelMain.add (panelButton);

	frame = new JFrame ("Physics");
	frame.getContentPane ().add (panelMain);
	frame.setSize (800, 700);
	frame.setVisible (true);      // Show the frame
    } // Constructor


    /*
    private class NavButtonListener implements ActionListener
    {
	public void actionPerformed (ActionEvent event)
	{
	    Object navButton = event.getSource ();

	    if (navButton == buttons [1])
	    {

	    }



	}
    }
    */

    public void paint (Graphics g)
    {
	// Place the drawing code here
    } // paint method
} // Physics class
