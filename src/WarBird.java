
/**
 * WarBird is a sub class of the parent class Force
 * Author - Luke Lovegrove
 */
public class WarBird extends Force
{
    private boolean cloaking;

    /**
     * Constructor for objects of class WarBird
     */
    public WarBird(String ref, String name, int fee, int strength, boolean cloak)
    {
        super(ref, name, fee, strength);
        cloaking = cloak;
        if (cloak == true)
        {
            fee = 400;
        }
        else
        {
            fee = 300;
        }
        //strength = see Appendix A
    }

    /**
     * Returns True or False depending on if the Wing has a Cloaking device
     */
    public boolean getCloaking()
    {
        return cloaking;
    }

    /**
     * Returns a string of information about a Wing including reference, name, fee, strength and whether it is cloaked
     */
    public String toString()
    {
        String s;
        s = "\nReference: " + getReference() + "\nForce Type: " + getClass().getSimpleName() + "\nName: " + getName() + "\nFee: " + getFee() + "\nStrength: " + getStrength() + "\nCloaking: " + cloaking;
        return s;
    }
}
