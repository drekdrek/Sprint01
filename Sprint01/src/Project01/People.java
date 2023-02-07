package Project01;

import Project01.PeopleType;

/**
 *Stores information pertaining to the people of a nation/tribes. Things such as their nation, tribe, description,
 * etc. The values are private and cannot be accessed directly.
 */
public class People
{
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    private String myDescription;
    private int myLifePoints;


    /**
     * The Constructor for 'People'
     * Makes the people for each tribe/nation using the passed parameters, nation, tribe, person and the assigned life points.
     * @param nation
     * @param tribe
     * @param person
     * @param lifePoints
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
    }

    /**
     * Returns the type of individual(wizard/warrior) that said person is, callable from public code.
     * @return
     */
    public PeopleType getType()
    {
        return me;
    }

    /**
     * Returns what tribe the individual is from, callable in public code.
     * @return
     */
    public String getTribe()
    {
        return myTribe;
    }

    /**
     * Returns which nation the individual is from, callable in public code
     * @return
     */
    public String getNation()
    {
        return myNation;
    }

    /**
     * A check if the person is still alive by returning a true or false based on if the life points are above 0,
     * callable from public.
     * @return
     */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     * Returns specifically how many life points the person has, callable from public code.
     * @return
     */
    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * It doesn't do anything. Everything is commented out. Why is this here tho?
     * Would normally take care of what would happen when meeting another person. Peaceful or violent.
     * @param otherPerson
     */
    public void encounterStrategy(People otherPerson)
    {
        if(myNation == otherPerson.getNation())
        {
            // There will be an ugly confrontation
        }
        else
        {
            // there will be a peaceful confrontation
            // warriors - warrior ignore each other if different tribes increase life points
            // healer - healer ignore each other
            // healer - warrior - healer can heal warrior. Heals warrior from same tribe better
        }
    }


    /**
     * A public functions which takes care of reducing a person's life points as they take damage.
     * @param points
     */
    public void reduceLifePoints(int points)
    {
        myLifePoints = myLifePoints - points;
    }


    /**
     * Returns a string wit the person's information.
     * @return
     */
    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }
}

