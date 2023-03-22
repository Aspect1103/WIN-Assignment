package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;

/**
 * Holds tests related to the force activation.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 21/03/2023
 */
public class ForceActivationTest {
    // Define the WIN interface variable to use for testing
    WIN game;

    /**
     * Set up a test before it executes.
     */
    @Before
    public void setUp() {
        game = new SpaceWars("TestName");
    }
}
