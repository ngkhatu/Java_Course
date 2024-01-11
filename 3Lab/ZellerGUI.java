import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Zeller GUI
 * Implements Zeller Congruence for calculating day of week
 *
 * Nikhil G. Khatu partner- Kaitlyn Batchelor @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */

public class ZellerGUI  extends JFrame  implements ActionListener {

	/**the calculated day of the week*/
	private int dayOfWeek;
	
	/**GUI text fields the month*/
	private JTextField txtMonth;
	
	// Add JTextfield declarations and Javadoc for txtDay and txtYear  here

	/**GUI text fields the day*/
	private JTextField txtDay;

	/**GUI text fields the year*/
	private JTextField txtYear;
	
	
	/**GUI textfield for the day of the week*/
	private JTextField txtDayOfWeek;
	
	/**Label for the month text field*/
	private JLabel lblMonth;
	
	/**Label for the day text field*/
	private JLabel lblOutDay;
	
	// Add Label declarations and Javadoc for lblDay and lblYear here ...
	
	/**Label for the day text field*/
	private JLabel lblDay;
	
	/**Label for the year text field*/
	private JLabel lblYear;
	/**compute button*/
	private JButton btnCompute;

	/**
	 * Default constructor that initializes all instance variables, and
	 * sets up the GUI layout.
	 */
	public ZellerGUI() {
		super("Zeller Congruence");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200,200);
		setSize (200,300);
		
		this.txtMonth = new JTextField("",10);
		this.txtDayOfWeek = new JTextField("",10);
		this.lblMonth = new JLabel("Month");
		this.lblOutDay = new JLabel("Day of Week");
		this.btnCompute = new JButton ("Compute");
		
		Container c = getContentPane();
		c.setBackground (Color.white);
		c.setForeground (Color.black);
		c.setLayout(new FlowLayout());
		c.add(lblMonth);
		c.add(txtMonth);
	
		// Add labels and text boxes for Day and Year              
		lblDay=new JLabel("Day");
		c.add(lblDay);
		txtDay=new JTextField("",10);
		c.add(txtDay);
		
		lblYear=new JLabel("Year");
		c.add(lblYear);
		txtYear=new JTextField("",10);
		c.add(txtYear);
		
		
	
			
		c.add(lblOutDay);
		c.add (txtDayOfWeek);
	
		c.add (btnCompute);
		btnCompute.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	/**
	 * The main method starts the program.
	 *
	 * @param args command line arguemnts at runtime
	 */
	public static void main(String args[]) {
		new ZellerGUI();
	}
		
	/**
	 * actionPerformed is the method that is run when an action even occurs.
	 *
	 * @param event the action event that invokes this method
	 */
	public void actionPerformed(ActionEvent event) {

		int month = Integer.parseInt(txtMonth.getText());
		
		//Replace the following statement with a statement(like the preceding)to getText() from your day text field
		int day = Integer.parseInt(txtDay.getText()); 
		
		//Replace the following statement with a statement to getText() from your  year text field
		int year = Integer.parseInt(txtYear.getText());
		
		computeDayOfWeek(month,day,year);
		
		txtDayOfWeek.setText(""+dayOfWeek);
	}
		
	/**
	 * computeDayOfWeek computes the day of week for the given month, day and year.
	 *
	 * @param month the month for the Zeller computation
	 * @param day the day for the Zeller computation
	 * @param year the year for the Zeller computation
	 */
	private void computeDayOfWeek(int month, int day, int year) {

		// Insert your Zeller code here
		
	if (month==1 || month==2){
		year= year - 1;
		}
		
	if (month==2){
		day= day + 3;
		}
	
	if (month==3){
		day= day + 2;
		}
	
	if (month==4){
		day= day + 5;
		}
	
	if (month==5){
		day= day + 0;
		}
	
	if (month==6){
		day= day + 3;
		}
	
	if (month==7){
		day= day + 5;
		}
	
	if (month==8){
		day= day + 1;
		}
	
	if (month==9){
		day= day + 4;
		}
	
	if (month==10){
		day= day + 6;
		}
	
	if (month==11){
		day= day + 2;
		}
	
	if (month==12){
		day= day + 4;
		}
	
dayOfWeek= (year + year/4 - year/100 + year/400 + day)%7;
		System.out.println(""+dayOfWeek); //use println for debugging 
	}
}
