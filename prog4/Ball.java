/**
 * This class keeps track of an individual ball that can be eaten
 * by the snake.  It simply has an x and y coordinate.
 */
public class Ball
{
	/**
	 * The x-coordinate of the ball
	 */
	private int x;
	
	/**
	 * The y-coordinate of the ball
	 */
	private int y;
	
	/**
	 * This constructor takes two random ints between 0 and 100, which 
	 * are used to determine where the ball is placed.  The ball is placed
	 * to the neares multiple of 5 for x and y because the ball is a 5*5 picture,
	 * and it needs to align with the 5*5 picture of the snake.
	 *
	 * @param x The random x coordinate
	 * @param y The random y coordinate
	 */
	public Ball(int x, int y)
	{
		x = x - (x%5);
		if(x == 0)
			x = 5;
		if(x == 100)
			x = 95;
		y = y - (y%5);
		if(y == 0)
			y = 5;
		if(y == 100)
			y = 95;
		this.x = x;
		this.y = y;
	}	
	
	/**
	 * This method returns the x-coordinate of the ball
	 *
	 * @return The x-coordinate of the ball
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * This method returns the y-coordinate of the ball
	 *
	 * @return The y-coordinate of the ball
	 */
	public int getY()
	{
		return y;
	}	
}