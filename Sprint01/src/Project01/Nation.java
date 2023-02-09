package Project01;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import Project01.Tribe;
import Project01.People;


public class Nation
{
    private int nationLifePoints;
    public static int nationCount = 0;
    private String nationName;
    private ArrayList<Tribe> tribes = new ArrayList<>();
    private ArrayList<People> population = new ArrayList<>();
    private ArrayList<People> livingPopulation = new ArrayList<>();

    /**
     * The Nation constructor
     * Creates a nation with a given name and lifePoints
     * A nation contains 5 Tribes
     * @param name
     * @param lifePoints
     */
    public Nation(String name, int lifePoints)
    {
        nationCount++;
        nationName = name;
        nationLifePoints = lifePoints;
        for(int i = 0; i < 5; i++)
        {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 5));
        }
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    /**
     *
     * @return if the nation is alive
     */
    public Boolean isNationAlive()
    {
        return (nationLifePoints > 0);
    }

    /**
     *
     * @return the population of the nation
     */
    public ArrayList<People> getNationPopulation()
    {
        nationLifePoints = 0;
        livingPopulation.clear();
        for(int tribe = 0; tribe < this.tribes.size(); tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                //System.out.println(tribes.get(tribe));
                livingPopulation.addAll(tribes.get(tribe).getLivingTribeMembers());
                //System.out.println(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += tribes.get(tribe).getTribeLifePoints();
            }
        }
        return livingPopulation;
    }

    /**
     *
     * @return the name of the nation
     */
    public String getNationName()
    {
        return nationName;
    }

    /**
     * prints out the status of the tribe
     */
    public void printTribesStatus()
    {
        for(int tribe = 0; tribe < 1; tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                System.out.print(tribes.get(tribe).getTribeName() + " is alive and has ");
                System.out.println(tribes.get(tribe).getTribeSize() + " members.");
            }
            else
            {
                System.out.println(tribes.get(tribe).getTribeName() + " is dead.");
            }
        }
    }

    /**
     *
     * @return the nation's tribe's statuses
     */
    public String toString()
    {
        String result = "\0";
        result = nationName;
        for(int i = 0; i < tribes.size(); i++)
        {
            result = result + '\n' + tribes.get(i).toString();

        }
        result = result + '\n';
        return result;
    }
}
