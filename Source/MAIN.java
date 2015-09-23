/* 
Name: main 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/17/15
Contributors:
 */

import javax.swing.JFrame; 

public class MAIN
 {
	/**main
	* open the Menu
	* J.B.
	**/
	public static void main(String[] args)
    {
		openMenu();// now when we just need to work on the slide.java we can comment this out with one line.
    }

	/**openMenu
	* create frame, create panel, display;
	* J.B.
	**/
	public static void openMenu()
	{
		JFrame menuFrame = new JFrame("Main Menu");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuPanel panel = new MenuPanel(menuFrame); 
		menuFrame.pack();
		menuFrame.setVisible(true);
	}
}
