import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 * The SnakePanel class sets up the graphical panel that is seen in the GUI.
 * @author Nikhil G. Khatu (ngkhatu.ncsu.edu)
 * Help from TAs: Matt Rakow & Shen Zhang
 *Lab Section- 231
 *@version 04/20/06
 */
 
public class SnakePanel extends JPanel implements ActionListener, KeyListener {

	/**
	 * This is the HighScore object that allows you to get the current high score and set a new one
	 */
	private HighScore highScore;
	 
	/**
	 * This is the timer which fires an action to actionEvent every .1 seconds
	 */
	private Timer timer;
	
	/**
	 * This object allows easy access to the pictures that are used in the graphical part of the game
	 */
	private ClassLoader cl;
	
	/**
	 * This image is one piece of the snake (multiple uses of it add up to the entire snake)
	 */
	private ImageIcon s;
	
	/**
	 * This image is the ball that the snake eats
	 */
	private ImageIcon b;
	
	/**
	 * This image is the wall around the snake and the balls (multiple uses again make up the wall)
	 */
	private ImageIcon w;
	
	/**
	 * This array is a collection of all the balls in the game
	 */
	private Ball balls[];
	
	/**
	 * This is the snake object to be used in the game
	 */
	private Snake snake;
	
	/**
	 * This variable knows what direction the snake is moving in
	 * 0 - UP
	 * 1 - LEFT
	 * 2 - DOWN
	 * 3 - RIGHT
	 */
	private int direction;
	
	/**
	 * Random int creater is used to position balls
	 */
	private Random r;
	
	/**
	 * Label for showing the score
	 */
	private JLabel score;

	/**
	 * Label for showing the high score
	 */
	private JLabel lblHighScore;
		
	/**
	 * This keeps track of the number of balls eaten (the score)
	 */
	private int eaten;
	
    /**
     * The constructor which creates the panel that has the graphics in it.
     *
     * @param countDown  timer object used for updating panel
     * @param k The Label that has keyboard focus and shows the score.
     * @param hs The Label that contains the high score
     */
    public SnakePanel (Timer countDown, JLabel k, JLabel hs) {
    	
    	score = k; // initializes the label
    	score.setText("Balls Eaten: " + 0);
    	highScore = new HighScore();
	
    	lblHighScore = hs;
    	lblHighScore.setText("High Score: " + highScore.getHighScoreFromFile());
    	
    	direction = 3; // sets the starting direction of the snake to RIGHT
    	
        timer = countDown;  // sets the local Timer to a instance variable
        timer.start(); // starts the timer
        
        
        r = new Random(); // sets up random to be used to generate balls
        snake = new Snake(); // sets up the snake object
        balls = new Ball[5]; // initializes the array to have 5 balls
        eaten = 0; // starts the score off at 0
        
        makeBalls(); // this methodcall initializes the ball objects and puts them in the array
        
      	
        timer.addActionListener(this);  // This causes the actionPerformed to run each time the timer hits .1 seconds
        
        timer.setDelay(400); //** INCREASE THIS NUMBER TO SLOW DOWN THE SNAKE! **
        
        score.addKeyListener(this); // This tells the program to listen to the keyboard when the label score is focused
        
        cl = this.getClass().getClassLoader();  // this sets up the picture loader
        s = new ImageIcon(cl.getResource("snake.GIF")); // this loads the picture
		b = new ImageIcon(cl.getResource("ball.GIF")); // this loads the picture
		w = new ImageIcon(cl.getResource("wall.GIF")); // this loads the picture
        
        score.requestFocusInWindow(); // again, we ask for the label to have the keyboard focus, just in case.
        setBackground(Color.red); //sets the background of the game to red
        setSize(100,100);  // sets the size
    }
    /**
     * This method checks for collision of snake w/ walls and itself.
     * 
     */
    public void checkForCollisions()
    {
	if(snake.getX(0)== 0 || snake.getX(0)== 100 || snake.getY(0)== 0 || snake.getY(0)== 100 || snake.collision()==true){
		timer.stop();
		if(eaten > highScore.getHighScoreFromFile()){
			highScore.writeHighScoreToFile(eaten);
			lblHighScore.setText("New High Score: " + highScore.getHighScoreFromFile());
		}

	}

    }
    /**
     * This method tests the x and y coordinates of the ball and snakes head to
     * determine if ball is eaten.
     * 
     * @param whichBall defines which ball needs to be tested
     * @return returns true or false depending on status of the ball
     */
    public boolean ballWasEaten(int whichBall)
    	{
		if( ((snake.getX(0)) == (balls[whichBall].getX()) ) && ((snake.getY(0))== (balls[whichBall].getY()) ) ){
			balls[whichBall]= null;
			eaten= eaten + 1;
			snake.grow();
			return true;
		}
		return false;
	}


	/**
     * This method goes through the balls array and tests to see if all the balls are eaten.
     * 
     * @return returns true or false depending on whether all the balls are eaten.
     */ 
	public boolean finished()
	{
		int c=0;
		for(int i=0; i<5; i++){
			if (balls[i]== null) c= c+1;
		}
		if (c==5) return true;
		return false;
		}
	
	/**
     * This method makes 5 new balls.
     * 
     */
	public void makeBalls()
	{
		for(int i=0; i < 5; i++){
			balls[i]= new Ball(r.nextInt(101) , r.nextInt(101));
		}

	}


        



    /**
     * This is another required method from implementing KeyListener.  This method
     * responds to keys being pressed (meaning pushed and held down).  Here, we listen
     * for an arrow key being pushed and change the direction of the snake based on which one
     * was pushed.
     *
     * Every key on the keyboard has a number associated with it, known as its KeyCode.  This is
     * how we tell key was pushed.
     *
     * @param e the key that was pushed.
     */
    public void keyPressed(KeyEvent e) {
  
  		if(e.getKeyCode() == 37) direction= 1;
		if(e.getKeyCode() == 38) direction= 0;
		if(e.getKeyCode() == 39) direction= 3;
		if(e.getKeyCode() == 40) direction= 2;
	}

	/**
	 * Similar to the way actionPerformed handles events that occur in the gui,
	 * keyTyped handles the event of a key being typed. Although it is not used for anything,
	 * by implementing KeyListener we are required to have it.
	 *
	 * @param e the key that was typed.
	 */
    public void keyTyped(KeyEvent e) {
    	// DO NOT ENTER CODE HERE
    }
    
    /**
     * This is the final required method from implementing KeyListener.
     * It handles when a key is released, or let go of after it was pushed down.
     * 
     * @param e the key being released
     */
    public void keyReleased(KeyEvent e) { 
    
    	// DO NOT ENTER CODE HERE   	
    }
    
    /**
     * This method responds to the TIMER object, which fires an action every .1 seconds
     *
     * @param event The timer object telling the program that .1 seconds has passed
     */
    public void actionPerformed(ActionEvent event) {
    	repaint(); // tells the GUI to repaint itself
    }
    
    /**
     * This method paints the walls, snake, and balls.
     * It is called every .1 seconds.
     * 
     * @param page  graphics object used for updates
     */
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
       
        //first we paint the 10*10 wall  
        for(int i = 0; i < 21; i++)
        {
        	w.paintIcon(this, page, (i*5)+100, 100);
        	w.paintIcon(this, page, (i*5)+100, 200);
        	w.paintIcon(this, page, 100, (i*5)+100);
        	w.paintIcon(this, page, 200, (i*5)+100);
        }
                
        // next we update the snake based on the current direction and paint the snake
        snake.move(direction);
        
        // this paints the snake
        for(int i = 0; i < snake.getLength(); i++)
        {
        	s.paintIcon(this, page, 100+snake.getX(i), 100+snake.getY(i));        	
        }
        
        // here we check to see if the snake crashed into itself or the wall, thus ending the game
		checkForCollisions();
        
        // paint balls if they are still uneaten, or set them to null if they were eaten
        for(int i = 0; i < 5; i++)
        {
        	if(balls[i] != null) // if the ball in this array index was not eaten yet
        	{
        		if(!ballWasEaten(i)) //collision
        			b.paintIcon(this, page, 100+balls[i].getX(), 100+balls[i].getY()); // paint the ball otherwise	
        	}
        }
        
        // if all the balls are eaten, we make new ones
        if(finished())
        {
        	makeBalls();
        }
        
        // update the score
        score.setText("Balls Eaten: " + eaten);
		
    }
}
