package cwk4;

import javax.swing.*;
import java.awt.*;

/**
 * Provides a GUI interface for the game.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 03/04/2023
 */
public class GameGUI {
    private final WIN game = new SpaceWars("Horatio");
    private final JFrame frame = new JFrame("Game GUI");
    private final JPanel eastPanel = new JPanel();
    private final JPanel outputPanel = new JPanel();
    private final JMenuBar menubar = new JMenuBar();
    private final JTextArea outputText = new JTextArea();
    private final JMenu forcesMenu = new JMenu("Forces");
    private final JMenu battlesMenu = new JMenu("Battles");
    private final JButton clearButton = new JButton("Clear");
    private final JButton fightButton = new JButton("Fight");
    private final JButton viewStateButton = new JButton("View State");
    private final JMenuItem listASFItem = new JMenuItem("List ASF");
    private final JMenuItem recallForceItem = new JMenuItem("Recall Force");
    private final JMenuItem listForcesItem = new JMenuItem("List All Forces ");
    private final JMenuItem activateForceItem = new JMenuItem("Activate Force");
    private final JMenuItem listBattlesItem = new JMenuItem("List All Battles ");

    /**
     * Constructs a game GUI object.
     */
    public GameGUI() {
        // Set the window size
        frame.setPreferredSize(new Dimension(800, 600));

        // Create the GUI
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
        // Create the output panel listing the result from top to bottom
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
        outputPanel.setBackground(Color.WHITE);
        outputPanel.setVisible(true);
        outputPanel.add(outputText);

        // Set up the east panel
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.setBackground(Color.WHITE);
        fightButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        eastPanel.add(fightButton);
        eastPanel.add(Box.createVerticalStrut(10));
        viewStateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        eastPanel.add(viewStateButton);
        eastPanel.add(Box.createVerticalStrut(10));
        clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        eastPanel.add(clearButton);

        // Set up the view button
        viewStateButton.addActionListener(e -> outputText.setText(game.toString()));
        viewStateButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewStateButton.setForeground(Color.WHITE);
        viewStateButton.setBackground(Color.BLUE);

        // Set up the clear button
        clearButton.addActionListener(e -> outputText.setText(""));
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLUE);

        // Set up the fight button
        fightButton.addActionListener(e -> {
            int battleNumber = Integer.parseInt(JOptionPane.showInputDialog("Battle number: "));
            JOptionPane.showMessageDialog(frame, battleResult(game.doBattle(battleNumber)));
        });
        fightButton.setFont(new Font("Arial", Font.BOLD, 16));
        fightButton.setForeground(Color.WHITE);
        fightButton.setBackground(Color.BLUE);

        // Arrange the components on the frame and show the GUI
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(outputPanel, BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar() {
        // Create a menubar
        menubar.setLayout(new BoxLayout(menubar, BoxLayout.X_AXIS));
        menubar.setVisible(true);

        // Arrange the components on the menubar
        menubar.add(forcesMenu);
        menubar.add(Box.createHorizontalStrut(100));
        menubar.add(battlesMenu);

        // Add the menu items for forces and battles
        recallForceItem.addActionListener(e -> game.recallForce(JOptionPane.showInputDialog("Force reference: ")));

        // Add action listeners for each menu item
        listForcesItem.addActionListener(e -> outputText.setText(game.getAllForces()));
        activateForceItem.addActionListener(e -> {
            String forceNum = JOptionPane.showInputDialog("Force reference: ");
            JOptionPane.showMessageDialog(frame, activateResult(game.activateForce(forceNum)));
        });
        listASFItem.addActionListener(e -> outputText.setText(game.getASFleet()));
        listBattlesItem.addActionListener(e -> outputText.setText(game.getAllBattles()));

        // Arrange the components on the forcesMenu
        forcesMenu.add(listForcesItem);
        forcesMenu.add(recallForceItem);
        forcesMenu.add(activateForceItem);
        forcesMenu.add(listASFItem);

        // Arrange the components on the battlesMenu
        battlesMenu.add(listBattlesItem);

        // Arrange the components on the frame
        frame.setJMenuBar(menubar);
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
