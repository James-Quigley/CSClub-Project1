/* 
Name: Game Panel 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/17/15
Contributors:
 */

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.JFrame;

public class GamePanel extends JPanel implements GUIInterface
{
	private JButton exit;
    private JLabel label; 
	private JFrame gameFrame;
	
    public GamePanel(JFrame incGameFrame)// constructer
    {
		gameFrame = incGameFrame;
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// geting size of screen
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		gameFrame.setLayout(new FlowLayout());
		gameFrame.setBackground(Color.lightGray);
		gameFrame.setPreferredSize(new Dimension(width/2, height/2));
		gameFrame.setLocation(width/4, height/4); // centering window
		
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
		gameFrame.add(label);
		gameFrame.add(exit);
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
		label = new JLabel(" Work In Progress");
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
			if(command.equals( "Exit To Desktop"))
			{
				int result = JOptionPane.showConfirmDialog(gameFrame, "Are you sure you want to exit to desktop?");
				if (result == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		}  
	}
}
