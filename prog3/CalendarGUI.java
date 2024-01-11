import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalendarGUI extends JFrame implements ActionListener {
	
	private JButton btnProduceCal;
	private JButton btnExit;
	private JLabel  lblYear;
	private JTextField txtYear;
	private CalendarModel myModel;
	private JLabel lblMonth;
	private JTextField txtMonth;
	
	public CalendarGUI(CalendarModel cModel) {
		
		myModel = cModel;

		btnProduceCal = new JButton("Produce Calendar");
		btnProduceCal.addActionListener(this);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);

		lblYear = new JLabel("Year:");
		txtYear = new JTextField(15);
		
		lblMonth = new JLabel("Month:");
		txtMonth = new JTextField(15);
		
		setSize(250,150);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("CalendarGUI");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(lblYear);
		c.add(txtYear);
		
		c.add(lblMonth);
		c.add(txtMonth);

		c.add(btnProduceCal);
		c.add(btnExit);
		
		setVisible(true);
	}
	
	/**
	* Handles the program when JButtons are pressed
	*
	* @param e The event being thrown(a button being pressed)
	*/
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnExit) {
			System.exit(1);
		}

                String yearString =  txtYear.getText();
                yearString        =  yearString.trim(); //trim blanks 
                int    year       =  Integer.parseInt ( yearString);
		myModel.setYear(year);
		
		String monthString =  txtMonth.getText();
                monthString        =  monthString.trim(); //trim blanks 
                int    month       =  Integer.parseInt ( monthString);
		myModel.setMonth(month);


                //System.out.println ( "actionperformed: The year is " + year); 
                //System.out.println ( "actionperformed: The month is " + month);
		if ( verifyYear(year) ) {
                }
                else {txtYear.setText( year + " is invalid. Please reenter.");
                }
		
		
		
		if ( verifyMonth(month) ) {
                }
                else {txtMonth.setText(month + " is invalid. Please reenter.");
                }
		
		if(verifyYear(year) && verifyMonth(month)){
			myModel.generateCalendar();
	}
	}

    /**
     * @param year for verification of proper year input
     * @return true or false if year is within range
     */
	public boolean verifyYear(int year){
		if (year >=  1753 && year <= 3000) return true;     
		else return false;
	}
	
	/**
	*@param month for verification of proper month input
	*@return true or false if month is within range
	*/
	public boolean verifyMonth(int month){

		if (month >=  1 && month <= 12) return true;
		else return false;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		CalendarModel cm = new CalendarModel();
		CalendarGUI cg = new CalendarGUI(cm);
	}

}
