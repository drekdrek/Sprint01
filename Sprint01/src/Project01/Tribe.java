package Project01;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import Project01.People;
import Project01.PeopleType;

/**
 * This class automates the creation and naming of groups of people, storing them in tribes. It also manages the life
 * status of said people.
 */
public class Tribe
{
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();

    /**
     * Makes a new tribe and its people. Every odd person added is a wizard and every even person added is a warrior.
     * Both types of people have life points equal to the tribe's base life points divided by two. Finally, it adds all
     * members to the list of living members because they're all alive when the tribe is created.
     * @param nation, the name of the nation the tribe belongs to
     * @param tribe, the name of the newly created tribe
     * @param lifePoints, the base life points of the tribe, used to create the people.
     */
    public Tribe(String nation, String tribe, int lifePoints)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        for(int i = 0; i < 2; i++)
            if(i % 2 == 0)
                members.add(new People(nationName, tribeName, PeopleType.warrior, tribeLifePoints / 2));
            else
                members.add(new People(nationName, tribeName, PeopleType.wizard, tribeLifePoints / 2));
        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

    /**
     * Remakes both the tribe life points and list of living members by looping through the members.
     * @return the list of the current living members
     */
    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }
    // Commented out because the toString does the same thing
    /*
    public void printMembers()
    {
        for(int i = 0; i < 2; i++)
        {
            System.out.println(people.get(i));
        }
    }
*/


    public int getTribeSize()
    {
        return livingMembers.size();
    }

    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }


    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    /**
     * Returns the tribe name.
     * @return the name of the tribe as a string
     */
    public String getTribeName()
    {
        return tribeName;
    }

    /**
     * Outputs the name of the tribe and all the members of the tribe.
     * @return a string containing the above information
     */
    public String toString()
    {
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}
