/* 
 * Nikki Guo - Projectile Motion Simulator - TABLE.JAVA                                                                 
 * Based on the velocity value passed from the Simulator.java class, this page 
 * displays a table of values for position time and acceleration time.
*/ 

package culminating;

// Import select Java libraries 
import java.awt.*;
import javax.swing.*;
import java.util.Arrays;
import javax.swing.border.EmptyBorder;

public class Table extends JFrame
{
    // Intialize variables and objects in the JFrame
    static JPanel textPanel, dataPanel;
    JFrame frame;
    JLabel titleMessage;
    JScrollPane scrollPT, scrollAT;
    JTable positionTimeTable, accelerationTimeTable;
    
    // Table constructor
    public Table ()
    {   
	// Initalize local variables and data table arrays
	double position = 0, velocity = 0;
	String[] [] dataPT = new String [50] [2];
	String columnPT[] = {"TIME (S)", "Y POSITION-TIME (M)"};
	String dataAT[] [] = {{"0", "-9.81"}, {"1", "-9.81"}, {"2", "-9.81"}
	    , {"3", "-9.81"}, {"4", "-9.81"}, {"5", "-9.81"}, {"6", "-9.81"}
	    , {"7", "-9.81"}, {"8", "-9.81"}, {"8", "-9.81"}, {"9", "-9.81"}
	    , {"10", "-9.81"}};
	String columnAT[] = {"TIME (S)", "ACCELERATION (M/S/S) [Up]"};

	// Add data panel with borders and grid layout in table frame
	dataPanel = new JPanel ();
	dataPanel.setBorder (new EmptyBorder (10, 10, 10, 10));
	dataPanel.setLayout (new GridLayout (3, 10, 0, 20));
	
	// Add textpanel with borders and grid layout in table frame
	textPanel = new JPanel (new GridLayout (2, 10, 0, 10));
	textPanel.setBorder (new EmptyBorder (10, 10, 10, 10));
	textPanel.setBackground (Style.LIGHT_GREEN);
	
	// Set title of frame with custom font
	titleMessage = new JLabel ("~ Table of Values ~ ", JLabel.CENTER);
	titleMessage.setFont (Style.TITLE_FONT);

	// Set JTextArea with customized text about the table of values
	JTextArea textArea = new JTextArea ("Below are tables of position-time values and "
		+ "acceleration-time values. Negative position-time values "
		+ "represent positions below the screen. Acceleration values remain "
		+ "constant, as the only existing force is gravity when air resistance "
		+ "is ignored. (1px = 1m)");
		
	// Format JTextArea(wrap, margins) and add to textPanel
	textArea.setFont (Style.TEXT_FONT);
	textArea.setMargin (new Insets (10, 10, 10, 0));
	textArea.setWrapStyleWord (true);
	textArea.setLineWrap (true);
	textArea.setEditable (false);
	textPanel.add (titleMessage);
	textPanel.add (textArea);
	dataPanel.add (textPanel);
	
	// Loop through position-time 2D array
	for (int i = 0 ; i < 50 ; i++)
	{
	    for (int j = 0 ; j < 2 ; j++)
	    {
		if (j == 0)
		{
		    dataPT [i] [j] = Integer.toString (i); // Fills in time column 
		}
		else
		{
		    // Calculates position based on velocity user input from Simulator.java
		    position = Simulator.velocityY * i + 0.5 * (-9.81) * Math.pow (i, 2);
		    dataPT [i] [j] = Double.toString (position);
		}
	    }
	}
	
	// Add row and column data into position-time, customize fonts, make scrollable
	positionTimeTable = new JTable (dataPT, columnPT);
	positionTimeTable.setBounds (60, 70, 700, 600);
	positionTimeTable.setFont(Style.TEXT_FONT);
	scrollPT = new JScrollPane (positionTimeTable);
	
	// Add row and column data into acceleration-time, customize fonts, make scrollable
	accelerationTimeTable = new JTable (dataAT, columnAT);
	accelerationTimeTable.setBounds (60, 70, 700, 600);
	accelerationTimeTable.setFont (Style.TEXT_FONT);
	scrollAT = new JScrollPane (accelerationTimeTable);
	
	// Add two tables into data JPanel and set background colour
	dataPanel.add (scrollPT);
	dataPanel.add (scrollAT);
	dataPanel.setBackground (Style.LIGHT_GREEN);
	
	// Set frame title and size, add JPanel 
	frame = new JFrame ("Table of Values");
	frame.getContentPane ().add (dataPanel);
	frame.setSize (800, 700);
	frame.setVisible (true);
	frame.show ();
    } // Constructor
} // Table class
