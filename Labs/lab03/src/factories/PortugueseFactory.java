package factories;

import letterElements.Address;
import person.Person;
import person.PersonPortuguese;
import date.Date;
import date.DatePortuguese;

public class PortugueseFactory extends AbstractFactory{
	public Person createPerson(String firstName, String lastName){
		return new PersonPortuguese(firstName, lastName);
	}
	public Person createPerson(Person person){
		return new PersonPortuguese(person);
	}
	public Address createAddress(String address){
		return new Address(address);
	}
	public Address createAddress(Address address){
		return new Address(address);
	}
	public Date createDate(int month, int day, int year){
		return new DatePortuguese(month, day, year);
	}
	public Date createDate(Date date){
		return new DatePortuguese(date);
	}
}
