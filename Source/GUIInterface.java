/* 
Name: GUI Interface.
Author: Joshua Becker
Create On: 9/17/15
Updated On: 9/17/15
Contributors:
About: This defines the interface to a GUI ADT
	   in our Project.
 */
public interface GUIInterface
{
    /**addElements
	* add components to panels and
	* adds panels to Frame
	* J.B.
	**/
	public void addElements();
	
	/**buildComponents
	* set up components and there attributes.
	* J.B.
	**/
	public void buildComponents();
	
	/**createComponents
	* creates components and gives them
	* default values.
	* J.B.
	**/
	public void createComponents();
	
	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	* J.B.
	**/
}