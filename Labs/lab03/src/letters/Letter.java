package letters;

import person.Person;
import date.Date;
import factories.AbstractFactory;
import letterElements.Address;
import letterElements.Languages;

public abstract class Letter {
	public Letter(Person sender, Person destinatary, Address addressSender,
			Address addressDestiny, Date date){
		//using english as default language
		this.sender = sender.clone();
		this.destinatary = destinatary.clone();
		this.addressSender = addressSender.clone();
		this.addressDestiny = addressDestiny.clone();
		this.date = date.clone();
	}
	
	public void changeLanguage(Languages language){
		AbstractFactory factory = AbstractFactory.getFactory(language);
		sender = factory.createPerson(sender);
		destinatary = factory.createPerson(destinatary);
		addressSender = factory.createAddress(addressSender.getValue());
		addressDestiny = factory.createAddress(addressDestiny.getValue());
		date = factory.createDate(date);
		this.language = language;
	}

	public String model(){
		return header() + body() + conclusion() + signature();
	}
	
	protected String header(){
		return "";
	}
	
	protected String body(){
		return "";
	}
	
	protected String signature(){
		return "";
	}

	protected String conclusion(){
		return "";
	}
	
	
	
	protected Person sender;
	protected Person destinatary;
	protected Address addressSender;
	protected Address addressDestiny;
	protected Date date;
	protected Languages language;
}
