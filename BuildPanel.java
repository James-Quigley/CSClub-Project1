/* 
Name: Build Panel 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/10/15
Contributors:
 */
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.JFrame;
import java.io.*;
import java.util.*; 
import java.awt.*;

public class BuildPanel extends JPanel 
{
    private JButton PlaceHolder1;
	private JButton PlaceHolder2;
	private JButton exit;
	private JButton PlaceHolder3;
    private JLabel label; 
	private JComboBox<String> createdEvents;
	private JFrame buildFrame;
	private JPanel mainPanel;
	private JPanel options;
	private JPanel body;
	private JPanel headers;
	private JPanel answers;
	private JTextField storyText;
	private JTextField answer1Text, answer2Text, answer3Text, answer4Text;
	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;
	
    public BuildPanel(JFrame incBuildFrame)// constructer
    {
		buildFrame = incBuildFrame;
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		SCREEN_WIDTH = gd.getDisplayMode().getWidth();
		SCREEN_HEIGHT = gd.getDisplayMode().getHeight();
		
		buildFrame.setLayout(new BorderLayout(10,10));
		buildFrame.setBackground(Color.cyan);
		buildFrame.setPreferredSize(new Dimension(SCREEN_WIDTH-5, SCREEN_HEIGHT-5));
		
		createComponents();
		
		buildComponents();
		
		addActionListeners();
		
		addElements();
	}
	
	/**addElements
	* add components to panels and
	* adds panels to Frame
	* JoshuaBecker
	**/
	private void addElements()
	{
		body.add(storyText);
		
		headers.add(PlaceHolder3);
		
		options.add(createdEvents);
		options.add(PlaceHolder1);
		options.add(PlaceHolder2);
		options.add(exit);
		
		answers.add(answer1Text);
		answers.add(answer2Text);
		answers.add(answer3Text);
		answers.add(answer4Text);
		
		buildFrame.add(body,BorderLayout.CENTER);
		buildFrame.add(options, BorderLayout.WEST);
		buildFrame.add(headers,BorderLayout.NORTH);
		buildFrame.add(answers,BorderLayout.SOUTH);
	}
	
	/**buildComponents
	* set up components and there attributes.
	* JoshuaBecker
	**/
	private void buildComponents()
	{
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
		body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
		headers.setLayout(new FlowLayout());
		answers.setLayout(new BoxLayout(answers,BoxLayout.Y_AXIS));
		
		body.setSize(SCREEN_WIDTH-500,SCREEN_HEIGHT-500);
		answers.setPreferredSize(new Dimension(SCREEN_WIDTH/2, SCREEN_HEIGHT/6));
		
		storyText.setMaximumSize(new Dimension(SCREEN_WIDTH-500,SCREEN_HEIGHT-500));
		
		answer1Text.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		answer2Text.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		answer3Text.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		answer4Text.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));

		createdEvents.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/35));
		PlaceHolder1.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		PlaceHolder2.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		PlaceHolder3.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		
	}
	
	/**createComponents
	* creates components and gives them
	* default values.
	* JoshuaBecker
	**/
	private void createComponents()
	{
		String [] events = {"Slide Menu", "Good Bye"};
		
		mainPanel = new JPanel();
		options = new JPanel();
		body = new JPanel();
		headers = new JPanel();
		answers = new JPanel();
		
		storyText = new JTextField("Place Holder... Work in Progress");
		answer1Text = new JTextField("Place Holder...1");
		answer2Text = new JTextField("Place Holder...2");
		answer3Text = new JTextField("Place Holder...3");
		answer4Text = new JTextField("Place Holder...4");
		
		createdEvents = new JComboBox<String>(events);
		PlaceHolder3 = new JButton("place Holder 3");
		PlaceHolder2 = new JButton("place Holder 2");
		PlaceHolder1 = new JButton("Place Holder 1");
		exit = new JButton("Exit To Desktop");
	}
	
	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	* JoshuaBecker
	**/
	private void addActionListeners()
	{
		createdEvents.addActionListener(new ComboListener());
		PlaceHolder3.addActionListener(new ButtonListener());
		PlaceHolder2.addActionListener(new ButtonListener());
		PlaceHolder1.addActionListener(new ButtonListener());
		exit.addActionListener(new ButtonListener());
	}

	/**Listeners
	* Once an event occurs the program goes here
	* and decides what to do with each event.
	* JoshuaBecker
	**/
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();  
			// actions of buttons...
		}  
	}
	private class ComboListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//label.setText("location: " + createdEvents.getSelectedIndex()); selected drop box item...
		}
	}
}