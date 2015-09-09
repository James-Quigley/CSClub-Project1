import java.util.Scanner;

public class Slide{

	int id;
	private String storyText;
	private static int total_ID_Numbers = 0;

	public Slide(){		// Constructor

		id = total_ID_Numbers += 1;  // total_ID_Numbers is independent of the object. This object will not know that other objects were made until it checks this variable. The root should always be 1. 
		inputTxt();

	}

	public String getText(){
	
		return storyText;
	
	}
	
	public int getId(int x){
	
		return id;
	
	}
	
	public void setText(String storyText){
	
		this.storyText = storyText;
	
	}
	
	public void inputTxt(){
	
		Scanner userInput = new Scanner(System.in);
	
		System.out.println("Enter the text you'd like to enter for this slide.");
		String input = userInput.nextLine();
		
		storyText = input;
		
	}
	
}



/* The Driver.java file will be the "gui" from where people will choose from a menu to build a new story slide.
When
*/