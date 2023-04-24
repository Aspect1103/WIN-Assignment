package cwk4;

/**
 * Represents a megrim that has a pilot.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 24/04/2023
 */
public class Megrim extends Force {
    private final String pilotName;

    /**
     * Constructs a megrim object.
     *
     * @param ref   The megrim's reference.
     * @param nme   The megrim's name.
     * @param pilot The megrim's pilot's name.
     */
    public Megrim(String ref, String nme, int strngth, String pilot) {
        super(ref, nme, 100, strngth);
        pilotName = pilot;
    }

    /**
     * Get the megrim's pilot's name.
     *
     * @return The megrim's pilot's name.
     */
    public String getPilotName() {
        return pilotName;
    }

    /**
     * Determines if the megrim can fight in a given battle.
     *
     * @param battleType The battle to check if the force can fight in.
     * @return Whether the megrim can fight in the battle or not.
     */
    public boolean canFight(BattleType battleType) {
        // The megrim can only fight in fights
        return battleType == BattleType.FIGHT;
    }

    /**
     * Get a human-readable representation of this object including the
     * force reference, the force name, the activation cost, the force
     * strength, the laser cannon count, and the photon torpedo count.
     *
     * @return A string representation of this object.
     */
    public String toString() {
        return "<Force Reference: " + getReference() + " - Name: " + getName() + " - Force State: " + getForceState() + " - Activation Fee: " + getFee() + " - Strength: " + getStrength() + " - Pilot Name: " + getPilotName() + ">";
    }
}
