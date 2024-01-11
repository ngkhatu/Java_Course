package postal;

/**
 * The Bar class describes the bar for the Postal Frame Lab.
 * 
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public abstract class Bar {
	
	private int mi_Width;
	
	/**
	 * Default constructor for the Bar class.  All instance variables
	 * are initialized here.
	 */
	public Bar(){
		this.mi_Width = 2;
	}
	
	/**
	 *  setWidth sets the width of the bar.
	 *
	 * @param width the width of the bar
	 */
	protected void setWidth(int width) {
		mi_Width = width;
	}
	
	/**
	 * getWidth answers the width of the bar.
	 *
	 * @return the width of the bar.
	 */
	protected int getWidth() {
		return mi_Width;
	}
	
	/**
	 * getHeight returns the height of the bar.
	 * This method must be overwritten.
	 *
	 * @return height the height of the bar
	 */
	public abstract int getHeight();
}
