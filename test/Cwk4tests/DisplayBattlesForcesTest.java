package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Holds tests related to the displaying battles and forces.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 27/03/2023
 */
public class DisplayBattlesForcesTest {
    // Define the WIN interface variable to use for testing
    WIN swim;

    /**
     * Set up a test before it executes.
     */
    @Before
    public void setUp() {
        swim = new SpaceWars("Bob");
    }

    /**
     * Determine if a given string contains two other strings.
     *
     * @param text The string to check for containment.
     * @param s1   The first string to check.
     * @param s2   The second string to check.
     * @return Whether a given string contains three other strings or not.
     */
    private boolean containsText(String text, String s1, String s2) {
        return text.contains(s1) && text.contains(s2);
    }

    /**
     * Determine if a given string contains three other strings.
     *
     * @param text The string to check for containment.
     * @param s1   The first string to check.
     * @param s2   The second string to check.
     * @param s3   The third string to check.
     * @return Whether a given string contains three other strings or not.
     */
    private boolean containsText(String text, String s1, String s2, String s3) {
        return text.contains(s1) && text.contains(s2) && text.contains(s3);
    }

    /**
     * Test if all battles are displayed (part 1).
     */
    @Test
    public void battleNo1Displayed() {
        assertTrue(containsText(swim.getAllBattles(), "1", "Fight", "Borg"));
    }

    /**
     * Test if all battles are displayed (part 2).
     */
    @Test
    public void battleNo2Displayed() {
        assertTrue(containsText(swim.getAllBattles(), "2", "Skirmish", "Kardassians"));
    }

    /**
     * Test if all battles are displayed (part 3).
     */
    @Test
    public void battleNo3Displayed() {
        assertTrue(containsText(swim.getAllBattles(), "3", "Ambush", "Ferengi"));
    }

    /**
     * Test if all battles are displayed (part 4).
     */
    @Test
    public void battleNo4Displayed() {
        assertTrue(containsText(swim.getAllBattles(), "4", "Fight", "Ewoks"));
    }

    /**
     * Test if all battles are displayed (part 5).
     */
    @Test
    public void battleNo5Displayed() {
        assertTrue(containsText(swim.getAllBattles(), "5", "Ambush", "Borg"));
    }

    /**
     * Test if all battles are displayed (part 6).
     */
    @Test
    public void battleNo6Displayed() {
        assertTrue(containsText(swim.getAllBattles(), "6", "Skirmish", "Groaners"));
    }

    /**
     * Test if all forces in the dock are displayed (part 1).
     */
    @Test
    public void forceFleetIW1Displayed() {
        assertTrue(containsText(swim.getForcesInDock(), "IW1", "Twisters"));
    }

    /**
     * Test if all forces in the dock are displayed (part 2).
     */
    @Test
    public void forceFleetSS2Displayed() {
        assertTrue(containsText(swim.getForcesInDock(), "SS2", "Enterprise"));
    }

    /**
     * Test if all forces in the dock are displayed (part 3).
     */
    @Test
    public void forceFleetWB3Displayed() {
        assertTrue(containsText(swim.getForcesInDock(), "WB3", "Droop"));
    }

    /**
     * Test if all forces in the dock are displayed (part 4).
     */
    @Test
    public void forceFleetIW4Displayed() {
        assertTrue(containsText(swim.getForcesInDock(), "IW4", "Wingers"));
    }

    /**
     * Test if all forces in the dock are displayed (part 5).
     */
    @Test
    public void forceFleetWB5Displayed() {
        assertTrue(containsText(swim.getForcesInDock(), "WB5", "Hang"));
    }

    /**
     * Test if all forces in the dock are displayed (part 6).
     */
    @Test
    public void forceFleetSS6Displayed() {
        assertTrue(containsText(swim.getForcesInDock(), "SS6", "Voyager"));
    }

    /**
     * Test if all forces in the dock are displayed (part 7).
     */
    @Test
    public void forceFleetSS7Displayed() {
        assertTrue(containsText(swim.getForcesInDock(), "SS7", "Explorer"));
    }

    /**
     * Test if all forces in the dock are displayed (part 8).
     */
    @Test
    public void forceFleetWB9Displayed() {
        assertTrue(containsText(swim.getForcesInDock(), "WB9", "Hover"));
    }

    /**
     * Test if all forces in the dock are displayed (part 9).
     */
    @Test
    public void forceFleetIW10Displayed() {
        assertTrue(containsText(swim.getForcesInDock(), "IW10", "Flyers"));
    }

    // ******************** CUSTOM TESTS ********************
}
