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

public class Slide implements Serializable  {

	private int id; // -JL: Added id value to object
	private static int total_ID_Numbers; //-JL: Added static id number tracker
	private String slideTitle;
	private String slideText;
	private String m_ChoiceText[];
	private Slide m_NextSlides[];
	private int m_SlideCount;
	
	public Slide()
	{
		slideTitle = "";
		slideText = "";
		m_ChoiceText = new String[4];
		m_NextSlides = new Slide[4];
		for(int i = 0; i < 4; i++)
		{
			m_ChoiceText[i] = "";
			m_NextSlides[i] = null;
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
	
	public int getID(){
		return id;
	}
	
	public void setNextChoice(Slide nextSlide, String text, int index)
	{
		m_NextSlides[index] = nextSlide;
		m_ChoiceText[index] = text;
	}
	
	public Slide getChoiceAtIndex(int index)
	{
		return m_NextSlides[index];
	}
	
	public String getChoiceTitleAtIndex(int index)
	{
		return m_NextSlides[index].getTitle();
	}
	
	public String getChoiceTextAtIndex(int index)
	{
		return m_ChoiceText[index];
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

	
