import javax.swing.JOptionPane;

public class Slide {
	static int MAX_CHOICES = 4;
	String slideTitle;
	String slideText;
	int numberOfChoices;
	Choice[] slideChoice;
	
	public Slide(String title, String text) {
		slideTitle = title;	
		slideText = text;
		slideChoice = new Choice[MAX_CHOICES];
		numberOfChoices = 0;
		
		//sets up a blank choice array
		for (int i = 0; i < MAX_CHOICES; i++){
			slideChoice[i] = new Choice("", null);
		}
	}
	
	public void setTitle(String title){
		slideTitle = title;
	}
	
	public String getTitle(){
		return slideTitle;
	}
	
	public void setText(String text){
		slideText = text;
	}
	
	public String getText(){
		return slideText;
	}
	
	public void addChoice(String text, Slide nextSlide){
		if (numberOfChoices < MAX_CHOICES){
			slideChoice[numberOfChoices] = new Choice(text, nextSlide);
			numberOfChoices ++;
		}
	}
	
	//removes a choice and shifts choices further up in the array down.
	//deletes the last element in the array.
	public void deleteChoice(int choiceNumber){
		slideChoice[choiceNumber].setText("");
		slideChoice[choiceNumber].setNextSlide(null);
		numberOfChoices --;
		for (int i = choiceNumber; i < numberOfChoices - 1; i ++){
			slideChoice [i] = slideChoice[i + 1];
		}
		slideChoice[numberOfChoices].setText("");
		slideChoice[numberOfChoices].setNextSlide(null);
	}


	//this is a private function for displaySlide
	private String[] getChoiceTexts(){
		String [] choiceText = new String[numberOfChoices];
		for (int i = 0; i < numberOfChoices; i ++){
			choiceText[i] = slideChoice[i].getText();
		}
		return choiceText;
	}
	
	
	//using code from http://www.java2s.com/Tutorial/Java/
	//	0240__Swing/Todisplaysadialogwithalistofchoicesinadropdownlistbox.htm
	public void displaySlide(String[] choices){
		String text = getText();
		String title = getTitle();
		String[] choiceTexts = getChoiceTexts();
		
		
		String input = (String) JOptionPane.showInputDialog(null, text, title, 
				JOptionPane.QUESTION_MESSAGE, null, choiceTexts, choiceTexts[0]);
		System.out.println(input);
	}
	
	//A choice operates like a node. It's got text and a slide that it points to.
	private class Choice {
		String choiceText;
		Slide choiceNextSlide;
		
		public Choice (String text, Slide nextSlide){
			choiceText = text;
			choiceNextSlide = nextSlide;
		}
		
		public void setText(String text){
			choiceText = text;
		}
		
		public String getText(){
			return choiceText;
		}

		public void setNextSlide(Slide slide){
			choiceNextSlide = slide;
		}
		
		public Slide getNextSlide(){
			return choiceNextSlide;
		}
		
	}
	
}