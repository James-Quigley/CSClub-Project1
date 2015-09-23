import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PathButton extends JPanel {
	
	
	
	
	
	private JLabel label;//label is what gets changed depending on which button
	
	//just some sample options for time being
	
	private String pathA="Go into the woods";
	private String pathB="Dont go into woods";
	private String pathC="Ask locals about the woods";
	private String pathD="Run Away";
	
	
	
	
	private JButton pathA_Button;
	private JButton pathB_Button;
	private JButton pathC_Button;
	private JButton pathD_Button;
	
	private JPanel buttonPanel;
	
	
	public PathButton(){
		
		// first i declare the listner for the buttons
		
		ButtonListener listener=new ButtonListener();
		
		
		label=new JLabel("Pick a path");
		
		pathA_Button=new JButton(pathA);//creates button
		
		pathA_Button.addActionListener(listener);//associates the listener the same listener will be used for all buttons but in theory you dont have to use the same
		
		
		pathB_Button=new JButton(pathB);//creates button
		
		pathB_Button.addActionListener(listener);//associates the listener
		
		
		pathC_Button=new JButton(pathC);//creates button
		
		pathC_Button.addActionListener(listener);//associates the listener
		
		
		pathD_Button=new JButton(pathD);//creates button
		
		pathD_Button.addActionListener(listener);//associates the listener
	
		buttonPanel=new JPanel();//creates a new panel
		buttonPanel.setPreferredSize(new Dimension(600,40));//sets panel size
		buttonPanel.setBackground(Color.black);//sets color of panel
		buttonPanel.add(pathA_Button);/*adds all the buttons to the panel*/
		buttonPanel.add(pathB_Button);
		buttonPanel.add(pathC_Button);
		buttonPanel.add(pathD_Button);
		
		
		
		setBackground(Color.lightGray);//sets frame background
		setPreferredSize(new Dimension(1000,500));// parameter must a be a dimension object
		add(label);
		add(buttonPanel);//adds the panel of buttons to the frame
		
	}
	//ignore this next constructor this was just me testing stuff
	/*public PathButton(Slide toDisplay,ArrayList toParse){
		
		list=toParse;
		current=toDisplay;
		
		label=new JLabel("dont care");
		ButtonListener listener=new ButtonListener();
		
		//get all the choices from slide
		pathA=current.getOption(1);
		pathB=current.getOption(2);
		pathC=current.getOption(3);
		pathD=current.getOption(4);
		
		//create corresponding buttons
		pathA_Button=new JButton(pathA);
		pathB_Button=new JButton(pathB);
		pathC_Button=new JButton(pathC);
		pathD_Button=new JButton(pathD);
	
		//connect buttons with listener
		pathA_Button.addActionListener(listener);
		pathB_Button.addActionListener(listener);
		pathC_Button.addActionListener(listener);
		pathD_Button.addActionListener(listener);
		
		//create panel 
		buttonPanel=new JPanel();
		//set size
		buttonPanel.setPreferredSize(new Dimension(600,40));
		buttonPanel.setBackground(Color.gray);
		
		//fill the panel with buttons
		add(pathA_Button);
		add(pathB_Button);
		add(pathC_Button);
		add(pathD_Button);
		
		//set container atributes
		setBackground(Color.gray);
		setPreferredSize(new Dimension(700,100));
		
		//populate container
		add(buttonPanel);
		add(label);
	}*/
	
	
	/*In order to track when a button is pressed we need a listener. I dont think there is a listern class in the java library 
	but there is an interface that only has one method. My java book recomends always making this a private subclass*/
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	

