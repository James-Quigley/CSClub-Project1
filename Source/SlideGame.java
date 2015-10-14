// JL: Importing some handy libraries (java.util.* for ArrayLists and Scanner, primarily).
import java.io.*; 	
import java.util.*;


/*
// Jacob Leonard - Poly CS Club - Project 1
// Contributors: 
//
// DESCRIPTION: This is rudimentary driver class for the Slide.java file that David had originally created (David, I frankensteined yours quite a bit).
*/

public class SlideGame{

	private static ArrayList<Slide> slideList = new ArrayList<Slide>();

	public static void main(String[] args){

		while(true){ // JL: Endless loop of the main-menu
		
			printMenu();
			menuChoice();
		}
	}
	
	public static void printMenu(){
	
		System.out.println("1 - Create a New Card"); // Generate a blank card. 
		System.out.println("2 - Edit Cards"); // JL: Display the ArrayList contents and choose a specific card to edit from this point.
		System.out.println("3 - Read a Slide"); // JL: Just for testing purposes, this will pull a list of Slides and subsequently call obj.getTitle, getText, getChoiceTxt or something of that nature. 
		System.out.println("4 - Quit");
	}
	
	public static void menuChoice()
	{
		
	}
}

	public static void selectSlide(){
		
		System.out.println("\n SELECT THE CARD YOU WISH TO EDIT: \n");
		System.out.println(slideList.size());
		for(Slide s : slideList){ // JL: By default perhaps this will just print the object reference at the index within the ArrayList (or nothing at all which is probably better): 
			
			int i = slideList.indexOf(s);
			System.out.println("Card at: " + i + " - " + s);
		}
	}
	
	public static void editMenuChoice(){ // -JL: Select the card you want to edit.
		
		System.out.println("\n Choose the Card You want to Edit: ");
		Scanner userInput = new Scanner(System.in); 
		int input = userInput.nextInt();
		Slide currentSlide = slideList.get(input);

		System.out.println("\nEDIT:");
		System.out.println("1 - Title");
		System.out.println("2 - Story Text");
		System.out.println("3 - Add Choice\n");
		
		input = userInput.nextInt();

		switch(input){
		
			case 1: editTitle(currentSlide);
					break;
			
			case 2: editText(currentSlide);
					break;
					
			case 3: selectSlide();
					System.out.println("Choose the slide this choice points to: ");
					int slideChoice = userInput.nextInt();
					Slide s = slideList.get(slideChoice);
					System.out.println("Enter Choice Text: ");
					String choiceTxt = userInput.nextLine(); // -JL: Temporary messy solution to clear \n from nextInt buffer. 
					choiceTxt = userInput.nextLine();
					currentSlide.addChoice(choiceTxt, s);
					break;
						
					// -JL 1: Choose slide to add it to, 2: add choice text
					
			default: System.out.println("Re-enter");
		
		}
	
		/*JL: I'm unsure what level this will all take place, but this is what I want for the first iteration, here (Pseudo):
		- Select object reference in slideList that corresponds to user input.
		- EDIT SLIDE MENU:
		
		
		- 1. Edit Slide Title
		- 2. Edit Slide Text
		- 3. Add Choice (Ensure you have the index of the other card you want this choice to go to for now). 
		*/
	}
	
	public static void editTitle(Slide slide){
	
		System.out.println("Enter Title: ");
		Scanner userInput = new Scanner(System.in); 
		String input = userInput.nextLine();
		slide.setTitle(input);
	
	}
	
	public static void editText(Slide slide){
	
		System.out.println("Enter story text: ");
		Scanner userInput = new Scanner(System.in); 
		String input = userInput.nextLine();
		slide.setText(input);
	
	}
	
	public static void readSlide(Slide currentSlide){ // -JL: We can use the index value to find the Slide we want since it's based on menu-input. But when jumping from one slide to the next Slide via choice will have to be different. Leaving this menu up allows you to jump into a story at any point.
	

		Scanner userInput = new Scanner(System.in); 
		int input = userInput.nextInt();
	
		System.out.println("--------------------------------------------------------------");
		System.out.println("----" + currentSlide.getTitle() + "----");
		System.out.println("--------------------------------------------------------------");
		System.out.println(currentSlide.getText());
		System.out.println("--------------------------------------------------------------");
		System.out.println("-------------------------CHOICES------------------------------");
		currentSlide.displayChoices();
		System.out.println("\n\n");
		System.out.println("Select a choice: "); 
	
		int userChoice = userInput.nextInt();
		Slide nextSlide = currentSlide.getChoice(userChoice);
		readSlide(nextSlide);
		
		// JL: If no choices, pause system and press enter to return to the main menu. 
		

	}
}