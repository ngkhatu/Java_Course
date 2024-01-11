 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 *  CarGUI provides the GUI interface for the Car class
 *
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public class CarGUI extends JFrame implements ActionListener {
	
	/** The instance of the Car class */
    private Car car;
	
	/** The DecimalFormat object used for formatting */
    private DecimalFormat format;
    
	/** JLabel for the miles to drive */
    private JLabel lblDrive;
	
	/** JLabel for the amount of fuel in the tank */
    private JLabel lblInTank;
	
	/** Text field for the miles to drive */
    private JTextField txtDrive;
	
	/** The drive button */
    private JButton btnDrive;
	
	/** The fill button */
    private JButton btnFill = null;
    
    /**
     * Answers a GUI for the Car object
     * @param c the Car object
     */
    public CarGUI(Car c) {
        super(c.getCarName());
        this.car = c;
		this.format = new DecimalFormat("######.0###");
  
		this. lblDrive = new JLabel("Miles to Drive: ");
        this.lblInTank = new JLabel("Left in Tank: " + car.getFuelInTank());
        this.txtDrive = new JTextField(5);
        this.btnDrive = new JButton("Drive");
        this.btnFill	 = new JButton("Fill Up");
        
        setupLayout();
 		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * Encapsulates the layout of the GUI
     */
    public void setupLayout() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(this.lblDrive);
        c.add(this.txtDrive);
        c.add(this.btnDrive);
        c.add(this.btnFill);
        c.add(this.lblInTank);
        
        this.btnDrive.addActionListener(this);
        this.btnFill.addActionListener(this);
        
        setSize(250, 100);
        setLocation(100, 100);
        setVisible(true);
    }
    
    /**
     * Responds to button clicks
     * @param e the event (button click)
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnDrive) {
            if (this.txtDrive.getText().trim().compareTo("") != 0){
                double d = Double.parseDouble(this.txtDrive.getText());
                this.car.drive(d);
                
                this.lblInTank.setText("Left in Tank: " + this.format.format(car.getFuelInTank()));
                this.txtDrive.setText("");
            }
        } 
		else if(e.getSource() == this.btnFill) {
            this.car.fillTank();
            this.lblInTank.setText("Left in Tank: " + this.car.getFuelInTank());
        }
    }
    
	/**
	 * The main method starts the program.
	 *
	 * @param args command line arguemnts at runtime
	 */
    public static void main(String args[]) {
        CarGUI cg1 = new CarGUI(new Car("Ford Mustang"));
        CarGUI cg2 = new CarGUI(new Car("Honda Accord", 35, 12));
	CarGUI cg3 = new CarGUI(new Car("Nissan Xterra", 40, 14));
	CarGUI cg4 = new CarGUI(new Car("Lexus ES300", 25, 16));

    }
}
