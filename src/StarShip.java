
/**
 * Starship is a sub class of the parent class Force
 * Author - Luke Lovegrove
 */
public class Starship extends Force
{
    private int laserCannons;
    private int photonTorpedoes;

    /**
     * Constructor for objects of class Starship
     */
    public Starship(String ref, String name, int fee, int strength, int laser, int photon)
    {
        super(ref, name, fee, strength);
        laserCannons = laser;
        photonTorpedoes = photon;
        fee = laser * 30;
        strength = (photon * 5) + (laser * 10);
    }

    /**
     * Returns total lasers on Starship
     */
    public int getLaser()
    {
        return laserCannons;
    }

    /**
     * Returns total Photon Torpedoes on Starship
     */
    public int getPhoton()
    {
        return photonTorpedoes;
    }

    /**
     * Returns a string of information about a Wing including reference, name, fee, strength and number of Laser Cannons and Photon Torpedoes
     */
    public String toString()
    {
        String s;
        s = "\nReference: " + getReference() + "\nForce Type: " + getClass().getSimpleName() + "\nName: " + getName() + "\nFee: " + getFee() + "\nStrength: " + getStrength() + "\nLaser Cannons: " + laserCannons + "\nPhoton Torpedoes: " + photonTorpedoes;
        return s;
    }
}
