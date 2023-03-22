package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Holds tests related to the initialisation of the game.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 21/03/2023
 */
public class SetupTest {
    // Define the WIN interface variable to use for testing
    WIN game;

    /**
     * Set up a test before it executes.
     */
    @Before
    public void setUp() {
        game = new SpaceWars("TestName");
    }

    /**
     * Test if the game is correctly initialised.
     */
    @Test
    public void testGameInit() {
        assertEquals(game.toString(), "TODO");
    }

    /**
     * Test if warChest has 1000 bit coins before a battle.
     */
    @Test
    public void testWarChestInit() {
        assertEquals(game.getWarchest(), 1000);
    }

    /**
     * Test if all battles are initialised at startup.
     */
    @Test
    public void testBattleInit() {
        boolean result = true;
        for (int battleNumber = 1; battleNumber <= 8; battleNumber++) {
            result = result && game.isBattle(battleNumber);
        }
        assertTrue(result);
    }

    /**
     * Test if all forces are initialised in the UFF at startup.
     */
    @Test
    public void testUFFInit() {
        boolean result = true;
        String[] forces = {"IW1", "WB3", "SS2", "IW4", "WB5", "SS6", "SS7", "WB9", "IW10"};
        for (String force : forces) {
            result = result && game.isInUFFDock(force);
        }
        assertTrue(result);
    }

    /**
     * Test if the ASF is empty at setup.
     */
    @Test
    public void testASFInit() {
        boolean result = true;
        String[] forces = {"IW1", "WB3", "SS2", "IW4", "WB5", "SS6", "SS7", "WB9", "IW10"};
        for (String force : forces) {
            result = result && !game.isInASFleet(force);
        }
        assertTrue(result);
    }

    /**
     * Get details of a warbird force.
     */
    @Test
    public void testWarbirdInit() {
        assertEquals(game.getForceDetails("WB3"), "TODO");
    }

    /**
     * Get details of a starship force.
     */
    @Test
    public void testStarshipInit() {
        assertEquals(game.getForceDetails("SS2"), "TODO");
    }

    /**
     * Get details of a wing force.
     */
    @Test
    public void testWingInit() {
        assertEquals(game.getForceDetails("IW1"), "TODO");
    }

    /**
     * Get details of an invalid force.
     */
    @Test
    public void testInvalidForce() {
        assertEquals(game.getForceDetails("XX3"), "TODO");
    }

    /**
     * Get details of a valid battle.
     */
    @Test
    public void testGetValidBattle() {
        assertEquals(game.getBattle(2), "TODO");
    }

    /**
     * Get details of an invalid battle.
     */
    @Test
    public void testGetInvalidBattle() {
        assertEquals(game.getBattle(-1), "TODO");
    }

    /**
     * Test if all battles are displayed.
     */
    @Test
    public void testGetAllBattles() {
        assertEquals(game.getAllBattles(), "TODO");
    }

    /**
     * Test if all forces are displayed.
     */
    @Test
    public void testGetAllForces() {
        assertEquals(game.getAllForces(), "TODO");
    }

    /**
     * Test if all forces in the dock are displayed.
     */
    @Test
    public void testGetAllForcesInDock() {
        assertEquals(game.getForcesInDock(), "TODO");
    }

    /**
     * Test if a valid force is in the dock.
     */
    @Test
    public void testValidForceInDock() {
        assertTrue(game.isInUFFDock("IW1"));
    }

    /**
     * Test if an invalid force is not in the dock.
     */
    @Test
    public void testInvalidForceNotInDock() {
        assertFalse(game.isInUFFDock("XX3"));
    }

    /**
     * Test if all destroyed forces are displayed.
     */
    @Test
    public void testGetDestroyedForces() {
        assertEquals(game.getDestroyedForces(), "TODO");
    }
}
