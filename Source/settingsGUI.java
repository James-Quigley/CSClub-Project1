/* 
Name: Settings 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/23/15
Contributors:
 */

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.JFrame;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class settingsGUI extends JPanel implements GUIInterface
{
	private JFrame settingsFrame;
	private JLabel messageLabel;
	private int width;
	private int height;
	
    public settingsGUI(JFrame theFrame)// constructer
    {	
		settingsFrame = theFrame;
		
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
		settingsFrame.add(messageLabel);
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
		
		settingsFrame.setPreferredSize(new Dimension(width/3, height/3));
		settingsFrame.setLocation(width/4, height/4); // centering window
		settingsFrame.setResizable(false);
	}
	
	/**createComponents
	* creates components and gives them
	* default values.
	* J.B.
	**/
	public void createComponents()
	{
		messageLabel = new JLabel(" This is were the settings go...");
	}

	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	* J.B.
	**/
	private void addActionListeners()
	{
		
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
		}  
	}
}
