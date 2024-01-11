import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import postal.*;

/**
 * PostalFrame provides a GUI for input from the user of a zip code,
 * and then outputs the postal bar code that corresponds
 *
 * @author <Nikhil Khatu, Hunter Chambers>
 * @version 1.0
 */
public class PostalFrame extends JFrame implements ActionListener {
	
	/** the label for the zip code */
    private JLabel lblZip;
	
	/** the text field for the zip code */
    private JTextField txtZip;
	
	/** the button to find the bar code */
    private JButton btnZip;
	
	/** the panel to put all components on */
    private JPanel pnlZip;

	/** the instance of the PostalBarCode class */
    private PostalBarCode barCode;
	
	/** the translation table */
    private int table[][];
	
	/** the numerial representation of the zip code */
    private int zipCode;
    
    private int[] Zip;

    /**
     * Answers a PostalFrame object to create a simple GUI
     * to produce a postal bar code for the user's zip code
     */
    public PostalFrame() {
        setSize(280,125);
        setLocation(100,100);

        lblZip  = new JLabel("Zip Code:");
        txtZip  = new JTextField(7);
        btnZip  = new JButton("Bar Code");

        pnlZip  = new JPanel();
        pnlZip.add(lblZip);
        pnlZip.add(txtZip);
        pnlZip.add(btnZip);

        btnZip.addActionListener(this);

        Container c = getContentPane();
        c.add(pnlZip, BorderLayout.NORTH);

        barCode = new PostalBarCode();

        c.add(barCode, BorderLayout.CENTER);
        
        setTitle("Postal Code Generator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
       
        table = new int[10][5];
        initTable();
	
	Zip = new int[5];
    }

    /**
     * Extract the individual digits stored in the ZIP code
     * and store their values as private data
     */
    private void extractDigits() {
		//You must complete this method!!
	int ZipCode = 0;
	
	Zip[0] = zipCode / 10000;
	ZipCode = zipCode - (Zip[0] * 10000);
	Zip[1] = ZipCode / 1000;
	ZipCode = ZipCode - (Zip[1] * 1000);
	Zip[2] = ZipCode / 100;
	ZipCode = ZipCode - (Zip[2] * 100);
	Zip[3] = ZipCode / 10;
	ZipCode = ZipCode - (Zip[3] * 10);
	Zip[4] = ZipCode;
	
        barCode.clearCode();	
    }

    /**
     * Calculate correction digit and draw it
     * (used by actionPerformed())
     */
    private void calculateAndDrawCDigit () {
	//you must complete this method!!
	int zip = (Zip[0] + Zip[1] + Zip[2] + Zip[3] + Zip[4]);
	while(zip % 10 != 0){
		zip= zip + 1;
		}
    }

    /**
     * Retrieve the value (zero or one) 
     * stored in the ith row and jth column
     * of the ZIP code table
     * 
     * @param i  ith row 
     * @param j  jth column
     * @return zero or one as an integer
     */
    private int getValue(int i, int j) {
        return table[i][j]; 

    }

    /**
     * Draw the bar code for the zip code
     * using the drawSmallBar and drawFullBar methods provided
     * in PostalBarCode object
     * (invoked from actionPerformed())
     */
    private void drawZIPCode() { 
		//you must complete this method!

        // Write an outer loop to process the 5 digits
        // of the ZIP code, one at a time --
        // use i as the loop control variable
	
	for (int i = 0; i<=4;i++){
		for (int j = 0; j<=4; j++){
		if (getValue(Zip[i], j) == 1)
			barCode.drawFullBar();
		else barCode.drawSmallBar();
		}
	}



            // Write an inner loop that will processa single
            // digit of the ZIP code, drawing five bars for the
            // digit. Use j as the variable to control the loop.

    }
    
    /**
     * actionPerformed accepts an ActionEvent object, and invokes the methods from
     * this class based on which button is pressed.
     *
     * @param e action event from the button that is pressed
     */
    public void actionPerformed(ActionEvent e) {

        String zip = new String();

        if (e.getSource() == btnZip) {
            // take text from textfield and trim off any
            // whitespace at either end
            zip = txtZip.getText().trim();

            if (zip.length() == 5) {
                zipCode = Integer.parseInt(zip);	
                extractDigits();          // 5 digits		
                drawZIPCode();            // use the PostalBarCode object
                                          // to draw a full or half
                                          // bar for each digit
                calculateAndDrawCDigit(); // calculate and 
                                          // draw the the check digit
            }
        }
    }
    
    /**
     * initTable initializes the table for use in the draw zip code
     * methods.
     */
    private void initTable() {

        table[0][0] = 1;
        table[0][1] = 1;
        table[0][2] = 0;
        table[0][3] = 0;
        table[0][4] = 0;
            
        table[1][0] = 0;
        table[1][1] = 0;
        table[1][2] = 0;
        table[1][3] = 1;
        table[1][4] = 1;
                     
        table[2][0] = 0;
        table[2][1] = 0;
        table[2][2] = 1;
        table[2][3] = 0;
        table[2][4] = 1;
                    
        table[3][0] = 0;
        table[3][1] = 0;
        table[3][2] = 1;
        table[3][3] = 1;
        table[3][4] = 0;
                    
        table[4][0] = 0;
        table[4][1] = 1;
        table[4][2] = 0;
        table[4][3] = 0;
        table[4][4] = 1;
                    
        table[5][0] = 0;
        table[5][1] = 1;
        table[5][2] = 0;
        table[5][3] = 1;
        table[5][4] = 0;
                   
        table[6][0] = 0;
        table[6][1] = 1;
        table[6][2] = 1;
        table[6][3] = 0;
        table[6][4] = 0;
                    
        table[7][0] = 1;
        table[7][1] = 0;
        table[7][2] = 0;
        table[7][3] = 0;
        table[7][4] = 1;
                    
        table[8][0] = 1;
        table[8][1] = 0;
        table[8][2] = 0;
        table[8][3] = 1;
        table[8][4] = 0;
            
        table[9][0] = 1;
        table[9][1] = 0;
        table[9][2] = 1;
        table[9][3] = 0;
        table[9][4] = 0;
	    
    }
}
