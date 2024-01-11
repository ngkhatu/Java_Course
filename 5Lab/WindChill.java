/**
 * The Windchill class provides the functionality to find the wind chill given
 * the widspeed and the temperature.
 * 
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
class WindChill {

	/**
	 * Answers the wind chill for a given wind speed and temperature
	 *
	 * @param w  windspeed in miles per hour
	 * @param t  temperature in degrees fahrenheit
	 * @return the temperature for wind chill
	 */
	public double calculateWC(int w, int t) {
		double windChill = 0;
		if (w < 4 )  {
		
		windChill=t;
		
		} 
		
		else {
			windChill=0.0817 * ((3.71 * Math.sqrt(w)) + 5.81 -
			(0.25 * w))*(t - 91.4)+91.4;
		}
	
		return windChill;
	}
}

	
