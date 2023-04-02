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
        new GameUI().playGame();
    }

    /**
     * Play the game.
     */
    private void playGame() {
        System.out.println("Enter admiral's name: ");
        WIN gp = new SpaceWars(scanner.nextLine());

        int choice = 100;
        while (choice != 0) {
            choice = getMenuItem();
            if (choice == 1) {  // All forces
                System.out.println(gp.getAllForces());
            } else if (choice == 2) { // List all battles
                System.out.println(gp.getAllBattles());
            } else if (choice == 3) {  // get Force
                System.out.println("Enter force reference: ");
                scanner.nextLine();
                System.out.println(gp.getForceDetails(scanner.nextLine()));
            } else if (choice == 4) {  // activate Force
                System.out.println("Enter force reference: ");
                scanner.nextLine();
                System.out.println(gp.activateForce(scanner.nextLine()));
            } else if (choice == 5) { //  List ASFleet
                System.out.println(gp.getASFleet());
            } else if (choice == 6) {  // engage in a battle
                System.out.println("Enter battle number: ");
                scanner.nextLine();
                System.out.println(gp.doBattle(scanner.nextInt()));
            } else if (choice == 7) {  // recall force
                System.out.println("Enter force reference: ");
                scanner.nextLine();
                gp.recallForce(scanner.nextLine());
            } else if (choice == 8) {  // view game state
                System.out.println(gp);
            } else if (choice == 9) {  // Task 3.5 only
                gp.saveGame("battles.txt");
            } else if (choice == 10) {  // Task 3.5 only
                System.out.println(gp.restoreGame("olenka.txt"));
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
        System.out.println("4. Activate a force into the Active Star  fleet");
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

    private String activation(int code) {
        switch (code) {
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
}
