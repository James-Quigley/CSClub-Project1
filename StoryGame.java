import java.util.*;

/* 
The following is the driver for the Story Game. 
It's broken down to handle the Console text prompts and instantiate story Slide objects as they're created. 
*/

public class StoryGame{

	public static void main(String[] args){
	
		boolean quit = false;
	
		while(quit == false){
			printMenu();
			menuChoice();
		}
	}
	
	public static void printMenu(){
	
		System.out.println("1 - Create a New Card");
		System.out.println("2 - Find Card via index");
		System.out.println("3 - Quit");
	}
	
	public static void menuChoice(){
	
		Scanner userInput = new Scanner(System.in);
	
		System.out.println("\nEnter the appropriate menu option: ");
		int input = userInput.nextInt();
		
		List<Slide> slideList = new List<Slide>();
		
		switch(input){
		
			case 1:	Slide s1 = new Slide();
					System.out.println("\nNew Slide Created.\n");
					break;
					
			case 2: System.out.println("Enter index ID: ");
					int indexID_LookUp = userInput.nextInt();
					System.out.println(s1.getText(indexID_LoopUp)); // This is hard-coded based on the object being locked in. This will need to be changed to correspond to LinkedList or ArrayList.
					break;

			case 3: System.out.println("\nQuitting...");
					System.exit(0);
					break;
					
			default:System.out.println("Unknown Problem. Enter again.");
					
		
		}
	}

}