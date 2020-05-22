/*
 * Nikki Guo - Projectile Motion Simulator - TUTORIAL.JAVA
 * This class displays the tutorial for incoming users and explains the physics
*/

package CA_NikkiGuo;

// Import select Java packages
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
    // Intialize variables and objects in the JFrame
    static JFrame frame;
    JButton backToHome;
    JPanel contentPanel;
    JEditorPane textField;
    JScrollPane scroll;
    
    // Tutorial constructor
    public Tutorial ()
    {
	// Create JFrame object and set size of window
	frame = new JFrame ("Tutorial");
	frame.setSize (700, 600);
	
	// Create JPanel object and JEditorPane object and set layout
	contentPanel = new JPanel ();
	contentPanel.setLayout (new BorderLayout (10, 10));
	textField = new JEditorPane ();
	
	// Create JButton object with custom style
	backToHome = new JButton ("Home");
	backToHome.setFont (Style.TEXT_FONT);
	backToHome.setBackground (Style.CORAL_RED);
	
	// JButton anonymous class action listener - navigates back to home 
	backToHome.addActionListener (new ActionListener ()
	{
	    public void actionPerformed (ActionEvent e)
	    {
		frame.dispose ();
		SimulatorMenu toMenu = new SimulatorMenu ();
	    }
	}
	);
	
	// Customize textfield borders and format using HTML  
	textField.setBorder (new EmptyBorder (10, 15, 10, 15));
	textField.setContentType ("text/html");
	textField.setText ("<h1>How it Works!</h1>"
		+ "<p>This program is a simulation of a physics concept, "
		+ "projectile motion. It is for students to learn about "
		+ "projectile motion and various components that affect it, "
		+ "such as velocity,  initial angle, acceleration, components, "
		+ "and maximum height. Using graphics, the user views a visualization "
		+ "of this form of motion and gets to interact with it by controlling "
		+ "the components.</p>"
		+ "<h2>Simulator</h2>"
		+ "<p>To use the simulator, do the following:</p>"
		+ "<ol><li>Click the Start! button on menu page.</li>"
		+ "<li>Adjust angle, velocity, and mass with sliders in simulator.</li>"
		+ "<li>Click the Simulate! button to start the simulation.</li>"
		+ "<li>The stats panel to the right of the simulator panel displays numbers "
		+ "pertaining to the projectile motion</li>"
		+ "<li>Once the simulation is complete, a table displaying position-time "
		+ "and acceleration-time will show up.</li>"
		+ "<li>Click the Reset button to reset values and restart.</li>"
		+ "<li>To exit, click the exit button in the window or the home button."
		+ "</li></ol>"
		+ "<h2>The Physics</h2>"
		+ "<p><i>Projectile motion</i> is a type of motion that is only "
		+ "under the influence of gravity, ignoring air resistance."
		+ "</p><li>The motion can be split into horizontal motion "
		+ "and vertical motion, which are independent of each other."
		+ "</li><li>Horizontal motion is constant.</li>"
		+ "<li>Vertical motion is uniform acceleration. "
		+ "(9.81 m/s/s [D])</li><li>With the knowledge of "
		+ "the 5 kinematic equations, one can calculate the speed, "
		+ "time elapsed, and more for vertical motion.</li><li>Vertical:</li>"
		+ "<ol><li>&#916;d = v<sub>1</sub>&#916;t + 1/2a&#916;t<sup>2</sup></li>"
		+ "<li>&#916;d = v<sub>2</sub>&#916;t - 1/2a&#916;t<sup>2</sup></li>"
		+ "<li>v<sub>2</sub> = v<sub>1</sub>+ a&#916;t</li>"
		+ "<li>v<sub>2</sub><sup>2</sup> = v<sub>1</sub><sup>2</sup> "
		+ "+ 2a&#916;d</li>"
		+ "<li>&#916;d = (v<sub>1</sub> + v<sub>2</sub>/2)&#916;t</li>"
		+ "</ol><li>Horizontal:</li>"
		+ "<ol><li>&#916;d = &#916;v/&#916;t</li></ol>"
		+ "<li>&#916;d - change in distance ~ v - velocity "
		+ " ~ a - acceleration  ~ &#916;t - change in time</li>"
		+ "<h2>Programming concepts</h2></p>"
		+ "<li>Repetition</li><li>Strings and formating</li>"
		+ "<li>Object Oriented Programming</li><li>Arrays</li>"
		+ "<li>Java Swing GUI</li><li>Data types</li>"
		+ "<li>Arithmetic Operations and math methods</li>"
		+ "<li>Decision</li>");
		//(Decimal codes used for special characters (delta symbol))
	
	// Set textfield to not editable by user and add scroll bar
	textField.setEditable (false);
	scroll = new JScrollPane (textField);
	
	// Display JPanels with BorderLayout manager 
	contentPanel.add (scroll, BorderLayout.CENTER);
	contentPanel.add (backToHome, BorderLayout.SOUTH);
	
	// Add contentPanel to frame and show it on window
	frame.getContentPane ().add (contentPanel);
	frame.setVisible (true);
    } // Constructor
} // Tutorial class
