
/**
 * Wing is a sub class of the parent class Force
 * Author - Luke Lovegrove
 */
public class Wing extends Force
{
    private int strikers;

    /**
     * Constructor for objects of class Wing
     */
    public Wing(String ref, String n, int f, int stre, int stri)
    {
        super(ref, n, 200, stre);
        strikers = stri;
        stre = strikers * 20;
    }

    /**
     * Returns total Strikers on Wing
     */
    public int getStrikers()
    {
        return strikers;
    }

    /**
     * Returns a string of information about a Wing including reference, name, fee, strength and number of Strikers
     */
    public String toString()
    {
        String s;
        s = "\nReference: " + getReference() + "\nForce Type: " + getClass().getSimpleName() + "\nName: " + getName() + "\nFee: " + getFee() + "\nStrength: " + getStrength() + "\nStrikers: " + strikers;
        return s;
    }
}
