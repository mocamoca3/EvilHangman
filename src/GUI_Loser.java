import javax.swing.*;

public class GUI_Loser extends GUI_Outcome{

    public GUI_Loser(String secretWord, JFrame inputFrame){
        super(secretWord, inputFrame, "You are the loser!", "loser.gif");
    }
}