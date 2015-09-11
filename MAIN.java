/* 
Name: main 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/10/15
Contributors:
 */

import javax.swing.JFrame; 

public class MAIN
 {
	/**main
	* create frame, create panel, display;
	* JoshuaBecker
	**/
	public static void main(String[] args)
    {       
	JFrame menuFrame = new JFrame("'Name' Menu");
	menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
    MenuPanel panel = new MenuPanel(menuFrame); 
    menuFrame.pack();
	menuFrame.setVisible(true);
	
    }
}