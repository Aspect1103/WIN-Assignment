package cwk4;

/**
 * Represents a wing in the United Forces Fleet (UFF) which cannot
 * be sent on fights.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 24/03/2023
 */
public class Wing extends Force {
    private final int strikers;

    /**
     * Constructs a wing object.
     *
     * @param ref   The wing's reference.
     * @param nme   The wing's name.
     * @param cost  The wing's activation fee.
     * @param strik The wing's striker count.
     */
    public Wing(String ref, String nme, int cost, int strik) {
        super(ref, nme, cost, strik * 20);
        strikers = strik;
    }

    /**
     * Get the wing's striker count.
     *
     * @return The wing's striker count.
     */
    public int getStrikers() {
        return strikers;
    }

    /**
     * Get a human-readable representation of this object including the
     * force reference, the force name, the activation cost, the force
     * strength, and the striker count.
     *
     * @return A string representation of this object.
     */
    public String toString() {
        return "<Force Reference: " + getReference() + " - Name: " + getName() + " - Force State: " + getFee() + " - Activation Fee: " + getFee() + " - Strength: " + getStrength() + " - Striker Count: " + getStrikers() + ">";
    }
}
