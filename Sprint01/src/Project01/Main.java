package Project01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import Project01.Nation;
import Project01.Tribe;
import Project01.PlayGame;


public class Main {


    /**
     * The main code that takes care of playing the game itself.
     * Starts the game with 2000 points, and the nations are then created as an array which creates tribes and
     * by extension, people.
     * It creates the nations "Minions" and "Idiots" and goes into a for loop for 40 rounds.
     * Each round prints out what round number it is and plays the game. When a nation is returned as a winner,
     * it prints out the message "There is a winner!" and hits a break which stops no matter how many rounds have passed.
     * It then announces the winning nation, printing it out, and ends the code.
     * @param args
     */
    public static void main(String[] args)
    {
       int gameLifePoints = 2000;
       ArrayList<Nation> nations = new ArrayList<>() ; // nations create tribes create people
       PlayGame game = new PlayGame();
	   nations.add(new Nation("Idiots", (gameLifePoints / 2)));
	   nations.add(new Nation("Minions", (gameLifePoints) / 2));
	   // could add and delete nations. return number of nations + 1 from add and number of nations -1 from remove.
	   for(int i = 0; i < 40; i++)
       {
           System.out.println("Round number: " + i);
           if (game.playOneRound(nations))
           {
               System.out.println("There is a winner!");
               break; // game over
           }
       }

	   System.out.println("The winning nation is " + game.getWinner() + ".");
    }
}
