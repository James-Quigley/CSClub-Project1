/* 
Name: Menu Panel 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/19/15
Contributors:
 */

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.JFrame;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class MenuWindow extends JPanel implements GUIInterface
{
    private JButton playGame;
	private JButton buildGame;
	private JButton exit;
	private JButton help, about;
	private JButton settings;
	private JToolBar menuBar;
    private JLabel labelBackround;
	private JPanel buttonPanel, mainPanel;
	private JFrame menuFrame;
	private Image ImageOfBackround;
	private BufferedImage menuBackround;
	private ImageIcon menuIcon;
	private int width;
	private int height;
	
    public MenuWindow(JFrame incMenuFrame)// constructer
    {
		menuFrame = incMenuFrame;
		
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
		buttonPanel.add(buildGame);
		buttonPanel.add(playGame);
		buttonPanel.add(exit);
		
		menuBar.add(settings);
		menuBar.add(help);
		menuBar.add(about);
		
		mainPanel.add(menuBar, BorderLayout.PAGE_START);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		
		menuFrame.add(mainPanel);
	}
	
	/**buildComponents
	* set up components and there attributes.
	* J.B.
	**/
	public void buildComponents()
	{
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// geting size of screen
		width = gd.getDisplayMode().getWidth();
		height = gd.getDisplayMode().getHeight();
		
		loadImg();
		ImageOfBackround = menuBackround.getScaledInstance(width/2, height/2, Image.SCALE_SMOOTH);
		menuIcon = new ImageIcon(ImageOfBackround);
		menuFrame.setIconImage(ImageOfBackround);
		
	    buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.black);
		
		menuBar.setFloatable(false);
		menuBar.setPreferredSize(new Dimension(width/2,25));
		menuBar.setBackground(Color.black);
		menuBar.setBorder(null);
		
		mainPanel.setLayout(new BorderLayout(10,height/6));
		mainPanel.setBackground(Color.black);
		
		menuFrame.setPreferredSize(new Dimension(width/2, height/2));
		menuFrame.setLocation(width/4, height/4); // centering window
		menuFrame.setResizable(false);
	}
	
	/**loadImg
	* loads image from file.
	* J.B.
	**/
	private void loadImg()
	{
		String path = "";
		try //loading image
		{
			path = System.getProperty("user.dir");
			path = path.replace('\\','/');
			path = path.replaceAll("Source", "/Assets/Backround/menuBackround.jpg");
			
			menuBackround = ImageIO.read(new File(path));
		} catch (IOException e) 
		{
			System.out.println(path);
			System.out.println("cant find image");
		}
	}
	
	/**createComponents
	* creates components and gives them
	* default values.
	* J.B.
	**/
	public void createComponents()
	{
		buildGame = new JButton("Build Game");
		playGame = new JButton("Play Game");
		exit = new JButton("Exit To Desktop");
		menuBar = new JToolBar("menu Tool Bar");
		settings = new JButton("Settings");
		help = new JButton("Help");
		about = new JButton("About");
		buttonPanel = new JPanel();
		mainPanel = new JPanel();
		menuBackround = null;
		
	}

	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	* J.B.
	**/
	private void addActionListeners()
	{
		buildGame.addActionListener(new ButtonListener(this));// in order to call menu with out haveing to create new object.
		playGame.addActionListener(new ButtonListener());
		exit.addActionListener(new ButtonListener());
		help.addActionListener(new ButtonListener());
		about.addActionListener(new ButtonListener());
		settings.addActionListener(new ButtonListener());
		
	}

	/**Listeners
	* Once an event occurs the program goes here
	* and decides what to do with each event.
	*
	*@peram MenuPanel.
	*@peram nothing.
	* J.B.
	**/
	private class ButtonListener implements ActionListener
	{
		private MenuWindow MainMenu;
		ButtonListener(MenuWindow thisMenu)
		{
			MainMenu = thisMenu;
		}
		ButtonListener()
		{
			MainMenu = null;
		}
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();
			if( command.equals( "Play Game"))
			{
				// will need to have a load game popup or new window
				menuFrame.dispose();
				GameWindow game = new GameWindow();
				
			}else if(command.equals( "Build Game"))
			{
				JFrame buildFrame = new JFrame("Build");
				buildFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
				BuildWindow panel = new BuildWindow(buildFrame, MainMenu);
				buildFrame.pack();
			}else if(command.equals( "Exit To Desktop"))
			{
				int result = JOptionPane.showConfirmDialog(menuFrame, "Are you sure you want to exit to desktop?");
				if (result == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}else if(command.equals( "Help"))
			{
				getHelp();
			}else if(command.equals( "About"))
			{
				getAbout();
			}else if(command.equals( "Settings"))
			{
				JFrame settingsFrame = new JFrame("Settings");
				settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				settingsGUI panel = new settingsGUI(settingsFrame);
				settingsFrame.pack();
				settingsFrame.setVisible(true);
			}
		}  
	}

	/**GetHelp And GetAbout
	* Creates new windows to dispay info
	* J.B.
	**/
	public void setVisible(boolean sight)
	{
		menuFrame.setVisible(sight);
	}
	/**GetHelp And GetAbout
	* Creates new windows to dispay info
	* J.B.
	**/
	private void getHelp()
	{
		JFrame helpFrame = new JFrame("Help");
		helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel helpPanel = new JPanel();
		
		helpFrame.setPreferredSize(new Dimension(width/4,height/4));
		helpFrame.setLocation(width/3,height/4);
		
		helpPanel.add(new JLabel("This is Where you will get Help..."));
		helpFrame.add(helpPanel);
		helpFrame.pack();
		helpFrame.setVisible(true);
	}
	private void getAbout()
	{
		JFrame AboutFrame = new JFrame("About");
		AboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel AboutPanel = new JPanel();
		
		AboutFrame.setPreferredSize(new Dimension(width/4,height/4));
		AboutFrame.setLocation(width/3,height/4);
		
		AboutPanel.add(new JLabel("This is Where you will get Info..."));
		AboutFrame.add(AboutPanel);
		AboutFrame.pack();
		AboutFrame.setVisible(true);
	}
}
