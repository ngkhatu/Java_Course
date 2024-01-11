public class Zeller {
public static void main(String args[]) {
	int month= 2;
	int day= 14;
	int year= 2006;
	int dayOfWeek= -1 ; //will be updated by your code
	
	
	//insert your code here....
	
	
	if (month==1 || month==2){
		year= year - 1;
		}
		
	if (month==2){
		day= day + 3;
		}
	
	if (month==3){
		day= day + 2;
		}
	
	if (month==4){
		day= day + 5;
		}
	
	if (month==5){
		day= day + 0;
		}
	
	if (month==6){
		day= day + 3;
		}
	
	if (month==7){
		day= day + 5;
		}
	
	if (month==8){
		day= day + 1;
		}
	
	if (month==9){
		day= day + 4;
		}
	
	if (month==10){
		day= day + 6;
		}
	
	if (month==11){
		day= day + 2;
		}
	
	if (month==12){
		day= day + 4;
		}
	
dayOfWeek= (year + year/4 - year/100 + year/400 + day)%7;
	
	System.out.println("The day of the week is " + dayOfWeek);
	
	}
}
