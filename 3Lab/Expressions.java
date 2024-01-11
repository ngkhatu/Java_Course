public class Expressions {
	public static void main(String args[]) {
		int ex1= 1/5+3*22;
		System.out.println("ex1=" + ex1);
	
		double ex2= 10/4*2.0;
		System.out.println("ex2=" + ex2);
		
		int ex3= 25%9/2;
		System.out.println("ex3=" + ex3);
		
		int ex4= 13/3;
		System.out.println("ex4=" + ex4);
		
		int ex5= 13/3;
		System.out.println("ex5=" + ex5);
		
		int ex6= 1;
		ex6= ex6+ex6;
		System.out.println("ex6=" + ex6); //Output 6
		
		//Convert Fahrenheit to Celsius
		
		double fDegrees=212.;
		double cDegrees= (fDegrees-32.) *5/9;
		System.out.println("c Degrees= " + cDegrees) ; //Output 7
		
		//Calculate test average for 3 test
		double test1= 90;
		double test2= 80;
		double test3= 100;
		double average= (test1 + test2 + test3)/3. ;
		System.out.println("average = " + average); //Output 8
		
	
	
	
	
	
	}
}
