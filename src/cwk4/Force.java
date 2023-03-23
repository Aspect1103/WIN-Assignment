package cwk4;

/**
 * A class representing a cwk4.Force, a unit in the United Forces Fleet (UFF) which can partake in battles.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 23/03/2023
 */
public class Force {
    private final String reference;
    private final String name;
    private final int fee;
    private final int strength;

    /**
     * Constructor - Constructs a Force object
     *
     * @param ref      - Reference
     * @param name     - Name
     * @param fee      - Fee
     * @param strength - Strength
     */
    public Force(String ref, String name, int fee, int strength) {
        reference = ref;
        this.name = name;
        this.fee = fee;
        this.strength = strength;
    }

    /**
     * A String returning the Reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * A String returning the Name
     */
    public String getName() {
        return name;
    }

    /**
     * A String returning the Fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * A String returning the Strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * A method to return the details of a cwk4.Force in a String
     *
     * @return the Reference, the Name, the Fee and the Strength
     */
    public String toString() {
        return "<cwk4.Force Reference: " + reference + " - Name: " + name + " - Fee: " + fee + " - Strength: " + strength + ">";
    }
}
