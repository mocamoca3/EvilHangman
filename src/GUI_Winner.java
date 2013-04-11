import javax.swing.*;

public class GUI_Winner extends GUI_Outcome{
    
    public GUI_Winner(String secretWord,JFrame inputFrame){
    	super(secretWord, inputFrame, "You are the winner!", "Congrats.gif");
    }
    
}