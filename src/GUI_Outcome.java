import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUI_Outcome implements ActionListener{
	private JFrame parentFrame;
    private JFrame frame;
    private JLabel secretWordLabel;
    private JLabel gameResultLabel;
    private JButton returnBtn;
    private ImageIcon icon;
    private JLabel gif;
    private JLabel answerIs;
    private boolean won;
    
    public GUI_Outcome(String secretWord, JFrame inputFrame, String frameLabel, String gifName){
    	//filling variables
    	parentFrame = inputFrame;
        frame = new JFrame(frameLabel);
        icon = new ImageIcon(gifName); 
        gif = new JLabel(icon);
        if(frameLabel.equals("You are the winner!")){
        	won = true;
        }
        else{
        	won = false;
        }
        
        //deciding the background
        if(won){
        	background(frame);
        }
        else{
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setSize(new Dimension(300,470));
        	frame.setLayout(new FlowLayout());
        }
        
        //deciding the labeling
        if(won){
        	answerIs = new JLabel("The answer is ");
            
            secretWordLabel = new JLabel(secretWord);
            secretWordLabel.setFont(new Font("Default",Font.PLAIN,23));
            secretWordLabel.setForeground(Color.red);
        }
        else{
        	secretWordLabel = new JLabel("The answer is "+ secretWord +".");
        }
        
        //common code
        gameResultLabel = new JLabel(frameLabel);
        returnBtn = new JButton("Return to the main menu");
        returnBtn.addActionListener(this);
        
        //adding everything to the frame
        if(won){
        	frame.add(answerIs);
        }
        frame.add(secretWordLabel);
        frame.add(gameResultLabel);
        frame.add(returnBtn);
        if(!won){
        	frame.add(gif);
        }
        frame.setVisible(true);
        
    }
    
    private void background(JFrame frame){
        gif.setBounds(0, 0, icon.getIconWidth(),icon.getIconHeight());
   
        JPanel imagePanel = (JPanel) frame.getContentPane();
        imagePanel.setOpaque(false);

        imagePanel.setLayout(new FlowLayout());

        frame.getLayeredPane().setLayout(null);

        frame.getLayeredPane().add(gif, new Integer(Integer.MIN_VALUE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(icon.getIconWidth(), icon.getIconHeight());
        frame.setResizable(false);
    }

	public void actionPerformed(ActionEvent arg0) {
		frame.dispose(); //close the window
        parentFrame.dispose(); // and the parent
    	new Start().createAndShowGUI(); // start over
		
	}
	
}