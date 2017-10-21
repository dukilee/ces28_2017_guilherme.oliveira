package person;

public class PersonEnglish extends Person{
	public PersonEnglish(Person other){
		super(other);
	}
	
	public PersonEnglish(String firstName, String lastName) {
		super(firstName, lastName);
	}
	

	public String getNameFormal(){
		return "Mr. "+lastName + ", " + firstName;
	}
	
	public String getNameInformal(){
		return firstName;
	}

	public Person clone(){
		return new PersonEnglish(firstName, lastName);
	}
}
