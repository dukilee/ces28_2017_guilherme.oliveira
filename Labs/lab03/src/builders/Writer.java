package builders;

import person.Person;
import date.Date;
import letterElements.Address;
import letterElements.Languages;
import letterElements.Photo;
import letters.Letter;

public class Writer {
	public Writer(Builder builder){
		this.builder = builder;
	}

	public Letter writeLetter(Languages language, Person sender, Person destinatary,
			Address addressSender, Address addressDestiny, Date date, Photo photo,
			String message){
		return builder.constructLetter(language, sender, destinatary, addressSender,
				addressDestiny, date, photo, message);
	}
	public Letter writeLetter(Languages language, Person sender, Person destinatary,
			Address addressSender, Address addressDestiny, Date date){
		return builder.constructLetter(language, sender, destinatary, addressSender,
				addressDestiny, date, null, null);
	}
	
	private Builder builder;
}
