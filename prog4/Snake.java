/**
 * The Snake class represents the snake in the game, more specifically
 * where each piece of the snake lies in terms of (x,y), and it's length.
 * @author Nikhil G. Khatu (ngkhatu.ncsu.edu)
 * Help from TAs: Matt Rakow & Shen Zhang
 *Lab Section- 231
 *@version 04/20/06
 */

public class Snake
{
	/**
	 * The length of the snake
	 **/
	private int length;
	
	/**
	 * This array tells the position of each piece of the snake
	 * [0][0] is the head of the snake's x-coordinate
	 * [0][1] is the head of the snake's y-coordinate
	 */	
	private int position[][];
	
	/**
	 * This tells if the snake is growing (meaning it just ate a ball)
	 */
	private boolean growing;
	
	/**
	 * This tells how many more pieces of the snake are to be added each time it moves
	 * based on growth from eating a ball
	 */
	private int remainingGrowth;
	
	/**
	 * This is the constructor that sets up the snake's variables
	 */
	public Snake()
	{
		remainingGrowth = 0; // it should not grow yet	
		growing = false; // it is not growing at this time
		length = 5; // it starts out being 5 units long
		
		position = new int[50][2]; // this array starts out as 50 units, each with an x and a y coordinate.
		                           // it is made big to account for the growth of the snake.
				
		// This sets the y coordinate of the snake's head and body to 5
		for(int i = 0; i < 5; i++)
		{
			position[i][1] = 5;
		}
		
		// here we set the x coordinates for the snake (each piece of the snake is 5 pixels long and high).
		// This is how the GUI sees the coordinates (in case you are wondering why the numbers look strange)
		/**
		 *  (0,0)..................(100,0)
		 *    .						  .
		 *    .						  .
		 *    .						  .
		 *    .						  .
		 *  (0,100)................(100,100)
		 */
		position[0][0] = 25;
		position[1][0] = 20;
		position[2][0] = 15;
		position[3][0] = 10;
		position[4][0] = 5;		
	}
    /**
     * This method returns length of snake
     *
     * @return length of snake
     */
	public int getLength()
	{
		return length;
	}
	/**
     * This method returns xcoord. of snake part
     *@param part number of snake part
     * @return position[part][0] x coordinate of snake's part
     */
	public int getX(int part)
	{
		return position[part][0];
	}
	/**
     * This method returns ycoord. of snake part
     *@param part number of snake part
     * @return position[part][1] y coordinate of snake's part
     */
	public int getY(int part)
	{
		return position[part][1];
	}
	/**
     * This method points snake in direction of key press
     *@param direction direction of key press
     */
	public void directSnake(int direction)
	{
		if(direction==0) position[0][1]= position[0][1] - 5;
		if(direction==1) position[0][0]= position[0][0] - 5;
		if(direction==2) position[0][1]= position[0][1] + 5;
		if(direction==3) position[0][0]= position[0][0] + 5;
	}
	/**
     * This method determines if snake collides with itself
     *
     * @return returns true or false value after test
     */
	public boolean collision()
	{
		for(int i=1; i <= this.getLength() ; i++){
			if((position[0][0] == position[i][0]) && (position[0][1]== position[i][1])){
				return true;
			}
		}
		return false;
	}
		
	/**
	 * This method handles moving the snake in a certain direction.
	 * The head moves in that direction 5 pixels.
	 *
	 * The rest of the snake may or may not move depending on whether
	 * or not the snake is growing.  If it is not, the rest of the snake
	 * simply moves to the position the spot in front if it used to be in.
	 *
	 * If the snake is growing, the rest of the snake does not move, and the new
	 * unit of the snake is added to the position where the head used to be, thus
	 * creating the illusion of the snake growing
	 *
	 * @param direction The direction the snake is moving (0-UP 1-LEFT 2-DOWN 3-RIGHT)
	 */
	public void move(int direction)
	{
		// If the snake is not growing
		if(!growing)
		{	
			// move the position of the body units to the previous position
			// of the unit in front of it	
			for(int i = length - 1; i > 0; i--)
			{
				position[i][0] = position[i-1][0];
				position[i][1] = position[i-1][1];
			}
		}
		
		// If the snake is growing
		else
		{
			// we move the units down a notch in the array to make
			// room for the new "grown" unit, which is placed behind the
			// head of the snake (position 0 in the array)
			for(int i = length; i > 0; i--)
			{
				position[i][0] = position[i-1][0];
				position[i][1] = position[i-1][1];
			}
			
			remainingGrowth--; // decrement the count of units that need to be grown
			length++; // add one to the length of the snake
			
			// if the snake is done growing, we set growing to false
			if(remainingGrowth == 0)
				growing = false;
		}
		
		directSnake(direction);		
	}
		
	/**
	 * This method handles making the array of positions bigger if the snake grows
	 * from eating a ball.  It also sets the growing variable to true and adds 3 to
	 * the remaining growth.
	 */
	public void grow()
	{		
		growing = true;
		remainingGrowth += 3;
		
		// if the snake is becoming bigger than the array can hold, we need to add to
		// its length and copy over the values	
		if((length % 50)  > 40)
		{
			int[][] temp = new int[length+50][2];
			for(int i = 0; i < length; i++)
			{
				temp[i][0] = position[i][0];
				temp[i][1] = position[i][1];
			}
			position = temp;
		}			
	}
		
}