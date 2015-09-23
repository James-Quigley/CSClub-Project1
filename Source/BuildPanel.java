/* 
Name: Build Panel 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/17/15
Contributors:
 */
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.JFrame;
import java.io.*;
import java.util.*; 
import java.awt.*;

public class BuildPanel extends JPanel implements GUIInterface
{
	private JButton exitToDesk, exitToMenu;
	private JButton createGame, createNewSlide;
	private JButton saveSlide, LoadSlide;
	private JButton answer1B, answer2B, answer3B, answer4B;
	private JComboBox<String> createdEvents;
	private JFrame buildFrame;
	private JPanel mainPanel;
	private JPanel options;
	private JPanel body;
	private JPanel headers;
	private JPanel answers;
	private JTextField storyText;
	private JTextField answer1Text, answer2Text, answer3Text, answer4Text;
	private JTextField answer1Loc, answer2Loc, answer3Loc, answer4Loc;
	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;
	
    public BuildPanel(JFrame incBuildFrame)// constructer
    {
		buildFrame = incBuildFrame;
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// get screen size.
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
	* J.B.
	**/
	public void addElements()
	{
		body.add(storyText);
		
		
		headers.add(createGame);
		headers.add(saveSlide);
		headers.add(exitToDesk);
		headers.add(exitToMenu);
		
		options.add(createdEvents);
		options.add(createNewSlide);
		options.add(LoadSlide);
		
		answers.add(answer1Text);
		answers.add(answer1B);
		answers.add(answer1Loc);
		answers.add(answer2Text);
		answers.add(answer2B);
		answers.add(answer2Loc);
		answers.add(answer3Text);
		answers.add(answer3B);
		answers.add(answer3Loc);
		answers.add(answer4Text);
		answers.add(answer4B);
		answers.add(answer4Loc);
		
		buildFrame.add(body,BorderLayout.CENTER);
		buildFrame.add(options, BorderLayout.WEST);
		buildFrame.add(headers,BorderLayout.NORTH);
		buildFrame.add(answers,BorderLayout.SOUTH);
	}
	
	/**buildComponents
	* set up components and there attributes.
	* J.B.
	**/
	public void buildComponents()
	{
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
		body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
		headers.setLayout(new FlowLayout());
		answers.setLayout(new GridLayout(4, 2, 5, 5));
		
		body.setSize(SCREEN_WIDTH-500,SCREEN_HEIGHT-500);
		answers.setPreferredSize(new Dimension(SCREEN_WIDTH/2, SCREEN_HEIGHT/6));
		
		storyText.setMaximumSize(new Dimension(SCREEN_WIDTH-500,SCREEN_HEIGHT-500));
		
		answer1Text.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		answer2Text.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		answer3Text.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		answer4Text.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		
		answer1B.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		answer2B.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		answer3B.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		answer4B.setMaximumSize(new Dimension(SCREEN_WIDTH/3,SCREEN_HEIGHT/9));
		
		answer1Loc.setEditable(false);
		answer2Loc.setEditable(false);
		answer3Loc.setEditable(false);
		answer4Loc.setEditable(false);

		createdEvents.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/35));
		createNewSlide.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		LoadSlide.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		createGame.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		
	}
	
	/**createComponents
	* creates components and gives them
	* default values.
	* J.B.
	**/
	public void createComponents()
	{
		String [] events = {"Slide Menu", "Slide One", "Slide Three"};// need to load Slides here...
		
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
		
		answer1B = new JButton("Set Event Location For Answer One");
		answer2B = new JButton("Set Event Location For Answer Two");
		answer3B = new JButton("Set Event Location For Answer Three");
		answer4B = new JButton("Set Event Location For Answer Four");
		
		answer1Loc = new JTextField("Current Loaction: ");
		answer2Loc = new JTextField("Current Loaction:");
		answer3Loc = new JTextField("Current Loaction:");
		answer4Loc = new JTextField("Current Loaction:");
		
		createGame = new JButton("Create Game");
		saveSlide = new JButton("Save Slide");
		exitToDesk = new JButton("Exit To Desktop");
		exitToMenu = new JButton("Exit To Menu");
		
		createdEvents = new JComboBox<String>(events);
		LoadSlide = new JButton("Load Slide");
		createNewSlide = new JButton("Create New Slide");
	}
	
	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	* J.B.
	**/
	private void addActionListeners()
	{
		answer1B.addActionListener(new ButtonListener());
		answer2B.addActionListener(new ButtonListener());
		answer3B.addActionListener(new ButtonListener());
		answer4B.addActionListener(new ButtonListener());
		
		createGame.addActionListener(new ButtonListener());
		saveSlide.addActionListener(new ButtonListener());
		exitToDesk.addActionListener(new ButtonListener());
		exitToMenu.addActionListener(new ButtonListener());
		
		createdEvents.addActionListener(new ComboListener());
		LoadSlide.addActionListener(new ButtonListener());
		createNewSlide.addActionListener(new ButtonListener());
	}

	/**Listeners
	* Once an event occurs the program goes here
	* and decides what to do with each event.
	* J.B.
	**/
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();  
			if( command.equals( "Exit To Desktop"))
			{
				int result = JOptionPane.showConfirmDialog(buildFrame, "Are you sure you want to exit to desktop?");
				if (result == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}else if(command.equals( "Exit To Menu"))
			{
				int result = JOptionPane.showConfirmDialog(buildFrame, "Are you sure you want to exit to Main Menu?");
				if (result == JOptionPane.YES_OPTION){
					buildFrame.dispose();
					JFrame menuFrame = new JFrame("Main Menu");
					menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					MenuPanel panel = new MenuPanel(menuFrame); 
					menuFrame.pack();
					menuFrame.setVisible(true);
				}
			}else if(command.equals( "Create New Slide"))
			{
				
			}else if(command.equals( "Load Slide"))
			{
				
			}else if(command.equals( "Save Slide"))
			{
				
			}else if(command.equals( "Create Game"))
			{
				
			}else if(command.equals( "Set Event Location For Answer One"))
			{
				
			}else if(command.equals( "Set Event Location For Answer Two"))
			{
				
			}else if(command.equals( "Set Event Location For Answer Three"))
			{
				
			}else if(command.equals( "Set Event Location For Answer Four"))
			{
				
			}
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
