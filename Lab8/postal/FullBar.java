package postal;

/**
 * FullBar describes the FullBar for the postal codes.
 *
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public class FullBar extends Bar{
	
	/**The instance of the FullBar for this class.*/
	private static FullBar instance;
	
	/**The height of the FullBar*/
	private int mi_Height;
	/**
	 * The default constructor for the FullBar class.
	 * All instance variables are initialized here.
	 */
	private FullBar() {
		instance = null;
		mi_Height = 20;
	}

	/**
	 * sale returns the instance.  If it is null, it creates a new instance, 
	 * before returning it.
	 *
	 * @return the current instance of FullBar
	 */
	public static FullBar sole() {
		if (null == instance) {
			instance = new FullBar();
		}
		return instance;
	}

	/**
	 * getHeight returns the height of the FullBar
	 *
	 * @return the height of the FullBar
	 */
	public int getHeight() {
		return mi_Height;
	}

	/**
	 * setHeight sets the height of the FullBar
	 *
	 * @param height the height of the FullBar
	 */
	protected void setHeight(int height) {
		mi_Height = height;
	}



}
