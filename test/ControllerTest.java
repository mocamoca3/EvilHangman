import static org.junit.Assert.*;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;


public class ControllerTest {
	
	private EvilHangMan evilhm;
	private NormalHangMan normalhm;
	private HangmanGame evilWin;
	private ArrayList<Character> history;
	private JLabel label2;
	private JLabel label3;
	private JFrame frame;

	@Before
	public void setUp() throws Exception {
		evilhm = new EvilHangMan(6, 8);
		evilWin = new EvilHangMan(4, 16);
		history = new ArrayList<Character>();
		normalhm = new NormalHangMan("ABHORS", 8, history);
		
		label2 = new JLabel("Secret Word: "+ normalhm.displayGameState());
		label2.setFont(new Font("Default",Font.PLAIN,23));
        label3 = new JLabel(String.valueOf("Guesses Remaining: "+ normalhm.numGuessesRemaining() +"\n"));
        frame = new JFrame("MY GAME");
	}
	
	@Test
	public void testEvilTrue(){
		boolean isEvil = true;
        evilhm.controller('A', isEvil, label2, label3, frame);
        assertEquals("Secret Word: _ _ _ _ _ _ ", label2.getText());
        assertEquals("Guesses Remaining: 7", label3.getText());
        assertEquals("Nope!", evilhm.getResultText());
        assertTrue(evilhm.getEvil());
		isEvil = evilhm.getEvil();
        assertFalse(evilhm.gameOver());
        
        evilhm.controller('B', isEvil, label2, label3, frame);
        assertEquals("Secret Word: _ _ _ _ _ _ ", label2.getText());
        assertEquals("Guesses Remaining: 6", label3.getText());
        assertEquals("Nope!", evilhm.getResultText());
        assertTrue(evilhm.getEvil());
		isEvil = evilhm.getEvil();
        assertFalse(evilhm.gameOver());
        
        evilhm.controller('C', isEvil, label2, label3, frame);
        assertEquals("Secret Word: _ _ _ _ _ _ ", label2.getText());
        assertEquals("Guesses Remaining: 5", label3.getText());
        assertEquals("Nope!", evilhm.getResultText());
        assertTrue(evilhm.getEvil());
		isEvil = evilhm.getEvil();
        assertFalse(evilhm.gameOver());
        
        evilhm.controller('D', isEvil, label2, label3, frame);
        assertEquals("Secret Word: _ _ _ _ _ _ ", label2.getText());
        assertEquals("Guesses Remaining: 4", label3.getText());
        assertEquals("Nope!", evilhm.getResultText());
        assertTrue(evilhm.getEvil());
		isEvil = evilhm.getEvil();
        assertFalse(evilhm.gameOver());
        
        evilhm.controller('E', isEvil, label2, label3, frame);
        assertEquals("Secret Word: _ _ _ _ _ _ ", label2.getText());
        assertEquals("Guesses Remaining: 3", label3.getText());
        assertEquals("Nope!", evilhm.getResultText());
        assertTrue(evilhm.getEvil());
		isEvil = evilhm.getEvil();
        assertFalse(evilhm.gameOver());
        
        evilhm.controller('F', isEvil, label2, label3, frame);
        assertEquals("Secret Word: _ _ _ _ _ _ ", label2.getText());
        assertEquals("Guesses Remaining: 2", label3.getText());
        assertEquals("Nope!", evilhm.getResultText());
        assertTrue(evilhm.getEvil());
		isEvil = evilhm.getEvil();
        assertFalse(evilhm.gameOver());
        
        evilhm.controller('G', isEvil, label2, label3, frame);
        assertEquals("Secret Word: _ _ _ _ _ _ ", label2.getText());
        assertEquals("Guesses Remaining: 1", label3.getText());
        assertEquals("Nope!", evilhm.getResultText());
        assertTrue(evilhm.getEvil());
		isEvil = evilhm.getEvil();
        assertFalse(evilhm.gameOver());
        
        evilhm.controller('H', isEvil, label2, label3, frame);
        assertEquals("Secret Word: _ _ _ _ _ _ ", label2.getText());
        assertEquals("Guesses Remaining: 0", label3.getText());
        assertEquals("Nope!", evilhm.getResultText());
        assertTrue(evilhm.getEvil());
		isEvil = evilhm.getEvil();
        //game.gameOver() == true && game.isWin() == false
        assertTrue(evilhm.gameOver());
        assertFalse(evilhm.isWin());     
        
	}
	
	@Test
	public void testEvilTrueWinnable(){
		boolean isEvil = true;
		//game.makeGuess(nextLetter) == true && IsEvil == true
		evilWin = (HangmanGame)evilWin.controller('A', isEvil, label2, label3, frame);
		assertEquals("Secret Word: _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 15", label3.getText());
		assertEquals("Nope!", evilWin.getResultText());
		assertTrue(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertFalse(evilWin.gameOver());
		
		evilWin = (HangmanGame)evilWin.controller('E', isEvil, label2, label3, frame);
		assertEquals("Secret Word: _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 14", label3.getText());
		assertEquals("Nope!", evilWin.getResultText());
		assertTrue(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertFalse(evilWin.gameOver());
		
		evilWin = (HangmanGame)evilWin.controller('I', isEvil, label2, label3, frame);
		assertEquals("Secret Word: _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 13", label3.getText());
		assertEquals("Nope!", evilWin.getResultText());
		assertTrue(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertFalse(evilWin.gameOver());
		
		evilWin = (HangmanGame)evilWin.controller('O', isEvil, label2, label3, frame);
		assertEquals("Secret Word: _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 12", label3.getText());
		assertEquals("Nope!", evilWin.getResultText());
		assertTrue(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertFalse(evilWin.gameOver());
		
		evilWin = (HangmanGame)evilWin.controller('U', isEvil, label2, label3, frame);
		assertEquals("Secret Word: _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 11", label3.getText());
		assertEquals("Nope!", evilWin.getResultText());
		assertTrue(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertFalse(evilWin.gameOver());
		
		evilWin = (HangmanGame)evilWin.controller('Y', isEvil, label2, label3, frame);
		assertEquals("Secret Word: _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 10", label3.getText());
		assertEquals("Nope!", evilWin.getResultText());
		assertTrue(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertFalse(evilWin.gameOver());
		
		evilWin = (HangmanGame)evilWin.controller('R', isEvil, label2, label3, frame);
		assertEquals("Secret Word: _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 9", label3.getText());
		assertEquals("Nope!", evilWin.getResultText());
		assertTrue(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertFalse(evilWin.gameOver());
		
		evilWin = (HangmanGame)evilWin.controller('S', isEvil, label2, label3, frame);
		assertEquals("Secret Word: _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Nope!", evilWin.getResultText());
		assertTrue(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertFalse(evilWin.gameOver());
		
		evilWin = (HangmanGame) evilWin.controller('T', isEvil, label2, label3, frame);
		assertEquals("Secret Word: _ _ _ T ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", evilWin.getResultText());
		assertFalse(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertFalse(evilWin.gameOver());
		
		evilWin = (HangmanGame)evilWin.controller('P', isEvil, label2, label3, frame);
		assertEquals("Secret Word: P _ _ T ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", evilWin.getResultText());
		assertFalse(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertFalse(evilWin.gameOver());
		
		evilWin = (HangmanGame)evilWin.controller('F', isEvil, label2, label3, frame);
		assertEquals("Secret Word: P F F T ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", evilWin.getResultText());
		assertFalse(evilWin.getEvil());
		isEvil = evilWin.getEvil();
		assertTrue(evilWin.gameOver());
		assertTrue(evilWin.isWin());
	}
	
	@Test
	public void testNotEvilFalse(){
		//game.makeGuess(nextLetter) == true && IsEvil == false
        boolean isEvil = false;
        //game.gameOver() == false
		normalhm.controller('A', isEvil, label2, label3, frame);
		assertEquals("Secret Word: A _ _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		isEvil = normalhm.getEvil();
		assertFalse(normalhm.gameOver());
		
		normalhm.controller('B', isEvil, label2, label3, frame);
		assertEquals("Secret Word: A B _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		isEvil = normalhm.getEvil();
		assertFalse(normalhm.gameOver());
		
		normalhm.controller('H', isEvil, label2, label3, frame);
		assertEquals("Secret Word: A B H _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		isEvil = normalhm.getEvil();
		assertFalse(normalhm.gameOver());

		normalhm.controller('O', isEvil, label2, label3, frame);
		assertEquals("Secret Word: A B H O _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		isEvil = normalhm.getEvil();
		assertFalse(normalhm.gameOver());

		//game.makeGuess(nextLetter) == false
		normalhm.controller('Q', isEvil, label2, label3, frame);
		assertEquals("Secret Word: A B H O _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 7", label3.getText());
		assertEquals("Nope!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		isEvil = normalhm.getEvil();
		assertFalse(normalhm.gameOver());

		normalhm.controller('R', isEvil, label2, label3, frame);
		assertEquals("Secret Word: A B H O R _ ", label2.getText());
		assertEquals("Guesses Remaining: 7", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		isEvil = normalhm.getEvil();
		assertFalse(normalhm.gameOver());

		normalhm.controller('S', isEvil, label2, label3, frame);
		assertEquals("Secret Word: A B H O R S ", label2.getText());
		assertEquals("Guesses Remaining: 7", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		isEvil = normalhm.getEvil();
		//game.gameOver() == true && game.isWin() == true
		assertTrue(normalhm.gameOver());
		assertTrue(normalhm.isWin());
	}
	
	
	
	
	
	
	
	
	
	
}