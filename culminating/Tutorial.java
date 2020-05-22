package culminating;

import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial extends JFrame
{
    static JFrame frame;
    JEditorPane textField;

    public Tutorial ()
    {
	frame = new JFrame ("Tutorial");
	frame.setSize (800, 700);
	textField = new JEditorPane ();
	textField.setContentType ("text/html");
	textField.setText ("<h1>How it Works</h1>"
		+ "<p>This program is a simulation of a physics concept, "
		+ "projectile motion. It is for students to learn about "
		+ "projectile motion and various components that affect it, "
		+ "such as velocity,  initial angle, acceleration, components, "
		+ "and maximum height. Using graphics, the user views a visualization "
		+ "of this form of motion and gets to interact with it by controlling "
		+ "the components.</p>"
		+ "<h2>Simulator</h2>"
		+ "<p>To use the simulator, do the following:</p>"
		+ "<ol><li>Click Start! button on menu page.</li>"
		+ "<li>Adjust angle, velocity, and mass with sliders in simulator.</li>"
		+ "<li>Click the Simulate! button to start the simulation.</li>"
		+ "<li>The stats panel to the right of the simulator panel displays numbers "
		+ "pertaining to the projectile motion</li>"
		+ "<li>Once the simulation is complete, a table displaying position-time " 
		+ "and acceleration-time will show up.</li>"
		+ "<li>Click the Reset button to reset values and restart.</li>"
		+ "<li>To exit, click the exit button in the window or the home button."
		+"</li></ol>"
		+"<h2>The Physics</h2>");
	textField.setEditable (false);
	frame.getContentPane ().add (textField);
	frame.setVisible (true);
    } // Constructor
} // Tutorial class
