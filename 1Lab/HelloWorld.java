import javax.swing.*;
import java.awt.*;

/**
 *pair programming- Nikhil Khatu, Kaitlyn Batchelor 
 *HellowWorld holds the GUI for Lab 1.
 *
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public class HelloWorld extends JFrame {
 	/**
	 * The default constructor for this class initializes all GUI variables.
	 */
	public HelloWorld() {
 		setTitle("Hello World Frame");                               // Line 7
	 
		JLabel lblHello = new JLabel("Hi, we are group 11",JLabel.CENTER);   // Line 8
     	lblHello.setForeground(Color.black);                           // Line 9
	 
		 Container c = getContentPane();                              // Line 10
		 c.add(lblHello);                                             // Line 11
		 c.setBackground(Color.red);                            // Line 12
		 
		 setSize(200, 150);                                           // Line 13
		 setLocation(200,200);                                        // Line 14
		 setDefaultCloseOperation(EXIT_ON_CLOSE);                     // Line 15
		 setVisible(true);                                            // Line 16
  	}
  	
	/**
	 * The main method holds the actual java code for this class.
	 *
	 * @param args command line arguments (will be discussed later on in the semester
	 */
 	public static void main(String [] args) {
     	HelloWorld frmHello = new HelloWorld();                      // Line 20
  	}
}

