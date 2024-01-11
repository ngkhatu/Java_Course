import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * DrawingPanel creates a panel used for drawing
 * a map
 *
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public class DrawingPanel extends JPanel {
    
	/** Graphics object used for drawing on the panel */                            
	private Graphics g;                   
	
	/** Tells if it is time to draw */
	private boolean timeToDrawPath; 
	
	/** The filename of the hurricane path */
	private String pathFile;
	
	private FileReader fr;
	
	private BufferedReader br;
	
	/**
	* Creates a new, white DrawingPanel for drawing the maps
	*/
	public DrawingPanel() {
		setBackground(Color.white); 
		this.timeToDrawPath = false;
		this.pathFile = null;
	}

	/**
	* This method is called automatically by Java.  There will NEVER
	* be a direct call to paint() anywhere in the code.  Anytime that we
	* neet to update what is drawn on the screen, we call repaint().
	* 
	* @param grph The graphics window to paint
	*/
	public void paint(Graphics grph) {
		g = grph;

		super.paint(g);
		processUSA();

		if (timeToDrawPath){
			drawPath();
		} 
	}

	/**
	* Reads the USA coastline coordinates from a file and draws the path
	* to the panel 
	*/
	public void processUSA() {
		//just an example of how to draw a single
		//line segment from (50,50) to (200,200)
		try {
	
		fr = new FileReader("usa.txt");
		
		br = new BufferedReader(new FileReader("usa.txt"));
		
		int x1 = Integer.parseInt(br.readLine());
		
		int y1 = Integer.parseInt(br.readLine());
		
		String s;
		
		while((s = br.readLine()) != null){
			int x2 = Integer.parseInt(s);
			int y2 = Integer.parseInt(br.readLine());
			g.drawLine(x1,y1,x2,y2);
			x1 = x2;
			y1 = y2;
		}
		//g.drawLine( 115,125,10,150);
	}
    catch (IOException e) {
        System.err.println("Read error: " + e);
        System.exit(1); //end the program
    } 
	}

	/**
	* Receives the file name containing the
	* coordinates for the hurricane path
	* 
	* @param filename the file containing the coordinates for the path of the hurricane 
	*/ 
	public void processPath(String filename) {
		// complete method
		pathFile = filename;	
		timeToDrawPath= true;
		repaint();
	}

	/**
	* Reads the hurricane path coordinates from the given file and draws
	* the path.
	*/
	private void drawPath() {
		try {
	
		fr = new FileReader(pathFile);
		
		br = new BufferedReader(new FileReader(pathFile));
		
		int x1 = Integer.parseInt(br.readLine());
		
		int y1 = Integer.parseInt(br.readLine());
		
		String s;
		
		while((s = br.readLine()) != null){
			int x2 = Integer.parseInt(s);
			int y2 = Integer.parseInt(br.readLine());
			g.drawLine(x1,y1,x2,y2);
			x1 = x2;
			y1 = y2;
		}
	}
    catch (IOException e) {
        System.err.println("Read error: " + e);
        System.exit(1); //end the program
    }
}
}

