/* 
Name: Game
Author: James Quigley
Create On: 9/23/15
Updated On: 
Contributors:

Description: Class that can save the 
 */
import java.util.*;
import java.io.*;
public class LSGame{

	public static void saveGame(Game gameObject, String savePath) throws IOException{
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(savePath));

		objectOutputStream.writeObject(gameObject);
        objectOutputStream.close();
	}

	public static Game loadGame(String savePath) throws IOException{
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(savePath));
		Game gameRead = new Game();
		try{
        	gameRead = (Game) objectInputStream.readObject();
        }
        catch(Exception e){
        	System.out.println(e);
        }
        objectInputStream.close();

        return gameRead;
	}
}