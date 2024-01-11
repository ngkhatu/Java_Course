import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * JavaIsFun is a sample class that shows how to implement a simple GUI.
 *
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public class WindChillGUI extends JFrame implements ActionListener{
	
	private WindChill myWC;
	
	/** a button on the GUI */
	private JButton btnCompute;
	private JLabel lblwindspeed;
	private JTextField txtwindspeed;
	private JLabel lbltemperature;
	private JTextField txttemperature;
	private JTextField txtwindchill;
	private JLabel lblwindchill;
	
	/**
	 * Default constructor for the WindChillGUI class.
	 */
	public WindChillGUI(WindChill temp) {
		Container c = getContentPane();
		
		myWC = temp;
		
		lblwindspeed= new JLabel("Wind Speed");
		c.add(lblwindspeed);
		
		txtwindspeed= new JTextField("", 10);
		c.add(txtwindspeed);
		
		lbltemperature= new JLabel("Temperature");
		c.add(lbltemperature);
		
		txttemperature= new JTextField("", 10);
		c.add(txttemperature);
		
		lblwindchill= new JLabel("Wind Chill");
		c.add(lblwindchill);
		
		txtwindchill= new JTextField("", 10);
		c.add(txtwindchill);
		
		btnCompute = new JButton("Compute");
		c.add(btnCompute);
		btnCompute.addActionListener(this);
		
		
		
		c.setLayout(new FlowLayout());
		
		setSize(250,200);
		setLocation(100,100);
		setVisible(true);
	
		setDefaultCloseOperation
			(EXIT_ON_CLOSE);
		
	
	}

	/**
	 * Responds to button clicks
	 *
	 * @param e the event (button click)
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCompute){
		int w= Integer.parseInt(txtwindspeed.getText());
		int t= Integer.parseInt(txttemperature.getText());
		double WC= myWC.calculateWC(w,t);
		txtwindchill.setText(""+WC);
		}
	}

	/**
	 * The main method starts the program.
	 *
	 * @param args command line arguemnts at runtime
	 */
	public static void main( String [] args) {
		WindChill myWindChill = new WindChill();
		 WindChillGUI myWCG = new WindChillGUI(myWindChill);
		 
	}
}

	
