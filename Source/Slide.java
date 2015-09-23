import javax.swing.JOptionPane;
import java.util.*;
import java.io.*; 	

/* 
Name: Slide.java
Author: David L.
Create On: 9/9/15(?)
Updated On: 9/23/15
Contributors: Jake L.
About: Will eventually be the primary Slide class utilized for our story-maker. 
 */

public class Slide implements Serializable {

	static int MAX_CHOICES = 4;
	private int id; // -JL: Added id value to object
	private static int total_ID_Numbers; //-JL: Added static id number tracker
	String slideTitle;
	String slideText;
	String choiceTitle; // -JL: Will need to fix this, as it means anywhere this Slide is the choice result, it must be the same choice description. Which means you cannot have difference choice descriptions point to the same slide at the moment. 
	int numberOfChoices;
	private ArrayList<Slide> choices = new ArrayList<Slide>(); //-JL: Choices (references to other slides) stored here
	
	public Slide(){
		slideTitle = "";
		slideText = "";
		choiceTitle = "";
		numberOfChoices = 0;
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
	
	public int getID(){
		return id;
	}

	public void setChoiceTxt(String txt){
		choiceTitle = txt;
	}
	public Slide getChoice(int index){
		return choices.get(index);
	}
	
	public void displayChoices(){
	
		for(Slide choice : choices){
			System.out.println(choices.indexOf(choice) + " - " + choice.getChoiceText());
		}
	}
	
	public void addChoice(String text, Slide nextSlide){  // -JL Commented out for the time-being while testing with the Slide class itself and not presently worrying about choices just yet.
		if (numberOfChoices < MAX_CHOICES){
			nextSlide.setChoiceTxt(text);
			choices.add(nextSlide);
			numberOfChoices++;
		}
		else{System.out.println("No more choices.");}
	}
	
	//removes a choice and shifts choices further up in the array down.
	//deletes the last element in the array.
	
	public void deleteChoice(int choiceNumber){

	}
	
	//this is a private function for displaySlide
	private String getChoiceText(){
	
		return choiceTitle;
	}
	
	/*
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
		
	}*/
}

/*-JL: TO DO:

Add Choice Functionality.

1. Select Slide
	a. Add Choice - PROMPT: Choice Text, Slide reference. 
	
1. Read cards!

*/

	
