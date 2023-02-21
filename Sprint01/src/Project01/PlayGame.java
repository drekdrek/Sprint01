package Project01;
import Project01.Nation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

/**
 * This class runs all the overhead operations of playing a game
 */
public class PlayGame
{

    ArrayList<Nation> allLivingNations = new ArrayList<>();
    ArrayList<People> worldLivingPopulation = new ArrayList<>();
    Random generator;

    /**
     * Makes a random generator based on the date.
     */
    public PlayGame()
    {
        Date seed = new Date();
        generator = new Random(seed.getTime());
    }

    /**
     * Updates the current list of people alive
     * @param nations, the two nations and all their tribes and people
     */
    public void getWorldLivingPopulation(ArrayList<Nation> nations)
    {
        // add all living people to world list
        worldLivingPopulation.clear();
        //System.out.println(allLivingNations);
        for(int nation = 0; nation < nations.size(); nation++)
            //System.out.println(nations.get(nation));
            worldLivingPopulation.addAll(nations.get(nation).getNationPopulation());
        //System.out.println(worldLivingPopulation);
    }


    /**
     * Updates the list of living nations when a nation no longer has living people.
     * @param nations, the two nations and all their tribes and people
     */
    public void getAllLivingNations(ArrayList<Nation> nations)
    {
        getWorldLivingPopulation(nations);
        allLivingNations.clear();
        for(int nation = 0; nation < nations.size(); nation++)
        {
            if(nations.get(nation).isNationAlive())
            {
                allLivingNations.add(nations.get(nation));
            }
        }
        //System.out.print(allLivingNations);
    }


    /**
     * Starts an encounter where p1 and p2 will attack each other if they aren't part of the same nation. Each person
     * does an average of 5 damage with a range of 1 to 20.
     * @param p1, Person 1
     * @param p2, Person 2
     */
    public void encounter(People p1, People p2)
    {
        // need to fix this to take strategies into account.
        if(p1.getNation() != p2.getNation())
        {
            System.out.print(p1 + " encounters " + p2);
            int p1Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            int p2Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            p1.reduceLifePoints(p1Damage);
            p2.reduceLifePoints(p2Damage);

            System.out.println("\t\tp1 damage is " + p1Damage + ". p2 damage is " + p2Damage + ".");
        }
    }


    /**
     * Plays one round of the game. One round consists of encounters between two different people until either the
     * number of encounter excesses the world living populations or one nation loses all it's people.
     * @param nations, the two nations and all their tribes and people
     * @return true if the game has ended, false if the game is continuing.
     */
    public Boolean playOneRound(ArrayList<Nation> nations)
    {
        getAllLivingNations(nations);
        int index = 0;
        while((allLivingNations.size() > 1) && (index < worldLivingPopulation.size()))
        {
            //encounter(worldLivingPopulation.get(pointers.get(index)), worldLivingPopulation.get(pointers.get(index+1)));
            //System.out.println((worldLivingPopulation.size()-1) + "\t" + limit + "\t" + index + "\t" + (index+1));
            int p1Index = generator.nextInt(worldLivingPopulation.size());
            int p2Index;
            do
                p2Index = generator.nextInt(worldLivingPopulation.size());
            while(p1Index == p2Index);
            encounter(worldLivingPopulation.get(p1Index), worldLivingPopulation.get(p2Index));
            getAllLivingNations(nations);
            if(allLivingNations.size() < 2)
                break;
            index = index + 1;
        }

        return (allLivingNations.size() < 2);


    }

    /**
     * Gets the winner of the game
     * @return No Winner if both nations are dead, otherwise returns the first Nation in the list
     */
    public String getWinner()
    {
        if (allLivingNations.size() == 0)
            return "No Winner!";
        else
            return allLivingNations.get(0).getNationName();
    }
}
