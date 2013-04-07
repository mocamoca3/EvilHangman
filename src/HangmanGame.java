import java.util.ArrayList;

public class HangmanGame{
	
	private String secretWord = "";//To store the secret word
    private int remainingGuesses;//to store the number of guesses for the user
    private String state = "";//store the current guessing situation
   // private String letterGuessHistory = "";//store the letters that the user has tried
    private int letterLeftNum;
    //to store the number of the letters in the secret word has not been guessed correctly

    private ArrayList<Character> letterGuessHistory;
    
    protected HangmanGame(int numGuesses){
    	remainingGuesses = numGuesses;
    	letterGuessHistory = new ArrayList<Character>();
    }
    
    /**
     * @return the original secret word.
     */
    protected String getSecretWord(){
    	return secretWord;
    }
    
    protected void setSecretWord(String word){
    	secretWord = word;
    }

    /**
     * @return the number of guesses the player has left
     */
    protected int numGuessesRemaining(){
    	return remainingGuesses;
    }
    
    protected void decGuessesRemaining(){
    	remainingGuesses--;
    }
    
    /**
     * The number of letters remaining to be guessed in the secret word - i.e.
     * the number of blank spaces the player sees, which may be different from
     * the actually number of letters it will take to fill those blanks.
     * @return the number of letters in the secret word that still have to be guessed
     */
    protected int numLettersRemaining(){
    	return letterLeftNum;
    }
    
    protected void decLettersRemaining(){
    	letterLeftNum--;
    }
    
    protected void setLettersRemaining(int num){
    	letterLeftNum = num;
    }
    
    /**
     * Gives a display-ready String-ified version of the current state of the secret word, showing letters
     * that have been guessed and blank spaces for letters that still need to be guessed.
     * For example if the secrect word is "LABORATORY" and the player has guessed L, A, B, R, and Y
     * the method might return something like "L A B _ R A _ _ R Y"
     * @return a String of the current state of the secret word.
     */
    protected String displayGameState(){
    	return state;
    }
    
    protected void setGameState(String state){
    	this.state = state;
    }
    
    /**
     * An ArrayList representing the letters guessed so far in the order they were guessed.
     * Duplicates should not be added.
     * @return a String showing which letters have already been guessed.
     */
    protected ArrayList<Character> lettersGuessed(){
    	return letterGuessHistory;
    }
    
    //setter method for letterGuessHistory
    protected void addGuessedLetter(char c){
    	letterGuessHistory.add(c);
    }
    
    //setter method for letterGuessHistory
    //will only be used by NormalHangMan
    protected void setLetterHistory(ArrayList<Character> history){
    	letterGuessHistory = history;
    }
  
    
    
    
    //method that checks whether a character already exists in the LetterGuessHistory
    protected boolean RepeatInput(char c)
    {
    	return letterGuessHistory.contains(c);
    }
    
    /************METHODS THAT ARE OVERRIDDEN************/
    
    //needs to be overrode by subclasses
    protected boolean makeGuess(char c){
    	return false;
    }
    
    //needs to be overrode by subclasses
    protected boolean isWin(){
    	return false;
    }
    
    //needs to be overrode by subclasses
    protected boolean gameOver(){
    	return false;
    }
    
}
