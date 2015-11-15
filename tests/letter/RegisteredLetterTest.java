package letter;

import static org.junit.Assert.*;
import letter.Letter;

import org.junit.*;

import city.City;

public class RegisteredLetterTest extends LetterTest {

	@Test
	public void doActionTest() {
		City city = letter.getSender().getCity();
		assertEquals(0, city.getPostBox().size());
		super.doActionTest();
		assertEquals(1, city.getPostBox().size());
	}

	@Test
	public void getCostTest() {
		Double expectedCost = COST_OF_SIMPLE_LETTER + 0.15;
		assertEquals(expectedCost, letter.getCost(), 0.01);
	}

	@Test
	public void receiverSendsAcknowledgment() {
		assertEquals(0, receiver.numberOfLetterSent);
		createLetter().doAction();
		assertEquals(1, receiver.numberOfLetterSent);
	}

	public Letter<?> createLetter() {
		return letterFactory.createRLwithSL();
	}

}
