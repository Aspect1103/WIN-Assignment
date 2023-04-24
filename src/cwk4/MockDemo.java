package cwk4;

/**
 * Tests the WIN specification as per the mock demo.
 *
 * @author Klevi (20067052), Jack (20035866), Luke (21000135), Abdulla (20075156)
 * @version 24/04/2023
 */
public class MockDemo {
    /**
     * Runs the test class.
     *
     * @param args A string array of CLI arguments.
     */
    public static void main(String[] args) {
        // Create a space wars object and output its state
        WIN boss = new SpaceWars("Olga");
        System.out.println(boss);
        System.out.println("*************");

        // Active SS6 and output the result
        System.out.println(boss.activateForce("SS6"));
        System.out.println("Warchest: " + boss.getWarchest());

        // Display the ASF
        System.out.println(boss.getASFleet());

        // Do battle 6 and output the result
        System.out.println(boss.doBattle(6));
        System.out.println("Warchest: " + boss.getWarchest());

        // Recall SS6 to dock and output the result
        boss.recallForce("SS6");
        System.out.println("Warchest: " + boss.getWarchest());
        System.out.println(boss.getASFleet());

        // Activate 'Grumbler' into the ASF
        boss.activateForce("M14");

        // Display the admiral's name
        System.out.println("Admiral's name: " + boss.getAdmiral());
    }
}
