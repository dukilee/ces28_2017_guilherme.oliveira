package date;

public class DateEnglish extends Date{
	public DateEnglish(int month, int day, int year){
		super(month, day, year);
	}
	
	public DateEnglish(Date other){
		super(other);
	}
	
	public String toPrint(){
		return month + "/" + day + "/" + year;
	}
	public Date clone(){
		return new DateEnglish(this);
	}
}
