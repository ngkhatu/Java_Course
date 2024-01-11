import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

/**
 * TrackerView is the GUI that shows the path of the hurricane.
 *
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public class TrackerView extends JFrame implements ActionListener{

	private DrawingPanel pnl;
	private JTextField txt;
	
	/**
	* The default constructor initializes all instance variables, and 
	* sets up the GUI.
	*/
	public TrackerView () {

		setTitle("Enter File Name");  
		
		setLocation(100,100);
		setSize(500,500);
		this.pnl = new DrawingPanel();
		this.txt = new JTextField(20);
		this.txt.setBackground(Color.lightGray); 
		this.txt.addActionListener(this); 
		
		Container c = getContentPane();
		c.add(txt,"North");
		c.add(pnl,"Center");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/*
	* Responds to button events
	*
	* @param e event that triggered the action
	*/
	public void actionPerformed(ActionEvent e) {
		String s = this.txt.getText(); 
		
		// reset text field to empty
		txt.setText("");          
		
		// draw the path of the hurricane	
		pnl.processPath(s);       
	}
	
	/**
	* The main method starts the program.
	*
	* @param args command line arguemnts at runtime
	*/
	public static void main(String [] args) {
		TrackerView t = new TrackerView();
	}
}

