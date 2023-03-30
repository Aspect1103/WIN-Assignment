package cwk4;

/**
 * Represents a force in the United Forces Fleet (UFF) which can partake
 * in battles.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 23/03/2023
 */
public class Force {
    private final String reference;
    private final String name;
    private final int fee;
    private final int strength;
    private final boolean inUFF;
    private final boolean inASF;
    private final boolean isDestroyed;

    /**
     * Constructs a force object.
     *
     * @param ref         The force's reference.
     * @param nme         The force's name.
     * @param cost        The force's activation fee.
     * @param strngth     The force's strength.
     * @param inUFF       Is the Force in the UFF
     * @param inASF       Is the Force in the ASF
     * @param isDestroyed Is the force destroyed?
     */
    public Force(String ref, String nme, int cost, int strngth) {
        reference = ref;
        name = nme;
        fee = cost;
        strength = strngth;
        inUFF = true;
        inASF = false;
        isDestroyed = false;
    }

    /**
     * Get the force's reference.
     *
     * @return The force's reference.
     */
    public String getReference() {
        return reference;
    }

    /**
     * Get the force's name.
     *
     * @return The force's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the force's activation fee.
     *
     * @return The force's activation fee.
     */
    public int getFee() {
        return fee;
    }

    /**
     * Get the force's strength
     *
     * @return The force's strength.
     */
    public int getStrength() {
        return strength;
    }
    /**
     * Get if the force is inUFF
     *
     * @return boolean.
     */
    public boolean getinUFF() {
        return inUFF;
    }
    /**
     * Get if the force is inASF
     *
     * @return boolean.
     */
    public boolean getinASF() {
        return inASF;
    }
    /**
     * Get if the force is inUFF
     *
     * @return boolean.
     */
    public boolean getisDestroyed() {
        return  isDestroyed;
    }




    /**
     * Get a human-readable representation of this object including the
     * force reference, the force name, the activation cost, and the force
     * strength.
     *
     * @return A string representation of this object.
     */
    public String toString() {
        return "< Force Reference: " + getReference() + " - Name: " + getName() + " - Activation Fee: " + getFee() + " - Strength: " + getStrength() + " >";
    }
}
