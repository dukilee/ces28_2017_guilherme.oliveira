package tests;
import static org.junit.Assert.*;
import letterElements.Address;
import letterElements.HeartPhoto;
import letterElements.Languages;
import letterElements.Photo;
import letters.Letter;

import org.junit.Before;
import org.junit.Test;

import person.Person;

import date.Date;
import factories.AbstractFactory;

import builders.FriendBuilder;
import builders.Writer;



public class TestEx2 {

	Address address1;
	Address address2;
	Date date;
	Person person1;
	Person person2;
	Photo photo;
	String message;
	
	@Before
	public void setUp(){
		AbstractFactory factory = AbstractFactory.getFactory(Languages.PORTUGUESE);
		address1 = factory.createAddress("Rua Astolfo Pinho, 422");
		address2 = factory.createAddress("Av. Rodrigo Sampaio, 21");
		date = factory.createDate(20,12,2012);
		person1 = factory.createPerson("Abelardo", "Barbosa");
		person2 = factory.createPerson("Silvio", "Santos");
		photo = new HeartPhoto();
		message = "Love you";
	}	
	@Test
	public void testFriendLetterInPortuguese() {
		Languages lan = Languages.PORTUGUESE;
		Writer w = new Writer(new FriendBuilder());
		Letter letter = w.writeLetter(lan, person1, person2, address1, address2, date);
		letter.changeLanguage(lan);
		System.out.print(letter.model());
		assertEquals(letter.model(), "Sr. Abelardo Barbosa\n"+
								"Rua Astolfo Pinho, 422\n"+
								"Sr. Silvio Santos\n"+
								"Av. Rodrigo Sampaio, 21\n"+
								"\n"+
								"Hey, Silvio\n"+
								"\n"+
								"See ya\n"+
								"20/12/2012\n");

	}


	@Test
	public void testFriendLetterInJaponsese() {
		Languages lan = Languages.JAPONESE;
		Writer w = new Writer(new FriendBuilder());
		Letter letter = w.writeLetter(lan, person1, person2, address1, address2, date);
		assertEquals(letter.model(), "Barbosa-san\n"+
								"Rua Astolfo Pinho, 422\n"+
								"Santos-san\n"+
								"Av. Rodrigo Sampaio, 21\n"+
								"\n"+
								"Hey, Santos\n"+
								"\n"+
								"See ya\n"+
								"2012/12/20\n");
		
	}
	@Test
	public void testFriendLetterInEnglish() {
		Languages lan = Languages.ENGLISH;
		Writer w = new Writer(new FriendBuilder());
		Letter letter = w.writeLetter(lan, person1, person2, address1, address2, date);
		assertEquals(letter.model(), "Mr. Barbosa, Abelardo\n"+
								"Rua Astolfo Pinho, 422\n"+
								"Mr. Santos, Silvio\n"+
								"Av. Rodrigo Sampaio, 21\n"+
								"\n"+
								"Hey, Silvio\n"+
								"\n"+
								"See ya\n"+
								"12/20/2012\n");

	}
	
}
