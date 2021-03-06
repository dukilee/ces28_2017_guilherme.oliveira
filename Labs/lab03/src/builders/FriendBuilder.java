package builders;

import person.Person;
import date.Date;
import letterElements.Address;
import letterElements.Languages;
import letterElements.Photo;
import letters.FriendLetter;
import letters.Letter;

public class FriendBuilder extends Builder{

	@Override
	public Letter constructLetter(Languages language, Person sender, Person destinatary,
			Address addressSender, Address addressDestiny, Date date,
			Photo photo, String message) {
		return new FriendLetter(sender, destinatary, addressSender, addressDestiny, date);
	}

}
