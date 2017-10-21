package letters;

import person.Person;
import date.Date;
import letterElements.Address;

public class ComercialLetter extends Letter{
	public ComercialLetter(Person sender, Person destinatary, Address addressSender,
			Address addressDestiny, Date date) {
		super(sender, destinatary, addressSender, addressDestiny, date);
	}
	
	protected String header(){
		return date.toPrint() + "\n\n" + sender.getNameFormal() + "\n" +
					addressSender.getValue() + "\n" + destinatary.getNameFormal() +
					"\n" + addressDestiny.getValue() + "\n";
	}
	
	protected String body(){
		return "\nDear "+destinatary.getNameInformal()+"\n";
	}
	
	protected String conclusion(){
		return "\nSincerely\n";
	}
	
	protected String signature(){
		return "\n                     _________________\n" +
				"                     "+sender.getNameFormal()+"\n";
	}

}
