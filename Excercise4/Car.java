/**
*Class Car determines the fuel, miles, model and make of the car
*@author ngkhatu.ncsu.edu, (Nicole) nolyerly.ncsu.edu, (Bobby)ragambel.ncsu.edu, (Wilmer)wflores.ncsu.edu
*@version 1.0
*/

public class Car {
	/**
	* fuel in car
	*/
	private double fuel;
	/**
	* miles on car
	*/
	private double miles;
	/**
	* the maker name
	*/
	private String make;
	/**
	* the model name
	*/
	private String model;
	/**
	* Null constructor
	*/
	public Car(){
		fuel = 5;
		miles = 100;
		make = "Ford";
		model = "Mustang";
	}
	/**
	* Complete constructor
	* @param fu Fuel 
	* @param mi Miles
	* @param fd  Make
	* @param mg Model
	*/
	public Car(double fu, double mi, String fd, String mg){
		this();
		setFuel(fu);
		setMiles(mi);
		setMake(fd);
		setModel(mg);
	}
	/**
	* Method setFuel determines if fuel values are valid and sets fuel equal to a given value
	* @param fu fuel in car
	*/	
	public void setFuel(double fu){
	
		if(fu >= 0 && fu <= 35)
			fuel = fu;
	}
	/**
	* Method setMiles determines if miles values are valid sets miles equal to a given value
	* @param mi miles on car
	*/
	public void setMiles(double mi){
	
		if(mi >= 0 && mi <= 350)
			miles = mi;
	}
	/**
	* Method setMake determines if make values are valid sets make equal to a given value
	* @param fd  maker of car
	*/
	public void setMake(String fd){
	
		if(fd != ""  && fd != "Honda" )
			make = fd;
	}
	/**
	* Method setModel determines if model values are valid sets model equal to a given value
	* @param fd  model of car
	*/
	public void setModel(String mg){
	
		if(mg != "" && mg != "Civic" )
			model = mg;
	}
	/**
	* Method getFuel returns fuel in car
	* @return fuel 
	*/
	public double getFuel(){
		return fuel;
	}
	/**
	* Method getMiles returns miles on car
	* @return miles 
	*/
	public double getMiles(){
		return miles;
	}
	/**
	* Method getMake returns makers car
	* @return make 
	*/
	public String getMake(){
		return make;
	}
	/**
	* Method getModel returns model of car
	* @return model 
	*/
	public String getModel(){
		return model;
	}
	/**
	* Starts the program and provides test cases 
	* @param args command line arguments 
	*/
	public static void main(String args []){
	
	Car cc = new Car( 15, 258, "Chevy", "Cobalt");
		
	System.out.println("Fuel:" + cc.getFuel());
	System.out.println("Miles:" +  cc.getMiles());
	System.out.println("Make:" +  cc.getMake());
	System.out.println("Model:" +  cc.getModel());
	
	
	Car dd = new Car( -1, 351, "Honda", "Civic");
		
	System.out.println("Fuel:" + dd.getFuel());
	System.out.println("Miles:" +  dd.getMiles());
	System.out.println("Make:" +  dd.getMake());
	System.out.println("Model:" +  dd.getModel());
	
	Car ee = new Car( 49, -28, "", "");
		
	System.out.println("Fuel:" + ee.getFuel());
	System.out.println("Miles:" +  ee.getMiles());
	System.out.println("Make:" +  ee.getMake());
	System.out.println("Model:" +  ee.getModel());
	}
	
}
