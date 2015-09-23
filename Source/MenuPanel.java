/* 
Name: Menu Panel 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/17/15
Contributors:
 */

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.JFrame;

public class MenuPanel extends JPanel implements GUIInterface
{
    private JButton playGame;
	private JButton buildGame;
	private JButton exit;
    private JLabel label; 
	private JFrame menuFrame;
	
    public MenuPanel(JFrame incMenuFrame)// constructer
    {
		menuFrame = incMenuFrame;
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// geting size of screen
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		menuFrame.setLayout(new FlowLayout());
		menuFrame.setBackground(Color.lightGray);
		menuFrame.setPreferredSize(new Dimension(width/2, height/2));
		menuFrame.setLocation(width/4, height/4); // centering window
		
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
		menuFrame.add(buildGame);
		menuFrame.add(playGame);
		menuFrame.add(exit);
	}
	
	/**buildComponents
	* set up components and there attributes.
	* J.B.
	**/
	public void buildComponents()
	{
		// will need in the future...
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
	}

	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	* J.B.
	**/
	private void addActionListeners()
	{
		buildGame.addActionListener(new ButtonListener());
		playGame.addActionListener(new ButtonListener());
		exit.addActionListener(new ButtonListener());
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
			if( command.equals( "Play Game"))
			{
				menuFrame.dispose();
				JFrame gameFrame = new JFrame("'Name' Game");
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
				GamePanel panel = new GamePanel(gameFrame);  
				gameFrame.pack();
				gameFrame.setVisible(true);
				
			}else if(command.equals( "Build Game"))
			{
				menuFrame.dispose();
				JFrame buildFrame = new JFrame("'Name' Build");
				buildFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
				BuildPanel panel = new BuildPanel(buildFrame);
				buildFrame.pack();
				buildFrame.setVisible(true);
			}else if(command.equals( "Exit To Desktop"))
			{
				int result = JOptionPane.showConfirmDialog(menuFrame, "Are you sure you want to exit to desktop?");
				if (result == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		}  
	}
}
