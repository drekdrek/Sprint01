package Project01;

/**
 * Assigns if the person made was a warrior(soldier) or a wizard(tricky).
 */
public enum PeopleType
{
    warrior ("Solder"),
    wizard  ("Tricky");

    private String description;

    /**
     * Constructor, takes a string and puts it in Description.
     * @param types
     */
    PeopleType (String types)
    {
        description = types;
    }


    /**
     * Returns the description, made for accessing.
     * @return
     */
    public String getDescription()
    {
        return description;
    }
}
