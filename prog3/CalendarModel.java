import java.io.*;
/** 
* The CalendarModel class calculates data for a calendar.
* @author Nikhil G. Khatu (ngkhatu.ncsu.edu)
*Lab Section- 231
*@version 04/02/06
*/

public class CalendarModel{

	private int year;
	private int month;

	public CalendarModel(){
	int year=0;
	int month=0;
	}
	
	/**
	*@param y year user inputs in GUI
	*/
	public void setYear(int y){
	year=y;
	}
	/**
	*@param m month user inputs in GUI
	*/
	public void setMonth(int m){
	month=m;
	}	
	
	public void generateCalendar(){
	try{
	
	FileWriter writer = new FileWriter(monthNumberToName() + year +".html");
  	PrintWriter out = new PrintWriter(writer);
  	out.println("<HTML>");
	out.println("<BODY>");
	out.println("<CENTER>");
	out.println("<TABLE BORDER=1>");
	out.println("<CAPTION><B>"+monthNumberToName() + " "+ year +"</B></CAPTION>");
	out.println("<TR>");
	out.println("<TH>Sunday</TH>");
	out.println("<TH>Monday</TH>");
	out.println("<TH>Tuesday</TH>");
	out.println("<TH>Wednesday</TH>");
	out.println("<TH>Thursday</TH>");
	out.println("<TH>Friday</TH>");
	out.println("<TH>Saturday</TH>");
	out.println("</TR>");
	
	
	for(int i=0; i<getFirstDay(); i++){
		out.println("<TD ALIGN=center>&nbsp;</TD>");
	}
	int day= 1;
	for(int x= getFirstDay();x< daysInMonth()+ getFirstDay(); x++){
		if(x%7 ==0)
		out.println("</TR><TR>");
		out.println("<TD ALIGN=\"CENTER\">" + day + "</TD>");
		day++;
		
	}
	
	out.println("</TR>");
	out.println("</TABLE>");
	out.println("</CENTER>");
	out.println("</BODY>");
	out.println("</HTML>");
	
	writer.close();
		
	}
	
	catch(IOException e){
	System.out.println("An exceptional condition has occurred while processing file :"+monthNumberToName() + year +".html" + "The program is terminated.");
	System.exit(0);
	}
	}	
	
	/**
	*@return Smonth converted month from int to string
	*/
	
	public String monthNumberToName(){
	String Smonth="";
	if(month==1) Smonth= "January";
	if(month==2) Smonth= "February";
	if(month==3) Smonth= "March";
	if(month==4) Smonth= "April";
	if(month==5) Smonth= "May";
	if(month==6) Smonth= "June";
	if(month==7) Smonth= "July";
	if(month==8) Smonth= "August";
	if(month==9) Smonth= "September";
	if(month==10) Smonth= "October";
	if(month==11) Smonth= "November";
	if(month==12) Smonth= "December";
	return Smonth;
	}
	
	public boolean isLeapYear(){
	
	if ( ( (year%4 == 0) && (year%100 != 0) ) || ( (year%4 == 0) && (year%400 == 0) ) ) return true;
	else return false;
	}
	
	
	public int daysInMonth(){
	int days=0;
	if (month==1) days= 31;
	if (month==2 && this.isLeapYear()==false) return 28;
	if (month==2 && this.isLeapYear()==true) return 29;
	if (month==3) days= 31;
	if (month==4) days= 30;
	if (month==5) days= 31;
	if (month==6) days= 30;
	if (month==7) days= 31;
	if (month==8) days= 31;
	if (month==9) days= 30;
	if (month==10) days= 31;
	if (month==11) days= 30;
	if (month==12) days= 31;
	return days;
	}
	
	public int getFirstDay(){
	int day= 1;
	if (month==1 || month==2) year= year - 1;
	if (month==2) day= day + 3;
	if (month==3) day= day + 2;
	if (month==4) day= day + 5;
	if (month==5) day= day + 0;
	if (month==6) day= day + 3;
	if (month==7) day= day + 5;
	if (month==8) day= day + 1;
	if (month==9) day= day + 4;
	if (month==10) day= day + 6;
	if (month==11) day= day + 2;
	if (month==12) day= day + 4;
	return ((year + year/4 - year/100 + year/400 + day)%7);
	}
	
	
	public static void main(String args[])
	{
	CalendarModel j= new CalendarModel();
	j.setYear(2006);
	j.setMonth(4);
	System.out.println(j.daysInMonth());
	System.out.println(j.getFirstDay());
	System.out.println(j.monthNumberToName());
	}
	}
