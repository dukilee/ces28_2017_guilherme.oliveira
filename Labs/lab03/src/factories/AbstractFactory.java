package factories;

import letterElements.Address;
import letterElements.Languages;
import person.Person;
import date.Date;

public abstract class AbstractFactory {
	
	public static final AbstractFactory getFactory(Languages language){
		if(language == Languages.PORTUGUESE)
			return new PortugueseFactory();
		if(language == Languages.JAPONESE)
			return new JaponeseFactory();
		
		//returns english by default
		return new EnglishFactory();
	}

	public abstract Person createPerson(String firstName, String lastName);
	public abstract Person createPerson(Person person);
	public abstract Address createAddress(String address);
	public abstract Address createAddress(Address address);
	public abstract Date createDate(int month, int day, int year);
	public abstract Date createDate(Date date);
}