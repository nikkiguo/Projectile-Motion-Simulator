package culminating;

import java.awt.*;

public class SimulatorMenu extends Frame
{
    public SimulatorMenu ()
    {
	super ("SimulatorMenu");        // Set the frame's name
	setSize (400, 400);     // Set the frame's size
	show ();                // Show the frame
    } // Constructor
    
    public void paint (Graphics g)
    {
	// Place the drawing code here
    } // paint method
    
    public static void main (String[] args)
    {
	new SimulatorMenu ();   // Create a SimulatorMenu frame
    } // main method
} // SimulatorMenu class
