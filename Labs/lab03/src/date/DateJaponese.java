package date;

public class DateJaponese extends Date{
	public DateJaponese(int month, int day, int year){
		super(month, day, year);
	}
	
	public DateJaponese(Date other){
		super(other);
	}
	
	public String toPrint(){
		return year + "/" + month + "/" + day;
	}
	public Date clone(){
		return new DateJaponese(this);
	}
	
}
