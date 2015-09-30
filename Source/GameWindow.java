import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JPanel implements GUIInterface {
	
	private JLabel label;//label is what gets changed depending on which button
	private String pathA="Go into the woods";
	private String pathB="Dont go into woods";
	private String pathC="Ask locals about the woods";
	private String pathD="Run Away";
	
	private JFrame gameFrame;
	
	private JButton pathA_Button;
	private JButton pathB_Button;
	private JButton pathC_Button;
	private JButton pathD_Button;
	
	private JPanel buttonPanel;
	
	private int Swidth;
	private int Sheight;
	
	private ButtonListener listener;
	
	public GameWindow()
	{
		createComponents();//creates buttons,panel, and listener
		
		buildComponents();//associates listener with each button
		
		addActionListeners();
		
		addElements();//adds the buttons
		
		gameFrame.pack();
		
		gameFrame.setVisible(true);
	}
	
	public void addElements(){
		
		buttonPanel.add(pathA_Button);/*adds all the buttons to the panel*/
		buttonPanel.add(pathB_Button);
		buttonPanel.add(pathC_Button);
		buttonPanel.add(pathD_Button);
		
		gameFrame.add(label);
		gameFrame.add(buttonPanel);//adds the panel of buttons to the frame
		
	}
	
	public void buildComponents()
	{
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// geting size of screen
		Swidth = gd.getDisplayMode().getWidth();
		Sheight = gd.getDisplayMode().getHeight();
		
		buttonPanel.setPreferredSize(new Dimension(600,40));//sets panel size
		buttonPanel.setBackground(Color.black);//sets color of panel
		
		gameFrame.setBackground(Color.lightGray);//sets frame background
		gameFrame.setPreferredSize(new Dimension(Swidth/2,Sheight/2));// parameter must a be a dimension object
	}
	
	public void createComponents(){
		gameFrame = new JFrame();
		
		listener=new ButtonListener();
		
		buttonPanel=new JPanel();
	
		label=new JLabel("Pick a path");
		
		pathA_Button=new JButton(pathA);
		
		pathB_Button=new JButton(pathB);
		
		pathC_Button=new JButton(pathC);
		
		pathD_Button=new JButton(pathD);
	}
	
	private void addActionListeners()
	{
		pathA_Button.addActionListener(listener);
		
		pathB_Button.addActionListener(listener);
		
		pathC_Button.addActionListener(listener);
		
		pathD_Button.addActionListener(listener);
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event){//The event is when a mouse is clicked
			if(event.getSource() == pathA_Button ){
				label.setText("pathA has been pressed");
			}
			else if(event.getSource() == pathB_Button){
				label.setText("pathB has been pressed");
			}	
		
			else if(event.getSource() == pathC_Button){
				label.setText("pathC has been pressed");
			}
			else if(event.getSource() == pathD_Button){
				label.setText("pathD has been pressed");
			}
			else{
				label.setText("Error");
			}	
		}
	}	
}