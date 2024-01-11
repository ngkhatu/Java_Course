/**
 * Class Exercise3 prints out numbers.
 *@author Sam DeFilipp (sjdefili@ncsu.edu)
 *@author Nikhil Khatu (ngkhatu@ncsu.edu)
 *@author Jacob Freeman(jjfreema@ncsu.edu)
 *@author Robert Johnston (wrjohnst@ncsu.edu)
 *@version 1.0
 */
public class Exercise3 {

/**
*@param args
*/
	public static void main (String[] args) {
	for ( int x = 1 ; x <= 9 ; x++) {
		for( int y=9; y >=x; y--) {
			System.out.print(y);
		}

	System.out.println();
	}
	}
}
