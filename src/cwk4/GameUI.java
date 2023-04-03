package cwk4;

import java.util.Scanner;

/**
 * Provides a command-line user interface for the game.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 01/04/2023
 */
public class GameUI {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Runs the command-line interface.
     *
     * @param args A string array of CLI arguments.
     */
    public static void main(String[] args) {
        GameUI myGame = new GameUI();
        myGame.playGame();
    }

    /**
     * Starts the game by prompting the user to enter a name for the admiral followed by a menu display.
     * Depending on user's choice, the methods are  tasks accordingly e.g. activating force, recalling forces etc.
     *
     */
    private void playGame() {
        int choice = 100;
        System.out.println("Enter admiral's name@:");
        String admiralName = scanner.nextLine();
        WIN gp = new SpaceWars(admiralName);
        while (choice != 0) {
            choice = getMenuItem();
            if (choice == 1) {  // All forces
                System.out.println(gp.getAllForces());
            } else if (choice == 2) { // List all battles
                System.out.println(gp.getAllBattles());
            } else if (choice == 3) {  // get Force
                System.out.println("Enter force reference");
                String ref = scanner.nextLine();
                System.out.println(gp.getForceDetails(ref));
            } else if (choice == 4) {  // activate Force
                System.out.println("Enter force reference");
                String ref = scanner.nextLine();
                System.out.println(activateResult(gp.activateForce(ref)));
            } else if (choice == 5) { //  List ASFleet
                System.out.println(gp.getASFleet());
            } else if (choice == 6) {  // engage in a battle
                System.out.println("Enter battle Number");
                int battleNum = scanner.nextInt();
                System.out.println(battleResult(gp.doBattle(battleNum)));
            } else if (choice == 7) {  // recall force
                System.out.println("Enter force reference");
                String ref = scanner.nextLine();
                gp.recallForce(ref);
                if (gp.isInUFFDock(ref)) System.out.println("Force recalled to dock successfully");
                else System.out.println("Something went wrong recalling force successfully");
            } else if (choice == 8) {  // view game state
                System.out.println(gp);
            } else if (choice == 9) {  // Task 3.5 only
                // prompt user to enter filename to save as
                System.out.println("Enter filename to save as");
                String filename = scanner.nextLine();
                gp.saveGame(filename); // this does the saving
                System.out.println(filename + " saved successfully");
            } else if (choice == 10) {  // Task 3.5 only
                System.out.println("Enter filename to load");
                String filename = scanner.nextLine();
                gp = gp.restoreGame(filename);
                System.out.println(filename + " loaded successfully");
                System.out.println(gp.toString());
            }
        }
        System.out.println("Thank-you");
    }

    /**
     * Display the menu with number of choices.
     */
    private int getMenuItem() {
        // Display the main menu
        System.out.println("Main Menu");
        System.out.println("0. Quit");
        System.out.println("1. List all forces");
        System.out.println("2. List all battles");
        System.out.println("3. View details of a force");
        System.out.println("4. Activate a force into the Active Star Fleet");
        System.out.println("5. List forces in Active Star Fleet");
        System.out.println("6. Engage in a battle");
        System.out.println("7. Recall a force");
        System.out.println("8. View the state of the game");
        System.out.println("9. Save this game");
        System.out.println("10. Restore a game");

        // Get the user's choice
        int choice = -1;
        while (choice < 0 || choice > 10) {
            System.out.println("Enter the number of your choice: ");
            choice = scanner.nextInt();
        }
        return choice;
    }

    /**
     * Process the result of activating a force.
     *
     * @param code The result of activating a force.
     * @return A string representation of the result of activating a force.
     */
    private String activateResult(int code) {
        switch (code) {
            case 0:
                return "Force is activated";
            case 1:
                return "Force is not in the UFF dock or is destroyed";
            case 2:
                return "Not enough money";
            default:
                return "No such force";
        }
    }

    /**
     * Process the result of a battle.
     *
     * @param code The result of the battle.
     * @return A string representation of the result of a battle.
     */
    private String battleResult(int code) {
        switch (code) {
            case 0:
                return "Battle won";
            case 1:
                return "Battle lost as no suitable force available";
            case 2:
                return "Battle lost on battle strength so force is destroyed";
            case 3:
                return "Battle is lost and admiral is completely defeated";
            default:
                return "No such battle";
        }
    }
}
