package culminating;

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class Table extends JFrame
{
    static JPanel dataPanel;
    JFrame frame;

    public Table ()
    {
	double position = 0, velocity = 0;
	
	dataPanel = new JPanel ();
	dataPanel.setLayout (new GridLayout (2, 0, 0, 0));

	String[] [] dataA = new String [50] [2];
	String columnA[] = {"TIME (S)", "Y POSITION-TIME (M)"};

	for (int i = 0 ; i < 50 ; i++)
	{
	    for (int j = 0 ; j < 2 ; j++)
	    {
		if (j == 0)
		{
		    dataA [i] [j] = Integer.toString (i);
		}
		else
		{
		    position = Simulator.velocityY * i + 0.5 * (-9.81) * Math.pow (i, 2);
		    dataA [i] [j] = Double.toString (position);
		}
	    }
	}

	JTable positionTimeTable = new JTable (dataA, columnA);
	positionTimeTable.setBounds (60, 70, 700, 600);
	JScrollPane scrollA = new JScrollPane (positionTimeTable);
	dataPanel.add (scrollA);

	String dataC[] [] = {{"0", "-9.81"}, {"1", "-9.81"}, {"2", "-9.81"}, {"3", "-9.81"}, {"4", "-9.81"}, {"5", "-9.81"}};
	String columnC[] = {"TIME (S)", "ACCELERATION (M/S/S) [Up]"};

	JTable accelerationTimeTable = new JTable (dataC, columnC);
	accelerationTimeTable.setBounds (60, 70, 700, 600);
	JScrollPane scrollC = new JScrollPane (accelerationTimeTable);
	dataPanel.add (scrollC);

	frame = new JFrame ("Table");
	frame.getContentPane ().add (dataPanel);
	//frame.getContentPane ().add (scrollA);
	frame.setSize (800, 700);
	frame.setVisible (true);
	frame.show ();
    } // Constructor
} // Table class
