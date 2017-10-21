package builders;

import person.Person;
import date.Date;
import letterElements.Address;
import letterElements.Languages;
import letterElements.Photo;
import letters.ComercialLetter;
import letters.Letter;

public class ComercialBuilder extends Builder{
	@Override
	public Letter constructLetter(Languages language, Person sender, Person destinatary,
			Address addressSender, Address addressDestiny, Date date,
			Photo photo, String message) {
		return new ComercialLetter(sender, destinatary, addressSender, addressDestiny, date);
		}
	
}
