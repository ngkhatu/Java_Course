/**
 * The ScubaMath class finds atmospheric pressure and different depths useful for scuba diving.
 * @author Nikhil G. Khatu (ngkhatu@ncsu.edu)
 * Help from TAs: Matt Rakow & Shen Zhang & Ben Newlin
 *Lab Section- 231
 *@version 02/07/06
 */

public class ScubaMath {
	
	
	/**
 	 * PressureAtm calculates the atmospheric pressure the diver is experiencing at a certain depth.
	 *@param feet the depth of diver
 	 */
	public void pressureAtm(int feet) {
		double ATM=1 + (feet/33.0);
		System.out.print ("At " +feet+  " feet the diver is experiencing "+ATM+ " ATMs of pressure.");
	}

	
	/**
 	 * maximumDepth calculates the maximum depth given the percentage of oxygen.
	 * @param percentO the percent oxygen
 	 */
	public void maximumDepth(int percentO) {
		int Mdep= ((4620)/ percentO)-33;
		System.out.print ("The maximum safe depth with "+percentO+"% oxygen is "+(int)Mdep+" feet.");
	}

	
	/**
 	 * contingencyDepth calculates the contingency depth for the gas that is being used incase of an emergency
	 * @param percentO the percent oxygen
 	 */
	public void contingencyDepth(int percentO) {
		int Cdep= (5280/percentO) - 33;
		System.out.print ("The contingency depth with "+percentO+"% oxygen is "+(int)Cdep+" feet.");
	}

	
	/**
 	 * ead is the equivalent air depth, based on the percent oxygen and depth
	 * @param percentO the percent oxygen, given by "testPiece.ead(percentO,depth)
	 * @param depth depth of diver
 	 */
	public void ead(int percentO, int depth) {
		int Adep= ( ( (100- percentO ) * (depth + 33) )/ (100- 21) ) - 33;
		System.out.print ("The EAD for "+percentO+"% oxygen at "+depth+" feet is "+(int)Adep+".");
	}

	
	
	/**
	 * The main method is where the test code should be placed for
	 * this project.  One test call to each method was provided by
	 * the instructor.
	 * @param args the command line arguments which we are not using
	 */
	public static void main(String[] args) {
		//Create an object of type ScubaMath to use for the testing
		ScubaMath testPiece = new ScubaMath();
		
		
		
		
		//Instructor provided test for the pressureAtm method
		testPiece.pressureAtm(133);
		System.out.println("----------------------------------------------------------------------");
		
		//Instructor provided test for the maximumDepth method
		testPiece.maximumDepth(21);
		System.out.println("----------------------------------------------------------------------");

		//Instructor provided test for the contingencyDepth method
		testPiece.contingencyDepth(21);
		System.out.println("----------------------------------------------------------------------");

		//Instructor provided test for the ead method
		testPiece.ead(39,68);
		System.out.println("----------------------------------------------------------------------");
	
	
	
	
		
		//Instructor provided test for the pressureAtm method
		testPiece.pressureAtm(233);
		System.out.println("----------------------------------------------------------------------");
		
		//Instructor provided test for the maximumDepth method
		testPiece.maximumDepth(30);
		System.out.println("----------------------------------------------------------------------");

		//Instructor provided test for the contingencyDepth method
		testPiece.contingencyDepth(30);
		System.out.println("----------------------------------------------------------------------");

		//Instructor provided test for the ead method
		testPiece.ead(50,80);
		System.out.println("----------------------------------------------------------------------");
	
	
	
	
			
		//Instructor provided test for the pressureAtm method
		testPiece.pressureAtm(333);
		System.out.println("----------------------------------------------------------------------");
		
		//Instructor provided test for the maximumDepth method
		testPiece.maximumDepth(40);
		System.out.println("----------------------------------------------------------------------");

		//Instructor provided test for the contingencyDepth method
		testPiece.contingencyDepth(40);
		System.out.println("----------------------------------------------------------------------");

		//Instructor provided test for the ead method
		testPiece.ead(50,70);
		System.out.println("----------------------------------------------------------------------");
	
	}
}
