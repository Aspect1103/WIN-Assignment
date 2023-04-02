package cwk4;

import javax.swing.*;
import java.awt.*;

/**
 * Provides a GUI interface for the game.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 01/04/2023
 */
public class GameGUI {
    private final WIN game = new SpaceWars("Horatio");
    private final JFrame frame = new JFrame("Game GUI");
    private final JTextArea listing = new JTextArea();
    private final JPanel listingPanel = new JPanel();
    private final JButton fightButton = new JButton("Fight");
    private final JButton ViewState = new JButton("View State");
    private final JButton clear = new JButton("Clear");
    private final JMenuItem listASF = new JMenuItem("List ASF");
    private final JMenuItem activateForce = new JMenuItem("Activate Force");
    private final JMenuItem recallForce = new JMenuItem("Recall Force");
    private final JMenuItem listForcesItem = new JMenuItem("List All Forces ");
    private final JMenuItem listBattles = new JMenuItem("List All Battles ");
    private final JPanel eastPanel = new JPanel();

    /**
     * Constructs a game GUI object.
     */
    public GameGUI() {
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocation(500, 200);
        makeFrame();
        makeMenuBar();
    }

    /**
     * Runs the GUI.
     *
     * @param args A string array of CLI arguments.
     */
    public static void main(String[] args) {
        new GameGUI();
    }

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame() {
        listingPanel.setLayout(new BoxLayout(listingPanel, BoxLayout.Y_AXIS));
        listingPanel.setBackground(Color.WHITE);
        listingPanel.setVisible(true);
        listingPanel.add(listing);

        // Arrange the components on the frame
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(listingPanel, BorderLayout.WEST);

        // Set up the east panel
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.setBackground(Color.WHITE);
        eastPanel.add(fightButton);
        eastPanel.add(Box.createVerticalStrut(10));
        eastPanel.add(ViewState);
        eastPanel.add(Box.createVerticalStrut(10));
        eastPanel.add(clear);

        // Set up the ViewState button
        ViewState.addActionListener(e -> {
            listing.setVisible(true);
            listing.setText(game.toString());
        });
        ViewState.setFont(new Font("Arial", Font.BOLD, 16)); // use a larger and bold font
        ViewState.setForeground(Color.WHITE); // set the text color to white
        ViewState.setBackground(Color.BLUE);

        // Set up the Clear button
        clear.addActionListener(e -> {
            listing.setText("");
        });
        clear.setFont(new Font("Arial", Font.BOLD, 16)); // use a larger and bold font
        clear.setForeground(Color.WHITE); // set the text color to white
        clear.setBackground(Color.BLUE);

        // Set up the fight button
        fightButton.addActionListener(e -> {
            int battleNumber = Integer.parseInt(JOptionPane.showInputDialog("Fight number ? "));
            JOptionPane.showMessageDialog(frame, fighting(game.doBattle(battleNumber)));
        });
        fightButton.setFont(new Font("Arial", Font.BOLD, 16)); // use a larger and bold font
        fightButton.setForeground(Color.WHITE); // set the text color to white
        fightButton.setBackground(Color.BLUE);

        // Arrange the components on the frame and show the GUI
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar() {

        // Create a menubar
        JMenuBar menubar = new JMenuBar();
        menubar.setLayout(new BoxLayout(menubar, BoxLayout.X_AXIS));
        menubar.setVisible(true);

        // Arrange the components on the frame
        frame.setJMenuBar(menubar);

        // Create the forces menu
        JMenu forcesMenu = new JMenu("Forces");

        // Create the battles menu
        JMenu battlesMenu = new JMenu("Battles");

        // Arrange the components on the menubar
        menubar.add(forcesMenu);
        menubar.add(Box.createHorizontalStrut(100)); // Add space of 10 pixels between the buttons
        menubar.add(battlesMenu);

        //Adding menu items for forces and battles
        recallForce.addActionListener(e -> {
            String forceNum = JOptionPane.showInputDialog("Force reference ? ");
            game.recallForce(forceNum);
            JOptionPane.showMessageDialog(frame, "Force " + forceNum + " recalled.");
            listing.setVisible(true);
        });

        listForcesItem.addActionListener(e -> {
            listing.setVisible(true);
            listing.setText(game.getAllForces());
        });

        activateForce.addActionListener(e -> {
            String forceNum = JOptionPane.showInputDialog("Force reference ? ");
            JOptionPane.showMessageDialog(frame, activatingForce(game.activateForce(forceNum)));
            listing.setVisible(true);
        });

        listASF.addActionListener(e -> {
            listing.setVisible(true);
            listing.setText(game.getASFleet());
        });

        listBattles.addActionListener(e -> {
            listing.setVisible(true);
            listing.setText(game.getAllBattles());
        });

        // Arrange the components on the forcesMenu
        forcesMenu.add(listForcesItem);
        forcesMenu.add(recallForce);
        forcesMenu.add(activateForce);
        forcesMenu.add(listASF);

        // Arrange the components on the battlesMenu
        battlesMenu.add(listBattles);
    }

    /**
     * Process the result of a battle.
     *
     * @param code The result of the battle.
     * @return A string representation of the result of a battle.
     */
    private String fighting(int code) {
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

    /**
     * Process the result of activating a force.
     *
     * @param code The result of activating a force.
     * @return A string representation of the result of activating a force.
     */
    private String activatingForce(int code) {
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
}
