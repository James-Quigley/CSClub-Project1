/* 
Name: Game
Author: James Quigley
Create On: 9/15/15
Updated On: 
Contributors:

Description: Game class that holds all of the slide objects in order to organize them
and to have the ability to save the game.
 */
import java.util.*;
public class Game{
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

	//Returns -1 if failure to save
	public int saveGame(String savePath){
		int success = -1;
		//Create or open save file
		//Write all necessary data
		//Change success flag
		return success;
	}

	//Returns -1 if failure to load
	public int loadGame(String savePath){
		int success = -1;
		String gameName = "";
		List<Slide> slideList = new ArrayList<Slide>();
		//Open save file
		//Read all data
		//Change success flag
		name = gameName;
		gameSlides = slideList;
		return success;
	}

	//Add slide object to list of slides
	public void addSlide(Slide slide){
		gameSlides.add(slide);
	}

	//Remove first instance of slide from list of slides
	public void removeSlide(Slide slide){
		gameSlides.remove(slide);
	}

	//Returns number of slide objects in the list
	public int getNumberOfSlides(){
		return gameSlides.size();
	}
}