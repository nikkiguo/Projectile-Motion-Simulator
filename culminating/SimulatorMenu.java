package culminating;

import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulatorMenu extends JFrame
{
    final static Font TITLE_FONT = new Font ("Courier New", Font.PLAIN, 40);
    private JLabel title;
    private JPanel contentPanel;
    static JFrame frame;
    static Color bermuda = new Color (137, 171, 227);

    // Create menu JButtons in array
    private JButton[] menuButtons = {
	new JButton ("B"),
	new JButton ("B2"),
	new JButton ("B3")
	};

    public SimulatorMenu ()
    {
	// Create JFrame Object
	frame = new JFrame ("Projectile Motion Simulator");

	// Create JLabel title
	title = new JLabel ("- Projectile Motion -", JLabel.CENTER);
	title.setFont (TITLE_FONT);
	title.setForeground(Color.white);

	contentPanel = new JPanel ();
	contentPanel.setBorder (new EmptyBorder (new Insets (50, 50, 50, 50)));
	contentPanel.setLayout (new GridLayout (5, 2, 0, 10));
	contentPanel.setBackground (bermuda);
	contentPanel.add (title);
       
	for (int i = 0; i < 3; i++) {
	    contentPanel.add(menuButtons[i]);
	}

	// Customize frame and show it
	frame.getContentPane ().add (contentPanel);
	frame.setSize (800, 700);
	frame.setVisible (true);

    } // Constructor


    public void paint (Graphics g)
    {

    } // paint method
} // SimulatorMenu class
