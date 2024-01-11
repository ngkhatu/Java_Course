import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is the GUI that shows the game.
 * All this class does is set up the frame with the components,
 * one of which being the panel that has the graphical game in it.
 */
public class SnakeGUI extends JFrame {
    /**
     *  A number used with the timer. each 100 is .1 second
     *              200  ---  .2 seconds
     *              500  ---  .5 seconds
     */
    private final int DELAY = 100;
    
    /**
     * The timer class that will call actionPerformed every DELAY.
     */
    private Timer timer;
    
    /**
     *	This label shows the score and will also hold the "focus" of the keyboard.
     */
	private JLabel score;
    
    /**
     * This label shows the current high score
     */
    private JLabel highScore;
    
    /**
     *	This is the constructor, which calls a method that sets up the GUI with all it's components
     *
     */
    public SnakeGUI()
    {
    	init();
    }
    
    /**
     * Initializes the GUI. Creates the layout, creates a timer to
     * use in updating the panel that shows the game's graphics.
     */
    public void init() {
    	
	score = new JLabel("");
        timer = new Timer(DELAY, null);// Creates a timer object using a .1 second interval
        
        JPanel scorePanel = new JPanel();// creates the panel for the score that will be displayed
		
        scorePanel.add(score, BorderLayout.CENTER);//adds the label to a panel
        
        highScore = new JLabel("High Score: ");
        JPanel highScorePanel = new JPanel(); // a panel for holding the high score label
        
        highScorePanel.add(highScore, BorderLayout.CENTER);
        
        this.pack(); // this will make the GUI recognize the components that have been added.
        			 // This is important because without it, the game will not respond to
        			 // keyboard buttons as will be shown later.
        
		Container c = getContentPane(); // container for the components
		
        c.add(new SnakePanel(timer, score, highScore), BorderLayout.CENTER); 
                                    // creates the SnakePanel and then adds to the container 

		c.add(highScorePanel, BorderLayout.NORTH); // adds the high score panel to the north region
		
        c.add(scorePanel, BorderLayout.SOUTH); // adds the score panel to the container
        
        score.setFocusable(true); // This allows the label score to have keyboard focus
        
        score.requestFocusInWindow(); // This gives the label score the keyboard focus
        
        setTitle("Snake Race"); // title
        setLocation(100,100); // location
		setSize(310,350); // size
		setDefaultCloseOperation(EXIT_ON_CLOSE); // end the program when the window is closed
		
		setVisible(true); // show the GUI 
		
    }
   
    /**
     * This main method just creates a new GUI which starts the game.
     *
     * @param args Command Line arguments, which are not used
     */
    public static void main(String args[])
    {
    	new SnakeGUI();
    }

}



