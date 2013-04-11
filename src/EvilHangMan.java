import java.util.*;
import java.io.*;

public class EvilHangman extends HangmanGame {
	
	private HashSet<String> legalWords = new HashSet<String>(235000);
	
	public EvilHangman(int StringLength, int numGuesses) {
		super(numGuesses);
		setLettersRemaining(26);
		Scanner Scanner = null;
		try {
			Scanner = new Scanner(new File("dictionary.txt"));// read the dictionary
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		while (Scanner.hasNext()) {
			String temp = Scanner.nextLine().toUpperCase();
			if (temp.length() == StringLength) {
				legalWords.add(temp);
			}
		}
		Scanner.close();
		//at this point, legalWords should only contain upper-case
		//strings of the appropriate length
		
		String state = "";
		for (int i = 0; i < StringLength; i++) {
			state = state + "_ ";
		}
		setGameState(state);	
	}

	@Override
	public boolean isWin() {
		return false;
	}

	@Override
	public boolean gameOver() {
		if (numGuessesRemaining() == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean makeGuess(char ch) {
		char letterGuess = ch;
		if (!Character.isLetter(ch) || repeatInput(letterGuess)) return false;
		
		boolean guessResult = false;
		String charString = Character.toString(ch);
		String next = null;
		boolean legalWordAvailable = false;
		//if there is a legal word available in the list after iterating through it
		//and ignoring words containing the guessed letter, this variable will be true
		//we can proceed to delete words that contain the guessed letter
		// adjust the Wordlist in order to avoid the word with the letter
		// user guessed
		Iterator<String> iter = legalWords.iterator();
		while(iter.hasNext()){
			next = iter.next(); 
			if(!next.contains(charString)){
				legalWordAvailable = true;
			}
		}
		if(!legalWordAvailable){
			//if legalWordAvailable is false, there would be no words left if we 
			//deleted the words containing the guessed letter
			setSecretWord(next);
			guessResult = true;
		}
		else{
			//if legalWordAvailable is true, then we can proceed to modify the wordlist
			Iterator<String> modifyIter = legalWords.iterator();
			while(modifyIter.hasNext()){
				next = modifyIter.next();
				if(next.contains(charString)){
					modifyIter.remove();
				}
			}
			setSecretWord(next);
			decGuessesRemaining();
			guessResult = false;
		}
		if (!guessResult) {//if the guess was incorrect,
			addGuessedLetter(letterGuess);
		}
		return guessResult;
	}


}