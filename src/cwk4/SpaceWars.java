package cwk4;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * This class implements the behaviour expected from a WIN
 * system as required for 5COM2007.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 23/03/2023
 */
public class SpaceWars implements WIN {
    private final String name;
    private  int warChest = 1000;
    private final HashMap<String, Force> forces = new HashMap<String, Force>();
    private final HashMap<Integer, Battle> battles = new HashMap<Integer, Battle>();


    /**
     * Constructs a SpaceWars object.
     *
     * @param admiral The name of the admiral.
     */
    public SpaceWars(String admiral) {
        name = admiral;
        setupForces();
        setupBattles();
    }

    /**
     * Constructs a SpaceWars object reading battles from a file.
     *
     * @param admiral  The name of the admiral.
     * @param filename The filename of the battles file.
     */
    public SpaceWars(String admiral, String filename) {
        name = admiral;
    }

    /**
     * Get a human-readable representation of the state of the
     * game including the name of the admiral, the state of the
     * war chest, whether defeated or not, and the forces currently
     * in the ASF.
     *
     * @return A string representation of the state of the game.
     **/
    public String toString() {
        return "< Admiral Name: " + name + " - Current War Chest: " + warChest + " - Defeated " + isDefeated() + " - Current ASF: " + getASFleet() + " >";
    }

    /**
     * Determines if the admiral is defeated or not. It returns
     * true if the war chest <= 0 and the ASF has no forces which
     * can be recalled.
     *
     * @return Whether the admiral is defeated or not.
     */
    public boolean isDefeated() {
        if(warChest <= 0 && getASFleet() == ""){
            return true;
        }
        return false;
    }

    /**
     * Get the number of bit coins in the war chest.
     *
     * @return The number of bit coins in the war chest.
     */
    public int getWarchest() {
        return warChest;
    }

    /**
     * Get a list of all forces in the system listing all forces
     * in the ASF, the UFF dock, and destroyed forces.
     *
     * @return A list of all forces in the system.
     */
    public String getAllForces() {
        StringBuilder sb = new StringBuilder();
        for (String key : forces.keySet()) {
            sb.append(forces.get(key)).append("\n");
        }
        return sb.toString();
    }

    /**
     * Determines if a force reference is in the UFF dock.
     *
     * @param ref The reference of the force.
     * @return Whether the force is in the UFF dock or not.
     **/
    public boolean isInUFFDock(String ref) {
        for (String key : forces.keySet()) {
            if (forces.get(key).getinUFF() && key.equals(ref)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get a list of all forces in the UFF dock.
     *
     * @return A list of all forces in the UFF dock.
     **/
    public String getForcesInDock() {
        StringBuilder sb = new StringBuilder();
        for (String key : forces.keySet()) {
            if (forces.get(key).getinUFF()) {
                sb.append(forces.get(key)).append("\n");

            }
        }
        return sb.toString();
    }


    /**
     * Get a list of all destroyed forces in the system.
     *
     * @return A list of all destroyed forces in the system.
     */
    public String getDestroyedForces() {
        StringBuilder sb = new StringBuilder();
        for (String key : forces.keySet()) {
            if (!forces.get(key).getinUFF()) {
                sb.append(forces.get(key)).append("\n");

            }
        }
        return sb.toString();
    }

    /**
     * Get a force's details from a given force reference or "No
     * such force" if one doesn't exist.
     *
     * @param ref The reference of the force.
     * @return The force's details from a given force reference.
     **/
    public String getForceDetails(String ref) {
        StringBuilder sb = new StringBuilder();
        for (String key : forces.keySet()) {
            if (key.equals(ref)) {
                sb.append(forces.get(key)).append("\n");
            } else{
                    return "\nNo such force";
                }
        }
        return sb.toString();
    }

    /**
     * Activates a force into the ASF only if there are enough
     * resources for the activation fee. The force's state is
     * then set to "active".
     *
     * @param ref The reference of the force.
     * @return 0 if the force is activated, 1 if the force is not
     * in the UFF dock or is destroyed, 2 if there is not enough
     * bit coins, or -1 if the force doesn't exist.
     **/
    public int activateForce(String ref) {
        for (HashMap.Entry<String, Force> entry : forces.entrySet()) {
            String key = entry.getKey();
            Force value = entry.getValue();
            if (getWarchest() >= value.getFee() && key.equals(ref)) {
                value.setinASF(true);
//                ForceState("active");
                warChest -= value.getFee();
                return 0;
            } else if (!isInUFFDock(key) && key.equals(ref) || value.getisDestroyed() && key.equals(ref)) {
                return 1;
            } else if (getWarchest() < value.getFee() && key.equals(ref)) {
                return 2;
            }
        }
        return -1;
    }

    /**
     * Determines if a given force reference exists in the ASF.
     *
     * @param ref The reference of the force.
     * @return Whether the given force reference exists in the ASF.
     **/
    public boolean isInASFleet(String ref) {
        for (HashMap.Entry<String, Force> entry : forces.entrySet()) {
            String key = entry.getKey();
            Force value = entry.getValue();
            if (value.getinASF() && key.equals(ref)) {
                return true;
            }}
        return false;
    }

    /**
     * Get a list of all forces in the ASF.
     *
     * @return A list of all forces in the ASF.
     **/
    public String getASFleet() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<String, Force> entry : forces.entrySet()) {
            String key = entry.getKey();
            Force value = entry.getValue();
            if (value.getinASF() ) {
                sb.append(value).append("\n");
            }}
        return sb.toString();
    }

    /**
     * Recalls a force from the ASF back to the UFF dock.
     *
     * @param ref The reference of the force.
     **/
    public void recallForce(String ref) {
        for (HashMap.Entry<String, Force> entry : forces.entrySet()) {
            String key = entry.getKey();
            Force value = entry.getValue();
            if (value.getinASF() && key.equals(ref)) {
                value.setinASF(false);
            }}
    }

    /**
     * Determines if a given number represents a battle.
     *
     * @param num The number of the battle.
     * @return Whether the given number represents a battle or not.
     **/
    public boolean isBattle(int num) {
        for (HashMap.Entry<Integer, Battle> entry : battles.entrySet()) {
            Integer key = entry.getKey();
            Battle value = entry.getValue();
            if (key.equals(num)) {
                return true;
            }}
        return false;
    }

    /**
     * Get a battle's details from a given battle number or
     * "No such battle" if one doesn't exist.
     *
     * @param num The number of the battle.
     * @return The battle's details from a given battle number.
     **/
    public String getBattle(int num) {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Integer, Battle> entry : battles.entrySet()) {
            Integer key = entry.getKey();
            Battle value = entry.getValue();
            if (key.equals(num)) {
                sb.append(value).append("\n");
                return sb.toString();
            }}
        return "No such battle";
    }

    /**
     * Get a list of all battles in the system.
     *
     * @return A list of all battles in the system.
     **/
    public String getAllBattles() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Integer, Battle> entry : battles.entrySet()) {
            Integer key = entry.getKey();
            Battle value = entry.getValue();
            sb.append(value).append("\n");
            }
        return sb.toString();
    }

    /**
     * Simulates a battle by locating a force from the ASF
     * which can engage in the battle. The result of the
     * battle will be one of the following:
     * 0 - Battle won so the gains are added to the
     * war chest.
     * 1 - Battle lost as no suitable force is available
     * so losses are deducted from the war chest.
     * 2 - Battle lost on battle strength so losses are
     * deducted from the war chest and the force is destroyed.
     * 3 - Battle lost and the admiral is completely defeated
     * (war chest is empty and no forces to recall).
     * -1 - No such battle is found.
     *
     * @param battleNo The number of the battle.
     * @return An integer showing the result of the battle.
     */
    public int doBattle(int battleNo) {
        return 999;
    }

    /**
     * Writes the game state to a specified file.
     *
     * @param fname The name of the file to store the game state.
     */
    public void saveGame(String fname) {

    }

    /**
     * Initialise a SpaceWars object from a given filename
     * storing the game state.
     *
     * @param fname The name of the file storing the game state.
     * @return The initialised SpaceWars object.
     */
    public SpaceWars restoreGame(String fname) {
        return new SpaceWars("d");
    }

    /**
     * Initialises the forces into the system.
     */
    private void setupForces() {
        forces.put("IW1", new Wing("IW1", "Twisters", 200, 10));
        forces.put("SS2", new StarShip("SS2", "Enterprise", 10, 20));
        forces.put("WB3", new WarBird("WB3", "Droop", 100, false));
        forces.put("IW4", new Wing("IW4", "Wingers", 200, 20));
        forces.put("WB5", new WarBird("WB5", "Hang", 300, true));
        forces.put("SS6", new StarShip("SS6", "Voyager", 15, 10));
        forces.put("SS7", new StarShip("SS7", "Explorer", 4, 5));
        forces.put("WB9", new WarBird("WB9", "Hovers", 400, false));
        forces.put("IW10", new Wing("IW10", "Flyers", 200, 5));
    }

    /**
     * Initialises the battles into the system.
     */
    private void setupBattles() {
        battles.put(1, new Battle(1, BattleType.FIGHT, "Borg", 200, 300, 100));
        battles.put(2, new Battle(2, BattleType.SKIRMISH, "Kardassians", 700, 200, 120));
        battles.put(3, new Battle(3, BattleType.AMBUSH, "Ferengi", 100, 400, 150));
        battles.put(4, new Battle(4, BattleType.FIGHT, "Ewoks", 600, 600, 200));
        battles.put(5, new Battle(5, BattleType.AMBUSH, "Borg", 500, 400, 90));
        battles.put(6, new Battle(6, BattleType.SKIRMISH, "Groaners", 150, 100, 100));
        battles.put(7, new Battle(7, BattleType.FIGHT, "Borg", 150, 500, 300));
        battles.put(8, new Battle(8, BattleType.AMBUSH, "Wailers", 300, 300, 300));
    }

    /**
     * Loads the battles from a given filename.
     *
     * @param fname The name of the file storing the battles.
     */
    private void readBattles(String fname) {

    }
}
