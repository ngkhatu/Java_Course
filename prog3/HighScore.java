public class HighScore{
public int getHighScoreFromFile(){
	try{
	FileReader reader = new FileReader("highscore.txt");
	BufferedReader in = new BufferedReader(reader);
	String inputLine = in.readLine();
	reader.close();
	return Integer.parseInt(inputline);
	}

	catch(IOException e){
		return 0;
	}
	return 0;
}




	
public void writeHighScoreToFile(int score){
	FileWriter writer = new FileWriter("highscore.txt");
	PrintWriter out = new PrintWriter(writer);
	out.println(score);
	writer.close();
}
}
