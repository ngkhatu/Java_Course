import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.text.NumberFormat;

/**
 * RatingGUI.java
 *
 * This class handles creating a panel for user interaction in the calculating
 * of a rating for a single quarterback.
 *
 * @author Daniel Longo <djlongo@ncsu.edu>
 * @version 1.1
 */
public class RatingGUI extends JPanel implements ChangeListener
{
	/** These spinners are used for the different stats needed to make the calculation */
    	private JSpinner sattempts, scompletions, syards, stds, sints;

	/** These panels are used to organize the components so they appear in a nice way */
    	private JPanel stats, rat;

	/** These are labels for the individual spinners */
    	private JLabel lattempts, lcompletions, lyards, ltds, lints;

	/** This label displays the quarterback's rating */
    	private JLabel rating; 

	/** The Rating object that does the rating calculation */
    	private Quarterback r;
    
    	/** The formats the rating to have a single decimal of precision */
    	private NumberFormat nf;

	/**
	 * The constructor handles creating the components and adding them to the panel
	 * 
	 * @param r The rating object to be used in the calculation
	 */
   	public RatingGUI(Quarterback r)
    	{
        	this.r = r;
	        nf = NumberFormat.getNumberInstance();
		nf.setMinimumFractionDigits(1);
		nf.setMaximumFractionDigits(1);
		nf.setMinimumIntegerDigits(3);
		nf.setMaximumIntegerDigits(3);
        
		setLayout(new BorderLayout());
	        sattempts = new JSpinner();
	        sattempts.addChangeListener(this);
	        scompletions = new JSpinner();
	        scompletions.addChangeListener(this);
	        syards = new JSpinner();
	        syards.addChangeListener(this);
	        stds = new JSpinner();
	        stds.addChangeListener(this);
	        sints = new JSpinner();
	        sints.addChangeListener(this);

        	lattempts = new JLabel("Attempts: ");
	        lcompletions = new JLabel("Completions: ");
	        lyards = new JLabel("Yards");
	        ltds = new JLabel("Touch Downs: ");
	        lints = new JLabel("Interceptions: ");
        
	        rat = new JPanel();
	        rating = new JLabel(r.getName() +": 000.0");
	        rat.add(rating);
        
	        rating.setFont(new Font("Times", 1, 25));

	        stats = new JPanel(new GridLayout(5,2));

	        stats.add(lcompletions);
	        stats.add(scompletions);
	        stats.add(lattempts);
	        stats.add(sattempts);
	        stats.add(lyards);
	        stats.add(syards);
	        stats.add(ltds);
	        stats.add(stds);
	        stats.add(lints);
	        stats.add(sints);

	        add(stats, BorderLayout.CENTER);
	        add(rat, BorderLayout.NORTH);

	        setVisible(true);
	}

	
	/**
	 * This method listens for changes in the spinners, and gets executed whenever
	 * a change has been made.
	 *
	 * @param e The spinner event that triggered this method
	 */
    	public void stateChanged(ChangeEvent e)
    	{
			Integer i = new Integer(0);
	        String s = (sattempts.getValue()).toString();
	        int attempted = Integer.parseInt(s);
	
		s = (syards.getValue()).toString();
		int yards = Integer.parseInt(s);
	
		s = (sints.getValue()).toString();
	        int interceptions = Integer.parseInt(s);
	
		s = (stds.getValue()).toString();
		int touchdowns = Integer.parseInt(s);
        
		s = (scompletions.getValue()).toString();
		int completions = Integer.parseInt(s);
	
		if(yards > 0)
        		r.setYards(yards);
    		
		else
		{
			r.setYards(0);
		    	syards.setValue(i);
		}
		
        	if(interceptions > 0)
	    		r.setInterceptions(interceptions);
	    
		else
		{
			r.setInterceptions(0);
		    	sints.setValue(i);
		}
            
		if(touchdowns > 0)
		    	r.setTouchdowns(touchdowns);
            
		else
		{
			r.setTouchdowns(0);
		    	stds.setValue(i);
		}
	
        	if(completions > 0)
	    		r.setCompletions(completions);            
            
		else
		{
			r.setCompletions(0);
		    	scompletions.setValue(i);
		}
	
		// If attempted is 0, the calculation would produce a runtime error
	        if(attempted >= 0)
		{
			r.setAttempts(attempted);
		
		}        
		
		else	
		{
			r.setAttempts(0);		
			sattempts.setValue(i);
		}
	
		rating.setText(r.getName() + ": " + nf.format(r.getRating()));
	}	

	/**
	 * The main method, which is used for testing purposes only
	 *
	 * @param args Command Line arguments, which are not used
	 */
    	public static void main(String args[])
	{
    		JFrame frame = new JFrame("Quarterback Rating System");
		frame.setSize(700,270);
	        frame.setLocation(200,200);
	        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
		Container c = frame.getContentPane();
	        Quarterback r = new Quarterback("Matt Hasselbeck", "Seattle Seahawks");
	        Quarterback r2 = new Quarterback("Ben Roethlisberger", "Pittsburgh Steelers");
        
        	JPanel player1 = new RatingGUI(r);
	        JPanel player2 = new RatingGUI(r2);
        
        	c.add(player1, BorderLayout.EAST);
	        c.add(player2, BorderLayout.WEST);
                
	        frame.setVisible(true);
	}
}
