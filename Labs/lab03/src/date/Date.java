package date;


public abstract class Date {
	public Date(Date d){
		month = d.getMonth();
		day = d.getDay();
		year = d.getYear();
	}
	
	public Date(int month, int day, int year){
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public abstract String toPrint();
	
	public int getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
	public int getYear(){
		return year;
	}
	
	public abstract Date clone();
	
	protected int month, day, year;
}
