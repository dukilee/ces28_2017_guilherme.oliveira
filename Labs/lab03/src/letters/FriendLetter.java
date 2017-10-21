package letters;

import person.Person;
import date.Date;
import letterElements.Address;

public class FriendLetter extends Letter{

	public FriendLetter(Person sender, Person destinatary,
			Address addressSender, Address addressDestiny, Date date) {
		super(sender, destinatary, addressSender, addressDestiny, date);
	}
	
	protected String header(){
		return sender.getNameFormal() + "\n" +
					addressSender.getValue() + "\n" + destinatary.getNameFormal() +
					"\n" + addressDestiny.getValue() + "\n";
	}
	
	protected String body(){
		return "\nHey, "+destinatary.getNameInformal()+"\n";
	}
	
	protected String signature(){
		return "\nSee ya\n"+date.toPrint()+"\n";
	}
}
