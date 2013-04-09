import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;


public class ControllerTest {
	
	private EvilHangMan evilhm;
	private NormalHangMan normalhm;
	private final String WORD = "SPONGEBOB";
	private ArrayList<Character> history;
	private JLabel label2;
	private JLabel label3;
	private JFrame frame;

	@Before
	public void setUp() throws Exception {
		evilhm = new EvilHangMan(6, 8);
		history = new ArrayList<Character>();
		normalhm = new NormalHangMan("ABHORS", 8, history);
	}
	
	@Test
	public void testEvilTrue(){
		//game.makeGuess(nextLetter) == true && IsEvil == true
	}
	
	@Test
	public void testNotEvilFalse(){
		//game.makeGuess(nextLetter) == true && IsEvil == false
		label2 = new JLabel("Secret Word: "+ normalhm.displayGameState());
		label2.setFont(new Font("Default",Font.PLAIN,23));
	       
        label3 = new JLabel(String.valueOf("Guesses Remaining: "+ normalhm.numGuessesRemaining() +"\n"));
        frame = new JFrame("Normal Hangman");
        
		normalhm.controller('A', false, label2, label3, frame);
		assertEquals("Secret Word: A _ _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		
		normalhm.controller('B', false, label2, label3, frame);
		assertEquals("Secret Word: A B _ _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		
		normalhm.controller('H', false, label2, label3, frame);
		assertEquals("Secret Word: A B H _ _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		
		normalhm.controller('O', false, label2, label3, frame);
		assertEquals("Secret Word: A B H O _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 8", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		
		//game.makeGuess(nextLetter) == false
		normalhm.controller('Q', false, label2, label3, frame);
		assertEquals("Secret Word: A B H O _ _ ", label2.getText());
		assertEquals("Guesses Remaining: 7", label3.getText());
		assertEquals("Nope!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		
		normalhm.controller('R', false, label2, label3, frame);
		assertEquals("Secret Word: A B H O R _ ", label2.getText());
		assertEquals("Guesses Remaining: 7", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		
		normalhm.controller('S', false, label2, label3, frame);
		assertEquals("Secret Word: A B H O R S ", label2.getText());
		assertEquals("Guesses Remaining: 7", label3.getText());
		assertEquals("Yes!", normalhm.getResultText());
		assertFalse(normalhm.getEvil());
		//game.gameOver() == true && game.isWin() == true
		assertTrue(normalhm.gameOver());
		assertTrue(normalhm.isWin());
	}
	
	
	/* 
	 * 
	 * 
	 * 
	 * game.gameOver() == true && game.isWin() == false
	 * game.gameOver() == false
	 * */
	
	
	
	
	
	
	
	
	
}