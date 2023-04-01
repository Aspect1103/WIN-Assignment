package cwk4;

import javax.swing.*;
import java.awt.*;

/**
 * Provides a GUI interface for the game
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 30/03/2023
 */
public class GameGUI {
    private final WIN game = new SpaceWars("Horatio");
    private  JFrame frame = new JFrame("Game GUI");
    private final JTextArea listing = new JTextArea();
    private final JLabel codeLabel = new JLabel();
    private final JButton fightBtn = new JButton("Fight");
    private final JPanel eastPanel = new JPanel();

    /**
     * Constructs a gameGUI object.
     */
    public GameGUI() {
        frame.setPreferredSize(new Dimension(800, 600)); // set the preferred size of the frame
        frame.setLocation(500, 200);
        makeFrame();
        makeMenuBar(frame);
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
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame) {
        // Create a menubar
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        // Create the forces menu
        JMenu forcesMenu = new JMenu("Forces");
        menubar.add(forcesMenu);

        // Add a list of forces menu item to the forces menu
        JMenuItem listForcesItem = new JMenuItem("List All Forces ");
        listForcesItem.addActionListener(e -> {
            listing.setVisible(true);
            listing.setText(game.getAllForces());
        });
    }

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame() {
        // Set up the main components
        JPanel listingPanel = new JPanel();
        JButton fightButton = new JButton("Fight");
        JButton listASFButton = new JButton("List ASF");
        JButton activateForce = new JButton("Activate Force");
        JPanel eastPanel = new JPanel();

        listingPanel.setLayout(new BoxLayout(listingPanel, BoxLayout.Y_AXIS));
        listingPanel.setBackground(Color.WHITE); // set the background color
        listingPanel.setVisible(true);
        listingPanel.add(Box.createVerticalStrut(10)); // Add space of 10 pixels between the buttons
        listingPanel.add(listASFButton);
        listingPanel.add(Box.createVerticalStrut(10)); // Add space of 10 pixels between the buttons
        listingPanel.add(activateForce);

        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(listingPanel, BorderLayout.WEST);

        listASFButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, game.getASFleet());
        });
        listASFButton.setFont(new Font("Arial", Font.BOLD, 16)); // use a larger and bold font
        listASFButton.setForeground(Color.WHITE); // set the text color to white
        listASFButton.setBackground(Color.BLUE);

        activateForce.addActionListener(e -> {
            String forceNum = JOptionPane.showInputDialog("Force reference ? ");
            JOptionPane.showMessageDialog(frame, activatingForce(game.activateForce(forceNum)));
        });
        activateForce.setFont(new Font("Arial", Font.BOLD, 16)); // use a larger and bold font
        activateForce.setForeground(Color.WHITE); // set the text color to white
        activateForce.setBackground(Color.BLUE);

        // Set up the east panel
        eastPanel.setLayout(new GridLayout(4, 1, 0, 10)); // add some vertical spacing
        eastPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // add some padding
        eastPanel.add(fightButton);

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
     * Process the result of a battle.
     *
     * @param code The result of the battle.
     * @return A string representation of the result of a battle.
     */
    private String fighting(int code) {
        return switch (code) {
            case 0 -> "Fight won";
            case 1 -> "Fight lost as no suitable force available";
            case 2 -> "Fight lost on battle strength, force destroyed";
            case 3 -> "fight is lost and admiral completely defeated ";
            default -> "No such fight";
        };
    }
    /**
     * Process the result of activating a Force.
     *
     * @param code The result of activating a Force.
     * @return A string representation of the result of activating a Force.
     */
    private String activatingForce(int code) {
        return switch (code) {
            case 0 -> "Force is activated";
            case 1 -> "Force is not in the UFF dock or is destroyed";
            case 2 -> "Not enough money";
            case 3 -> "fight is lost and admiral completely defeated ";
            default -> "No such force";
        };
    }


}
