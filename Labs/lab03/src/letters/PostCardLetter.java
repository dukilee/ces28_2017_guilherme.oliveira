package letters;

import person.Person;
import date.Date;
import letterElements.Address;
import letterElements.Photo;

public class PostCardLetter extends Letter{

	public PostCardLetter(Person sender, Person destinatary,
			Address addressSender, Address addressDestiny, Date date, Photo photo, String message) {
		super(sender, destinatary, addressSender, addressDestiny, date);
		// TODO Auto-generated constructor stub
		this.photo = photo;
		this.message = message;
	}
	
	protected String header(){
		return sender.getNameFormal() + "\n" +
					addressSender.getValue() + "\n" + destinatary.getNameFormal() +
					"\n" + addressDestiny.getValue() + "\n";
	}
	
	protected String body(){
		return photo.toPrint() + message + "\n";
	}
	
	protected String signature(){
		return "\n\n"+date.toPrint()+"\n";
	}

	
	private Photo photo;
	private String message;

}
