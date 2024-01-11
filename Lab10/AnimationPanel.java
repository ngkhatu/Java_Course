import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * AnimationPanel is the panel where the animation takes place.
 * 
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public class AnimationPanel extends JPanel implements ActionListener, MouseListener {

	/** width of the panel */
	private final int WIDTH  = 500;

	/** height of the panel */
	private final int HEIGHT = 500;

	/** width of the image */
	private final int IMAGE_WIDTH  = 167;

	/** height of the image */
	private final int IMAGE_HEIGHT = 240;

	/** the image */
	private ImageIcon image;

	/** the timer for the animation */
	private Timer timer;

	/** the x coordinate */
	private int x;

	/** the y coordinate */
	private int y;

	/** the amount that the x coordinate is to change */
	private int moveX;

	/** the amount that the y coordinate is to change */	
	private int moveY;

	/** the text field for the tally of the hits on the image */
	private JTextField tallyTextField;

	/** the total number of hits */
	private int totalHits;


	/**
 	 * Creates a panel for the animation
 	 *
 	 * @param countDown timer interval (in milliseconds) for updating panel
 	 * @param tally textfield to update when mouse clicked on image
 	 **/

	public AnimationPanel (Timer countDown,JTextField tally) {
		timer = countDown;
		tallyTextField = tally;
		totalHits = 0;

		timer.addActionListener(this);  // Add the panel object as a listener for timer
		addMouseListener(this);

		ClassLoader cl=this.getClass().getClassLoader();  // Gets a special loader...
		image = new ImageIcon (cl.getResource("TAFace.gif"));  // ... to load the .gif file

		x = 0;
		y = 40;

		moveX = 10;
		moveY = 10;

		setBackground(Color.red);
		setPreferredSize (new Dimension (WIDTH,HEIGHT));
		setLocation (100,100);
	}


	/**
 	 *
	 * Paint icon at (x,y)
	 * 
	 * @param page graphics object used for updates
	 **/
	public void paintComponent (Graphics page) {
		super.paintComponent (page);
		image.paintIcon( this, page, x, y);
	}


	/**
	 * Receives control when timer has counted down
	 * and updates (x,y) for painting next image
	 *
	 * @param event that caused action
	 **/
	public void actionPerformed (ActionEvent event) {  // Invoked each time timer interval
		java.util.Random m = new java.util.Random();
		m.nextInt(300);
		x = m.nextInt(500-IMAGE_WIDTH);
		y = m.nextInt(500-IMAGE_HEIGHT);

		if (x <= 0 || x >= WIDTH-IMAGE_WIDTH){
 			moveX = -moveX ;
		}
 		if (y <=0 || y >= HEIGHT-IMAGE_HEIGHT){
 			moveY = -moveY;
		}

		repaint();
	}

  	public void mouseMoved(MouseEvent e) { }
  	public void mousePressed(MouseEvent e) { }
  	public void mouseReleased(MouseEvent e) { }
  	public void mouseEntered(MouseEvent e) { }
  	public void mouseExited(MouseEvent e) { }

  	/**
   	 * Receives control when left mouse button is clicked
   	 * Determines if mouse click is inside image, if so
   	 * updates tally count in text field.
   	 *
   	 * @param MouseEvent the mouse event
   	 **/
  	public void mouseClicked(MouseEvent e) {
    		System.out.println("mouse clicked at: " + e.getX() + ", " + e.getY());
    		if((e.getX() > x && e.getX() < x + IMAGE_WIDTH) && (e.getY() > y && e.getY() < y + IMAGE_HEIGHT)){
			totalHits++;
		}
    		tallyTextField.setText ("" + totalHits);
  	}
}
