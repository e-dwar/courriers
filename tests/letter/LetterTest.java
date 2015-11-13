package letter;

import static org.junit.Assert.*;
import letter.Letter;

import org.junit.*;

import testdouble.InhabitantDouble;

public abstract class LetterTest {

	protected Letter<?> letter;
	protected InhabitantDouble receiver;
	protected LetterFactory letterFactory = new LetterFactory();
	protected final double COST_OF_SIMPLE_LETTER = 1;
	public abstract Letter<?> createLetter();

	@Before
	public void init() {
		letter = createLetter();
		receiver = (InhabitantDouble) letter.getReceiver();
	}

	@Test
	public void positiveCostTest() {
		assertTrue(letter.getCost() > 0);
	}

	public void doActionTest() {
		assertFalse(letter.getOpened());
		letter.doAction();
		assertTrue(letter.getOpened());

	}

}