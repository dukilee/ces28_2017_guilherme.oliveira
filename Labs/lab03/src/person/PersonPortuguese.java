package person;

public class PersonPortuguese extends Person{
	public PersonPortuguese(Person other){
		super(other);
	}
	public PersonPortuguese(String firstName, String lastName){
		super(firstName, lastName);
	}	

	public String getNameFormal(){
		return "Sr. "+firstName + " " + lastName;
	}
	
	public String getNameInformal(){
		return firstName;
	}
		
	public Person clone(){
		return new PersonPortuguese(firstName, lastName);
	}
}
