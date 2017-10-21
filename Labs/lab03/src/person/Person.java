package person;

public abstract class Person {
	public Person(Person other){
		firstName = other.getFirstName();
		lastName = other.getLastName();
	}
	
	public Person(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public abstract String getNameFormal();
	
	public abstract String getNameInformal();
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public abstract Person clone();
	
	protected String firstName;
	protected String lastName;
}
