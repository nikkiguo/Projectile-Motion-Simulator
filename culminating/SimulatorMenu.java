package culminating;

import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulatorMenu extends JFrame
{
    final static Font TITLE_FONT = new Font ("Courier New", Font.PLAIN, 30);
    private JLabel title;
    private JPanel contentPanel;
    static JFrame frame;
    static Color bermuda = new Color (145, 212, 194);

    // Create menu JButtons in array
    private JButton[] menuButtons = {
	new JButton ("B1"),
	new JButton ("B2"),
	new JButton ("B3")
	};

    public SimulatorMenu ()
    {
	// Create JFrame Object
	frame = new JFrame ("Projectile Motion Simulator");

	// Create JLabel title
	title = new JLabel ("Projectiles In Motion", JLabel.CENTER);
	title.setFont (TITLE_FONT);

	contentPanel = new JPanel ();
	contentPanel.setBorder (new EmptyBorder (new Insets (50, 50, 50, 50)));
	contentPanel.setLayout (new GridLayout (5, 1, 0, 10));
	contentPanel.setBackground (bermuda);
	contentPanel.add (title);

	// Customize frame and show it
	frame.getContentPane ().add (contentPanel);
	frame.setSize (600, 500);
	frame.setVisible (true);

    } // Constructor


    public void paint (Graphics g)
    {

    } // paint method
} // SimulatorMenu class
