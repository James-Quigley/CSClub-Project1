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

public class BuildWindow extends JPanel implements GUIInterface
{
	private JButton exitToDesk, exitToMenu;
	private JButton createGame, createNewSlide, createNewBuild;
	private JButton saveSlide, LoadSlide, backToMMenu;
	private JButton answer1B, answer2B, answer3B, answer4B;
	private JComboBox<String> createdSlides, createdGames;
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
		headers.add(saveSlide);
		headers.add(exitToDesk);
		headers.add(exitToMenu);
		
		options.add(createdSlides);
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

		createdSlides.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/35));
		createNewSlide.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
		LoadSlide.setMaximumSize(new Dimension(SCREEN_WIDTH/10,SCREEN_HEIGHT/30));
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
		
	}
	
	/**createComponents
	* creates components and gives them
	* default values.
	* J.B.
	**/
	public void createComponents()
	{
		String [] Games = {"Game One", "Game Two", "Game Three"};// need to load saved game names here...
		
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
		
		createdSlides = new JComboBox<String>();
		LoadSlide = new JButton("Load Slide");
		createNewSlide = new JButton("Create New Slide");
		
		createNewBuild = new JButton("Create New Game");
		createdGames = new JComboBox<String>(Games);
		backToMMenu = new JButton("Back To Main Menu");
		Message = new JLabel("Load an Existing Game or Create a New One");
		
		loadPanel = new JPanel();
		ButtonPanel = new JPanel(new FlowLayout());
		DropBoxPanel = new JPanel(new FlowLayout());
		CreatePanel = new JPanel(new FlowLayout());
		MenuPanel = new JPanel();
		buildMenu = new JFrame("Build Game Menu");
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
				Slide currentSlide = new Slide();
				currentSlide.setTitle(JOptionPane.showInputDialog(buildFrame,"Set the Title of the Path: "));
			}else if(command.equals( "Load Slide"))
			{
				
			}else if(command.equals( "Save Slide"))
			{
				currentSlide.setText(storyText.getText());
				currentGame.addSlide(currentSlide);
				createdSlides.addItem(currentSlide.getTitle());
			}else if(command.equals( "Create Game"))
			{
				//saveGame here...
			}else if(command.equals( "Set Event Location For Answer One"))
			{
				
			}else if(command.equals( "Set Event Location For Answer Two"))
			{
				
			}else if(command.equals( "Set Event Location For Answer Three"))
			{
				
			}else if(command.equals( "Set Event Location For Answer Four"))
			{
				
			}else if(command.equals( "Create New Game"))
			{
				JOptionPane menuJOP = new JOptionPane();
				currentGame = new Game();
				currentSlide = new Slide();
				String title = null;
				do{
					title = menuJOP.showInputDialog(buildFrame,"Set the Title of the First Path: ");
					
				}while(title != null && title.compareTo("") == 0);
				
				if(title != null)
				{
					buildMenu.dispose();
					buildFrame.setVisible(true);
					currentSlide.setTitle(title);
					buildFrame.setTitle(title + " Slide");
					createdSlides.addItem(title);	
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
			//label.setText("location: " + createdSlides.getSelectedIndex()); selected drop box item...
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
