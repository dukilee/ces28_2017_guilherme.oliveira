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

import builders.ComercialBuilder;
import builders.FriendBuilder;
import builders.PostCardBuilder;
import builders.Writer;


public class TestEx1 {
	Address address1;
	Address address2;
	Date date;
	Person person1;
	Person person2;
	Photo photo;
	String message;
	Languages language;
	
	@Before
	public void setUp(){
		language = Languages.PORTUGUESE;
		AbstractFactory factory = AbstractFactory.getFactory(language);
		address1 = factory.createAddress("Rua Astolfo Pinho, 422");
		address2 = factory.createAddress("Av. Rodrigo Sampaio, 21");
		date = factory.createDate(20,12,2012);
		person1 = factory.createPerson("Abelardo", "Barbosa");
		person2 = factory.createPerson("Silvio", "Santos");
		photo = new HeartPhoto();
		message = "Love you";
	}
	
	@Test
	public void testForCommercial() {
		Writer w = new Writer(new ComercialBuilder());
		Letter letter = w.writeLetter(language, person1, person2, address1, address2, date);
		assertEquals(letter.model(), "12/20/2012\n"+
								"\n"+
								"Sr. Abelardo Barbosa\n"+
								"Rua Astolfo Pinho, 422\n"+
								"Sr. Silvio Santos\n"+
								"Av. Rodrigo Sampaio, 21\n"+
								"\n"+
								"Dear Silvio\n"+
								"\n"+
								"Sincerely\n"+
								"\n"+
								"                     _________________\n"+
								"                     Sr. Abelardo Barbosa\n");
	}
	

	@Test
	public void testForFriend() {
		Writer w = new Writer(new FriendBuilder());
		Letter letter = w.writeLetter(language, person1, person2, address1, address2, date);
		assertEquals(letter.model(), "Sr. Abelardo Barbosa\n"+
								"Rua Astolfo Pinho, 422\n"+
								"Sr. Silvio Santos\n"+
								"Av. Rodrigo Sampaio, 21\n"+
								"\n"+
								"Hey, Silvio\n"+
								"\n"+
								"See ya\n"+
								"12/20/2012\n");
	}
	

	@Test
	public void testForPostCard() {
		Writer w = new Writer(new PostCardBuilder());
		Letter letter = w.writeLetter(language, person1, person2, address1, address2, date, photo, message);
		assertEquals(letter.model(),"Sr. Abelardo Barbosa\n"+
								"Rua Astolfo Pinho, 422\n"+
								"Sr. Silvio Santos\n"+
								"Av. Rodrigo Sampaio, 21\n"+
								"     __        __                 \n"+
								"    /  \\      /  \\                \n"+
								"   /    \\    /    \\               \n"+
								"  /      \\  /      \\              \n"+
								" /        \\/        \\             \n"+
								" \\                  /             \n"+
								"  \\                /              \n"+
								"   \\              /               \n"+
								"    \\            /                \n"+
								"     \\          /                 \n"+
								"      \\        /                  \n"+
								"       \\      /                   \n"+
								"        \\    /                    \n"+
								"         \\  /                     \n"+
								"          \\/                      \n"+
								"                                  \n"+
								"Love you\n"+
								"\n"+
								"\n"+
								"12/20/2012\n");

}

}
