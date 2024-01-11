import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * CatchTheTA is the applet for Lab 10
 *
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public class CatchTheTA extends JApplet {
	
	/** the delay for the timer */
	private final int DELAY =100;
	
	/** the timer for the applet */
	private Timer timer;

	/**
 	 * Initializes the applet. Creates the layout, creates a timer to
 	 * use in updating the animation panel.
 	 **/
	public void init () {
		timer = new Timer (DELAY, null);  // Create a timer object using .1 second interval
		JLabel totalHitLabel = new JLabel ("Total Hits :");
		JTextField totalHits = new JTextField ("0",20);
		JPanel tallyPanel = new JPanel();

		tallyPanel.add(totalHitLabel,BorderLayout.CENTER);
		tallyPanel.add(totalHits,BorderLayout.EAST);

		getContentPane().add (new AnimationPanel (timer,totalHits),BorderLayout.CENTER);  // Give the timer object to the panel
		getContentPane().add (tallyPanel,BorderLayout.SOUTH);

	}

	public void start() {
		timer.start();  // Start the timer 
	}

	public void stop() {
		timer.stop();  // Stop the timer 
	}
}



