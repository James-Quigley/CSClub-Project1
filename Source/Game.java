/* 
Name: Game
Author: James Quigley
Create On: 9/15/15
Updated On: 
Contributors:
Joshua Becker.

Description: Game class that holds all of the slide objects in order to organize them
and to have the ability to save the game.
 */
import java.util.*;
import java.io.Serializable;
public class Game implements Serializable{
	private String name;
	private List<Slide> gameSlides;

	public Game(){
		name = "";
		gameSlides = new ArrayList<Slide>();
	}

	public Game(String gameName, List<Slide> slideList){
		name = gameName;
		gameSlides = slideList;
	}

	public String getName(){
		return name;
	}

	public void setName(String gameName){
		name = gameName;
	}

	public List<Slide> getGameSlides(){
		return gameSlides;
	}

	public void setGameSlides(List<Slide> slideList){
		gameSlides = slideList;
	}

	//Add slide object to list of slides
	public void addSlide(Slide slide){
		gameSlides.add(slide);
	}
	
	public void addSlideAtIndex(Slide slide, int index){
		gameSlides.add(index, slide);
	}
	
	//Remove first instance of slide from list of slides
	public void removeSlide(Slide slide){
		gameSlides.remove(slide);
	}

	//Returns number of slide objects in the list
	public int getNumberOfSlides(){
		return gameSlides.size();
	}
	
	// gets a slide at a certain locaion
	public Slide getSlideAtIndex(int index){
		return gameSlides.get(index);
	}
	
	public void updateSlide(Slide newSlide)
	{
		if(gameSlides.contains(newSlide))
		{
			int index = gameSlides.indexOf(newSlide);
			gameSlides.remove(index);
			gameSlides.add(index, newSlide);
		}else
		{
			gameSlides.add(newSlide);
		}
	}
}