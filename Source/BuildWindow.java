/* 
Name: Build Panel 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 10/1/15
Contributors:
 */
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.JFrame;
import java.io.*;
import java.util.*; 
import java.awt.*;

public class BuildWindow extends JPanel implements GUIInterface
{
	private JButton exitToDesk, exitToMenu;
	private JButton createGame, createNewSlide, createNewBuild;
	private JButton saveSlide, LoadSlide, backToMMenu;
	private JButton answer1B, answer2B, answer3B, answer4B;
	private JComboBox<String> createdSlides, createdGames;
	private JComboBox<String> createdSlidesAnswer1, createdSlidesAnswer2, createdSlidesAnswer3, createdSlidesAnswer4;
	private JFrame buildFrame, buildMenu;
	private MenuWindow MainMenu;
	private JPanel mainPanel, loadPanel;
	private JPanel options, ButtonPanel;
	private JPanel body, DropBoxPanel;
	private JPanel headers, CreatePanel;
	private JPanel answers, MenuPanel;
	private JLabel Message;
	private JTextField storyText;
	private JTextField answer1Text, answer2Text, answer3Text, answer4Text;
	private JTextField answer1Loc, answer2Loc, answer3Loc, answer4Loc;
	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;
	private Game currentGame;
	private Slide currentSlide;
	
    public BuildWindow(JFrame incBuildFrame, MenuWindow oldMMenu)// constructer
    {
		currentGame = new Game();
		currentSlide = new Slide();
		MainMenu = oldMMenu;
		buildFrame = incBuildFrame;
		
		createComponents();
		
		buildComponents();
		
		addActionListeners();
		
		addElements();
		
		addGameMenu();
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
		headers.add(exitToDesk);
		headers.add(exitToMenu);
		
		options.add(new JLabel("Select which slide to edit."));
		options.add(createdSlides);
		options.add(new JLabel(" "));
		options.add(new JLabel(" "));
		options.add(saveSlide);
		options.add(new JLabel(" "));
		options.add(new JLabel(" "));
		options.add(createNewSlide);
		options.add(new JLabel(" "));
		options.add(new JLabel(" "));
		//options.add(LoadSlide);
		
		answers.add(answer1Text);
		answers.add(new JLabel("Set Next Path Location For Answer One:"));
		answers.add(createdSlidesAnswer1);
		answers.add(answer1Loc);
		
		answers.add(answer2Text);
		answers.add(new JLabel("Set Next Path Location For Answer Two:"));
		answers.add(createdSlidesAnswer2);
		answers.add(answer2Loc);
		
		answers.add(answer3Text);
		answers.add(new JLabel("Set Next Path Location For Answer Two:"));
		answers.add(createdSlidesAnswer3);
		answers.add(answer3Loc);
		
		answers.add(answer4Text);
		answers.add(new JLabel("Set Next Path Location For Answer Four:"));
		answers.add(createdSlidesAnswer4);
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
		MainMenu.setVisible(false);
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// get screen size.
		SCREEN_WIDTH = gd.getDisplayMode().getWidth();
		SCREEN_HEIGHT = gd.getDisplayMode().getHeight();
		
		buildFrame.setLayout(new BorderLayout(10,10));
		buildFrame.setBackground(Color.cyan);
		buildFrame.setPreferredSize(new Dimension(SCREEN_WIDTH-5, SCREEN_HEIGHT-5));
		
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
		
		body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
		
		headers.setLayout(new FlowLayout());
		
		answers.setLayout(new GridLayout(5, 2, 5, 5));
		
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

		createdSlides.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/35));
		createNewSlide.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		LoadSlide.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		saveSlide.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		createGame.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		
		buildMenu.setResizable(false);
		
		buildMenu.setPreferredSize(new Dimension(SCREEN_WIDTH/2,SCREEN_HEIGHT/2));
		buildMenu.setLayout(new FlowLayout());
		buildMenu.setLocation(SCREEN_WIDTH/4,SCREEN_HEIGHT/4);
		
		
		Message.setLayout(new BoxLayout(Message, BoxLayout.Y_AXIS));
		
		MenuPanel.setLayout(new BoxLayout(MenuPanel, BoxLayout.Y_AXIS));
		
		loadPanel.setLayout(new BoxLayout(loadPanel, BoxLayout.Y_AXIS));
		
		DropBoxPanel.setMaximumSize(new Dimension(SCREEN_WIDTH/2,50));
		ButtonPanel.setMaximumSize(new Dimension(SCREEN_WIDTH/2,50));
		CreatePanel.setMaximumSize(new Dimension(SCREEN_WIDTH/2,50));
		Message.setMaximumSize(new Dimension(SCREEN_WIDTH/2, 50));
		backToMMenu.setMaximumSize(new Dimension(SCREEN_WIDTH/2, 50));
		
		DropBoxPanel.setMinimumSize(new Dimension(200,50));
		ButtonPanel.setMinimumSize(new Dimension(200,50));
		CreatePanel.setMinimumSize(new Dimension(200,50));
		Message.setMinimumSize(new Dimension(200, 50));
		backToMMenu.setMinimumSize(new Dimension(200, 50));
		
		buildMenu.setUndecorated(true);
		buildMenu.getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG );
		buildMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createdSlidesAnswer1.setActionCommand("A1");
		createdSlidesAnswer2.setActionCommand("A2");
		createdSlidesAnswer3.setActionCommand("A3");
		createdSlidesAnswer4.setActionCommand("A4");
		
		createdSlides.addItem("Select One");
	}
	
	/**createComponents
	* creates components and gives them
	* default values.
	* J.B.
	**/
	public void createComponents()
	{
		//need to load saved game titles here, put into an array and added to the ComboBoxes...
		//Need to load Game slides titles here, put into an array and added to the ComboBoxes...
		
		mainPanel = new JPanel();
		options = new JPanel();
		body = new JPanel();
		headers = new JPanel();
		answers = new JPanel();
		
		if(currentSlide.getChoiceTextAtIndex(1) != null)
		{
			storyText = new JTextField(currentSlide.getText(),15);
			answer1Text = new JTextField(currentSlide.getChoiceTextAtIndex(0));
			answer2Text = new JTextField(currentSlide.getChoiceTextAtIndex(1));
			answer3Text = new JTextField(currentSlide.getChoiceTextAtIndex(2));
			answer4Text = new JTextField(currentSlide.getChoiceTextAtIndex(3));
		}else
		{
			storyText = new JTextField("", 15);
			answer1Text = new JTextField();
			answer2Text = new JTextField();
			answer3Text = new JTextField();
			answer4Text = new JTextField();
		}

		
		answer1B = new JButton("Set Event Location For Answer One");
		answer2B = new JButton("Set Event Location For Answer Two");
		answer3B = new JButton("Set Event Location For Answer Three");
		answer4B = new JButton("Set Event Location For Answer Four");
		
		answer1Loc = new JTextField("Current Location: ");
		answer2Loc = new JTextField("Current Location: ");
		answer3Loc = new JTextField("Current Location: ");
		answer4Loc = new JTextField("Current Location: ");
		
		createdSlidesAnswer1 = new JComboBox<String>();// inset game slide's titles here
		createdSlidesAnswer2 = new JComboBox<String>();// inset game slide's titles here
		createdSlidesAnswer3 = new JComboBox<String>();// inset game slide's titles here
		createdSlidesAnswer4 = new JComboBox<String>();// inset game slide's titles here
		
		createGame = new JButton("Create Game");
		saveSlide = new JButton("Save Slide");
		exitToDesk = new JButton("Exit To Desktop");
		exitToMenu = new JButton("Exit To Menu");
		
		createdSlides = new JComboBox<String>();// inset game slide's titles here
		LoadSlide = new JButton("Load Slide");
		createNewSlide = new JButton("Create New Slide");
		
		createNewBuild = new JButton("Create New Game");
		createdGames = new JComboBox<String>();//insert game title array here
		backToMMenu = new JButton("Back To Main Menu");
		Message = new JLabel("Load an Existing Game or Create a New One");
		
		loadPanel = new JPanel();
		ButtonPanel = new JPanel(new FlowLayout());
		DropBoxPanel = new JPanel(new FlowLayout());
		CreatePanel = new JPanel(new FlowLayout());
		MenuPanel = new JPanel();
		buildMenu = new JFrame("Build Game Menu");
	}

	/**updateComponents
	* will update all components to there
	* current values
	* J.B.
	**/
	private void updateComponents()
	{
		storyText.setText(currentSlide.getText());
		answer1Text.setText(currentSlide.getChoiceTextAtIndex(0));
		answer2Text.setText(currentSlide.getChoiceTextAtIndex(1));
		answer3Text.setText(currentSlide.getChoiceTextAtIndex(2));
		answer4Text.setText(currentSlide.getChoiceTextAtIndex(3));
		
		if(currentSlide.getChoiceAtIndex(0) != null)
		{
			answer1Loc.setText("Current Loaction: " + currentSlide.getChoiceTitleAtIndex(0));
			answer2Loc.setText("Current Loaction: " + currentSlide.getChoiceTitleAtIndex(1));
			answer3Loc.setText("Current Loaction: " + currentSlide.getChoiceTitleAtIndex(2));
			answer4Loc.setText("Current Loaction: " + currentSlide.getChoiceTitleAtIndex(3));
		}else
		{
			answer1Loc.setText("Current Loaction: ");
			answer2Loc.setText("Current Loaction: ");
			answer3Loc.setText("Current Loaction: ");
			answer4Loc.setText("Current Loaction: ");
		}
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
		
		createdSlides.addActionListener(new ComboListener());
		LoadSlide.addActionListener(new ButtonListener());
		createNewSlide.addActionListener(new ButtonListener());
		
		createdGames.addActionListener(new ComboListenerLoad());
		createNewBuild.addActionListener(new ButtonListener());
		backToMMenu.addActionListener(new ButtonListener());
		
		createdSlidesAnswer1.addActionListener(new ComboListener());
		createdSlidesAnswer2.addActionListener(new ComboListener());
		createdSlidesAnswer3.addActionListener(new ComboListener());
		createdSlidesAnswer4.addActionListener(new ComboListener());
	}

	/**addGameMenu
	* gives users option to load game, or
	* create new Game.
	* J.B.
	**/
	private void addGameMenu()
	{
		buildFrame.setVisible(false);
		
		DropBoxPanel.add(new JLabel("Select from previously built Games "));
		
		DropBoxPanel.add(createdGames);
		
		DropBoxPanel.add(ButtonPanel);
		
		loadPanel.add(DropBoxPanel);
		
		CreatePanel.add(createNewBuild);
		
		CreatePanel.add(backToMMenu);
		
		MenuPanel.add(Message);
		MenuPanel.add(loadPanel);
		MenuPanel.add(CreatePanel);
		buildMenu.add(MenuPanel);
		
		buildMenu.pack();
		buildMenu.setVisible(true);
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
					MainMenu.setVisible(true);
				}
			}else if(command.equals( "Create New Slide"))
			{
				String title = JOptionPane.showInputDialog(buildFrame,"Set the Title of the Path: ");
				
				int result = JOptionPane.showConfirmDialog(buildFrame,"Are you sure you want to leave this window.");
				if(result == JOptionPane.YES_OPTION)
				{
					currentSlide = new Slide();
					currentSlide.setTitle(title);
					buildFrame.setTitle(title);
					
					createdSlides.addItem(title);
					createdSlidesAnswer1.addItem(title);
					createdSlidesAnswer2.addItem(title);
					createdSlidesAnswer3.addItem(title);
					createdSlidesAnswer4.addItem(title);
					
					currentGame.updateSlide(currentSlide);
					updateComponents();
				}
			}else if(command.equals( "Load Slide"))
			{
				
			}else if(command.equals( "Save Slide"))
			{
				currentSlide.setText(storyText.getText());
				currentSlide.setNextChoice(currentGame.getSlideAtIndex(createdSlidesAnswer1.getSelectedIndex()), answer1Text.getText(), 0);
				currentSlide.setNextChoice(currentGame.getSlideAtIndex(createdSlidesAnswer2.getSelectedIndex()), answer2Text.getText(), 1);
				currentSlide.setNextChoice(currentGame.getSlideAtIndex(createdSlidesAnswer3.getSelectedIndex()), answer3Text.getText(), 2);
				currentSlide.setNextChoice(currentGame.getSlideAtIndex(createdSlidesAnswer4.getSelectedIndex()), answer4Text.getText(), 3);
				currentGame.updateSlide(currentSlide);
				JOptionPane.showMessageDialog(buildFrame, "Saved!");

				
			}else if(command.equals( "Create Game"))
			{
				//saveGame here...
			}else if(command.equals( "Create New Game"))
			{
				JOptionPane menuJOP = new JOptionPane();
				currentGame = new Game();
				currentSlide = new Slide();
				currentGame.addSlide(currentSlide);
				String title = null;
				do{
					title = menuJOP.showInputDialog(buildFrame,"Set the Title of the First Path: ");
					
				}while(title != null && title.compareTo("") == 0);
				
				if(title != null)
				{
					buildMenu.dispose();
					buildFrame.setVisible(true);
					currentSlide.setTitle(title);
					createdSlides.addItem(title);	
					createdSlidesAnswer1.addItem(title);
					createdSlidesAnswer2.addItem(title);
					createdSlidesAnswer3.addItem(title);
					createdSlidesAnswer4.addItem(title);
					createdSlides.setActionCommand("CS");
				}
			}else if(command.equals("Back To Main Menu"))
			{
				buildMenu.dispose();
				MainMenu.setVisible(true);
			};
		}  
	}
	private class ComboListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();
			
			if(command == "A1")
			{
				answer1Loc.setText("Current Location: " + createdSlidesAnswer1.getSelectedItem());
				int index = createdSlidesAnswer1.getSelectedIndex();
				currentSlide.setNextChoice(currentGame.getSlideAtIndex(index), answer1Text.getText(), 0);
			}else if(command == "A2")
			{
				answer2Loc.setText("Current Location: " + createdSlidesAnswer2.getSelectedItem());
				int index = createdSlidesAnswer2.getSelectedIndex();
				currentSlide.setNextChoice(currentGame.getSlideAtIndex(index), answer2Text.getText(), 1);
			}else if(command == "A3")
			{
				answer3Loc.setText("Current Location: " + createdSlidesAnswer3.getSelectedItem());
				int index = createdSlidesAnswer3.getSelectedIndex();
				currentSlide.setNextChoice(currentGame.getSlideAtIndex(index), answer3Text.getText(), 2);
			}else if(command == "A4")
			{
				answer4Loc.setText("Current Location: " + createdSlidesAnswer4.getSelectedItem());
				int index = createdSlidesAnswer4.getSelectedIndex();
				currentSlide.setNextChoice(currentGame.getSlideAtIndex(index), answer4Text.getText(), 3);
			}else if(command == "CS")
			{
				if(createdSlides.getSelectedItem() != "Select One")
				{
					int result = JOptionPane.showConfirmDialog(buildFrame,"Are you sure you want to leave this window.");
					if(result == JOptionPane.YES_OPTION)
					{
						currentSlide = currentGame.getSlideAtIndex(createdSlides.getSelectedIndex()-1);
						updateComponents();
					}	
				}
			}
		}
	}
	private class ComboListenerLoad implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int result = JOptionPane.showConfirmDialog(buildFrame, "Are you sure you want to Load " + createdGames.getSelectedItem() +"?");
			if (result == JOptionPane.YES_OPTION)
			{
				// we need to load game selected Item here...
				buildMenu.dispose();
				buildFrame.setTitle("Editing: " + createdGames.getSelectedItem());
				buildFrame.setVisible(true);
			}
		}
	}
}
