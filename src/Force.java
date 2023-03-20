import java.util.*;
import java.util.ArrayList;

/**
 * Write a description of class Force here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Force
{
    private String reference;
    private String name;
    private int fee;
    private int strength;

    /**
     * Constructor - Constructs a Force
     * @param ref - Reference
     * @param name - Name
     * @param fee - Fee
     * @param strength - Strength
     */
    public Force(String ref, String name, int fee, int strength)
    {
        reference = ref;
        this.name = name;
        this.fee = fee;
        this.strength = strength;
    }

    /**
     * Returns Reference
     */
    public String getReference()
    {
        return reference;
    }

    /**
     * Returns Name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns Fee
     */
    public int getFee()
    {
        return fee;
    }

    /**
     * Returns Strength
     */
    public int getStrength()
    {
        return strength;
    }

    /**
     * toString
     */
    public String toString()
    {
        String s;
        s = "\nReference: " + reference + "\nForce Type: " + getClass() + "\nName: " + name + "\nFee: " + fee + "\nStrength: " + strength;
        return s;
    }


}