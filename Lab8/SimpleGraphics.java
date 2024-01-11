import java.awt.*;
import javax.swing.*;

/**
 * Simple Graphics is an examples of graphics for Lab 8.
 *
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
class SimpleGraphics extends JFrame{
	
	/**
	 * The default constructor that sets the GUI up
	 */
    public SimpleGraphics() {
        setTitle("Simple Graphics");
        setSize(500,500);
        setLocation(100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
	
	/**
	 * The paint method that sets up retangles.
	 *
	 * @param g the graphics object
	 */
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(100,100,50,200);
    }

	/**
	 * The main method starts the program.
	 *
	 * @param args command line arguemnts at runtime
	 */
    public static void main(String args[]) {
        SimpleGraphics g = new SimpleGraphics();
    }
}

