package builders;

import person.Person;
import date.Date;
import letterElements.Address;
import letterElements.Languages;
import letterElements.Photo;
import letters.Letter;

public abstract class Builder {
	public abstract Letter constructLetter(Languages language, Person sender, Person destinatary,
			Address addressSender, Address addressDestiny, Date date,
			Photo photo, String message);
}
