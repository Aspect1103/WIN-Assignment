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
    private final Scanner myIn = new Scanner(System.in);
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
     * This the main method which triggers the game, prompting the user to enter a name for the admiral followed by a menu display.
     * Depending on user's choice, the certain method is called accordingly e.g. activating force, recalling forces etc.
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
                String ref = myIn.nextLine();
                System.out.println(gp.getForceDetails(ref));
            } else if (choice == 4) {  // activate Force
                System.out.println("Enter force reference");
                String ref = myIn.nextLine();
                System.out.println(activation(gp.activateForce(ref)));
            } else if (choice == 5) { //  List ASFleet
                System.out.println(gp.getASFleet());
            } else if (choice == 6) {  // engage in a battle
                System.out.println("Enter battle Number");
                int battleNum = myIn.nextInt();
                System.out.println(battleResultMessage(gp.doBattle(battleNum)));
            } else if (choice == 7) {  // recall force
                System.out.println("Enter force reference");
                String ref = myIn.nextLine();
                gp.recallForce(ref);
                if (gp.isInUFFDock(ref))
                    System.out.println("Force recalled to dock successfully");
                else
                    System.out.println("Something went wrong recalling force successfully");
            } else if (choice == 8) {  // view game state
                System.out.println(gp);
            } else if (choice == 9) {  // Task 3.5 only
                // prompt user to enter filename to save as
                System.out.println("Enter filename to save as");
                String filename = myIn.nextLine();
                gp.saveGame(filename); // this does the saving
                System.out.println(filename + " saved successfully");
            } else if (choice == 10) {  // Task 3.5 only
                System.out.println("Enter filename to load");
                String filename = myIn.nextLine();
                gp = gp.restoreGame(filename);
                System.out.println(filename + " loaded successfully");
                //System.out.println(gp.toString());
            }
        }
        System.out.println("Thank-you");
    }

    /**
     * Display the menu with number of choices.
     */
    private int getMenuItem() {
        int choice = 100;
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

        while (choice < 0 || choice > 10) {
            System.out.println("Enter the number of your choice");
            choice = scanner.nextInt();
        }
        return choice;
    }

    private String activation(int activateForceRef) {
        switch (activateForceRef) {
            case 0:
                return "force is activated";
            case 1:
                return "force is not in the UFFDock";
            case 2:
                return "not enough money";
            case 3:
                return "no such force";
            default:
                return "Error";
        }
    }

    private String battleResultMessage(int battleResultCode) {
        switch (battleResultCode) {
            case 0:
                return "Battle won so the gains are added to the war chest.";
            case 1:
                return "Battle lost as no suitable force is available so losses are deducted from the war chest";
            case 2:
                return "Battle lost on battle strength so losses are deducted from the war chest and the force is destroyed";
            case 3:
                return "Battle lost and the admiral is completely defeated (war chest is empty and no forces to recall)";
            case -1:
                return "No such battle is found.";
            default:
                return "Error";
        }
    }
}
