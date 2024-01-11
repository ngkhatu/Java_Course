package postal;

/**
 * Small Bar describes the small bar in the postal code.
 *
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public class SmallBar extends Bar {
	
	/**the SmallBar instance for this class*/
	private static SmallBar instance;
	
	/**the height of the SmallBarr*/
    private int  mi_Height;
	
	/**
	 * The default constructor for the SmallBar class.
	 * All instance variables are initialized here.
	 */
	private SmallBar() {
		instance = null;
		 mi_Height = 10;
	}
	
	/**
	 * sale returns the instance.  If it is null, it creates a new instance, 
	 * before returning it.
	 *
	 * @return the instance of the SmallBar
	 */
	public static SmallBar sole() {
		if (null == instance) {
			instance = new SmallBar();
		}
		return instance;
	}
	
	/**
	 * getHeight returns the height of the SmallBar.
	 *
	 * @return the height of the SmallBar
	 */
	public int getHeight() {
		return mi_Height;
	}
	
	/**
	 * setHeight sets the height of the SmallBar
	 *
	 * @param height the height of the SmallBar
	 */
	protected void setHeight(int height) {
		mi_Height = height;
	}

        

}
