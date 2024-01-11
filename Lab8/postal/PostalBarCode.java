package postal;
import java.awt.*;
import java.util.*;

/**
 * PostalBarCode provides the methodology for drawing the 
 * bar codes in the Postal Bar Codes Lab.
 *
 * @author <enter your namae here>
 * @version 1.0
*/
public class PostalBarCode extends Component {
	private int maxHeight = 30;
	private int bufferSpace = 10;
	private int mi_Space = 5;
	private Vector mv_Bars = new Vector();

	/**
	 * The constructor for this class sets the background color to white
	 * and the foreground color to black, and initializes all instance variables.
	 */
	public PostalBarCode() {
		maxHeight = 30;
		bufferSpace = 10;
		bufferSpace = 10;
		mi_Space = 5;
		mv_Bars = new Vector();
		setForeground(Color.black);
		setBackground(Color.white);
	}

	/**
	 * paint accepts a graphics object and draws the rectangles that correspond
	 * to the full and half bars.
	 * This method is never called directly.
	 *
	 * @param g graphics objectused to draw the bars
	 */
	public void paint(Graphics g) {
		int offset = 0;
		int i = 0;
		Bar bar	= null;
	
		g.setColor(this.getBackground());
		g.fillRect(0,0,this.WIDTH, this.HEIGHT);
		g.setColor(this.getForeground());
		
		g.fillRect(bufferSpace, 
		maxHeight - FullBar.sole().getHeight(), 
		FullBar.sole().getWidth(), FullBar.sole().getHeight());
	
		for (i = 0; i < mv_Bars.size(); i++) {
			bar = (Bar)mv_Bars.elementAt(i);
			offset = maxHeight - bar.getHeight();
			g.fillRect((i+1) * mi_Space + bufferSpace, offset, bar.getWidth(), bar.getHeight());
		}
	
		g.fillRect((i+1) * mi_Space + bufferSpace, 
		maxHeight - FullBar.sole().getHeight(), 
		FullBar.sole().getWidth(), 
		FullBar.sole().getHeight());
	}

	/**
	 * clearCode removes all elements from the GUI.
	 */
	public void clearCode() {
		mv_Bars.removeAllElements();
	}
	
	/**
	 * drawFullBar adds the full bar to the GUI, and calls repaint to put it on the screen.
	 */
	public void drawFullBar() {
		mv_Bars.addElement(FullBar.sole());
		repaint();
	}
	
	/**
	 * drawSmallBar adds the full bar to the GUI, and calls repaint to put it on the screen.
	 */
	public void drawSmallBar() {
		mv_Bars.addElement(SmallBar.sole());
		repaint();
	}
	
	/**
	 * setSpacing adds the spaces in between the bars in the bar code on the GUI.
	 *
	 * @param space the number of spaces to add to the GUI
	 */
	public void setSpacing(int space) {
		mi_Space = space;
	}
	
	/**
	 * setFullBarHeight sets the height of the full bar.
	 *
	 * @param height the height of the full bar
	 */
	public void setFullBarHeight(int height) {
		if (height > SmallBar.sole().getHeight() && height < maxHeight){
			FullBar.sole().setHeight(height);
		}
	}
	
	/**
	 * setSmallBarHeight sets the height of the full bar.
	 *
	 * @param height the height of the small bar
	 */
	public void setSmallBarHeight(int height) {
		if (height > 0 && height < FullBar.sole().getHeight()) {
			SmallBar.sole().setHeight(height);
		}
	}
}
