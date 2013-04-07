import java.util.*;
import java.io.*;

public class EvilHangMan extends HangmanGame {
	private String[] Wordlist = new String[235000];// to store the dictionary
	private int numWords = 0;// count the number of possible secret words.
	private int secretStringLength;// the length of the secret string

	public EvilHangMan(int StringLength, int numGuesses) {
		super(numGuesses);
		secretStringLength = StringLength;
		setLettersRemaining(26);
		Scanner Scanner = null;
		try {
			Scanner = new Scanner(new File("dictionary.txt"));// read the dictionary
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int i = 0;
		while (Scanner.hasNext()) {
			String temp = Scanner.nextLine().toUpperCase();
			if (temp.length() == StringLength) {
				Wordlist[i] = temp;
				i++;
				numWords++;
			}
		}

		for (i = 0; i < StringLength; i++) {
			setGameState(displayGameState() + "_ ");
		}
		Scanner.close();
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
		boolean guessResult = false;
		char letterGuess = ch;
		if (Character.isLetter(letterGuess) && !RepeatInput(letterGuess)) {
			// adjust the Wordlist in order to avoid the word with the letter
			// user guessed
			int tempWordNum = 0;
			for (int i = 0; i < numWords; i++) {
				for (int j = 0; j < secretStringLength; j++) {
					if (Wordlist[i].charAt(j) == letterGuess) {
						break;
					} else {
						if (j == secretStringLength - 1) {
							if (Wordlist[i].charAt(j) != letterGuess) {
								tempWordNum++;
							}
						}
					}
				}
			}
			// we choose the words that don't contain the letter the user
			// guessed, and they will be the new possible secret words.
			String[] temp = new String[tempWordNum];
			int tempIndex = 0;
			for (int i = 0; i < numWords; i++) {
				for (int j = 0; j < secretStringLength; j++) {
					if (Wordlist[i].charAt(j) == letterGuess) {
						break;
					} else {
						if (j == secretStringLength - 1) {
							if (Wordlist[i].charAt(j) != letterGuess) {
								temp[tempIndex] = Wordlist[i];
								tempIndex++;
							}
						}
					}
				}
			}
			if (tempWordNum == 0) {
				setSecretWord(Wordlist[0]);
				guessResult = true;
			} 
			else {
				setSecretWord(temp[0]);
				numWords = tempWordNum;
				Wordlist = temp;
				decGuessesRemaining();
				guessResult = false;
			}
			if (!guessResult) {
				addGuessedLetter(letterGuess);
			}

		} else return false;
		
		return guessResult;
	}


}