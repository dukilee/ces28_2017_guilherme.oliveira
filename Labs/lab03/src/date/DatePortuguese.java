package date;

public class DatePortuguese extends Date{
	public DatePortuguese(int month, int day, int year){
		super(month, day, year);
	}
	
	public DatePortuguese(Date other){
		super(other);
	}
	
	public String toPrint(){
		return day + "/" + month + "/" + year;	
	}
	public Date clone(){
		return new DatePortuguese(this);
	}
}
