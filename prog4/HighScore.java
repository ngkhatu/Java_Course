import java.io.*;
/**
 * The HighScore class handles input and output of score to a highscore.txt
 * @author Nikhil G. Khatu (ngkhatu.ncsu.edu)
 * Help from TAs: Matt Rakow & Shen Zhang
 *Lab Section- 231
 *@version 04/20/06
 */
public class HighScore{	


 /**
     * This method gets the highscore from the text file.
     * 
     * @return highscore returns the high score as an integer
     */
public int getHighScoreFromFile(){
	try{
	FileReader reader = new FileReader("highscore.txt");
	BufferedReader in = new BufferedReader(reader);
	String inputLine = in.readLine();
	reader.close();
	return Integer.parseInt(inputLine);
	}

	catch(IOException e){
		return 0;
	}
}




 /**
     * This method writes the new highscore to the defined test file.
     * @param score score to be written to text file
     */	
public void writeHighScoreToFile(int score){
	try{
	FileWriter writer = new FileWriter("highscore.txt");
	PrintWriter out = new PrintWriter(writer);
	out.println(score);
	writer.close();
	}
	
	catch(IOException e){
		System.out.println("Failed to write High Score!");
	}

}
}
