/** 
* The Quarterback class gets info about a quaterback(yards, completions, touchdowns,
*attempts, and interceptions and gives it a rating.
* @author Nikhil G. Khatu (ngkhatu@ncsu.edu)
* Help from TAs: Matt Rakow & Shen Zhang
*Lab Section- 231
*@version 03/06/06
*/

public class Quarterback
{
	private double yards;
	private double touchdowns;
	private double completions;
	private double attempts;
	private double interceptions;
	private double rating;
	private String Qname;
	private String Tname;
	
	/**
 	 * Quarterback initializes the instance variables to 0, accepts n and t as parameters
	 *@param n name of QB
	 *@param t name of team
 	 */
	public Quarterback(String n, String t)
	{
	yards=0;
	touchdowns=0;
	completions=0;
	attempts=0;
	interceptions=0;
	rating=0;	
	Qname=n;
	Tname=t;
	}
	
	
	/**
 	 * setYards accepts number of yards and sets it to instance variable
	 *@param y number of yards
 	 */
	public void setYards(int y){
		if (y>= 0){
			yards= y;
		}
	}
	/**
 	 * setTouchdowns accepts number of touchdowns and sets it to instance variable
	 *@param t number of touchdowns
 	 */
	public void setTouchdowns(int t){
		if (t>=0){
			touchdowns= t;
		}
	}
	/**
 	 * setCompletions accepts number of completions and sets it to instance variable
	 *@param c number of completions
 	 */
	public void setCompletions(int c){
		if (c>=0){
			completions= c;
		}
	}
	/**
 	 * setAttempts accepts number of attempts and sets it to instance variable
	 *@param a number of attempts
 	 */
	public void setAttempts(int a){
   		if (a>=0){
			attempts=a;
		}
	}
	/**
 	 * setInterceptions accepts number of interceptions and sets it to instance variable
	 *@param i number of interceptions
 	 */
    	public void setInterceptions(int i){
		if (i>= 0){
			interceptions=i;
    		}
	}
    	
	/**
 	 * getRating calculates rating and returns the rating variable
 	 * @return rating total calculated rating of the QB
	 */
	public double getRating()
    	{
	
	
		if (attempts==0){
			return 0.0;
		}
		
		else {
			double temp= ((completions/attempts)*100-30)*0.05;
				if (temp>2.375) {
					rating= 2.375;
				}
			
				else if (temp>0){
					rating= temp;
				}
			
				temp= ((yards/ attempts)-3)*0.25;
				if (temp>2.375) {
					rating= 2.375 + rating;
				}
				
				else if (temp>0){
					rating= temp +rating;
				}	
				
				temp= ((touchdowns/attempts)*100)*0.2;
				if (temp>2.375) {
					rating= 2.375 + rating;
				}
				
				else {
					rating= temp +rating;
				}
				
				temp= 2.375- (interceptions/attempts)*25.0;
				if (temp>=0){
					rating= rating +temp;
				}
		rating=(rating/6)*100;
		return rating;
		
		
		
		}
	
	
	
	}
    
    	public String getName(){
		return Qname;
    	}
    
    	/**
     	* The main method is used for testing purposes only.
     	*
     	* @param args Command line arguments, not used.
     	*/
     	public static void main(String args[])
     	{
     		Quarterback r = new Quarterback("Joey Wolfpack", "NC State");
     		r.setYards(62);
     		r.setTouchdowns(1);
     		r.setCompletions(6);
     		r.setAttempts(10);
     		r.setInterceptions(1);
     		System.out.println("The rating should be 71.7.");
     		System.out.println("Your code calculates a rating of " + r.getRating());
     	
	
		r = new Quarterback("Yaroslav Maksymiv", "Ukraine");
     		r.setYards(5);
     		r.setTouchdowns(0);
     		r.setCompletions(2);
     		r.setAttempts(1000);
     		r.setInterceptions(0);
     		System.out.println("The rating should be 39.6 for the Ukranian.");
     		System.out.println("Your code calculates a rating of " + r.getRating());
	
	
		r = new Quarterback("Nikhil G. Khatu", "India");
     		r.setYards(100);
     		r.setTouchdowns(20);
     		r.setCompletions(10);
     		r.setAttempts(15);
     		r.setInterceptions(3);
     		System.out.println("The rating should be 85.4 for the Indian.");
     		System.out.println("Your code calculates a rating of " + r.getRating());
	}

}
