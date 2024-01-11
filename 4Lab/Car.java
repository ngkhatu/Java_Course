/**
 * The Car class describes some main attributes of a car.
 *
 * @author NCSU CSC116 Labs (csc116l-sup@wolfware.ncsu.edu)
 * @version 1.0
 */
public  class Car {
    
	/** the name of the car */
	private String name;
	
	/** the miles per gallon of the car */
	private int mpg;
	
	/** the maximum capacity of the car's gas tank */
	private int cap;
	
	/** the amount of remaining fuel in the gas tank */
	private double remainingFuelInTank;
    
    /**
     * Answers a new object of type Car
     * @param carName name of the newly created Car
     * @param milesPerGallon miles per gallon
     * @param maxTankCapacity fuel tank capacity
     */
    public Car(String carName, int milesPerGallon, int maxTankCapacity) {
        name = carName;
        mpg  = milesPerGallon;
        cap  = maxTankCapacity;
        remainingFuelInTank = maxTankCapacity;
	}
   
    /**
     * Answers a new object of type Car
     * @param carName the name of the new Car
     */
    public Car(String carName) {
        this.name = carName;
        this.mpg = 10;
        this.cap = 10;
        this.remainingFuelInTank = 10;
    }
    
    /**
     * Fills the gas tank.
     */
    public void fillTank() {
		
	remainingFuelInTank= cap;
    }
    
    /**
     * Drives the car the number of miles specified
     *  -- if the number of miles is more than can be driven
     * with remaining fuel, do not take any action
     * @param miles number of miles to drive the car
     */
    public void drive(double  miles) {
	if( (miles/mpg) <= remainingFuelInTank) {
		remainingFuelInTank = remainingFuelInTank - (miles/mpg);
	}		
    }
    
    /**
     * Answers the tank capacity
     * @return the tank capacity
     */
    public int getTankCapacity() {
		//add your code here
        return cap;

    }
  
    /**
     * Answers the remaining fuel in the tank
     * @return the amount of fuel in the tank
     */
    public double getFuelInTank() {
		//add your code here
        return remainingFuelInTank;
    }
    
    /**
     * Answers the name of the car
     * @return the name of the car
     */
    public String getCarName() {
		//add your code here
        return name;
    }
    
}
