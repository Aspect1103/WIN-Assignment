package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Holds tests related to the saving/loading/reading.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 27/03/2023
 */
public class SaveLoadTest {
    // Define the WIN interface variable to use for testing
    WIN game;

    /**
     * Set up a test before it executes.
     */
    @Before
    public void setUp() {
        game = new SpaceWars("John");
    }

    /**
     * Test if saveGame saves the state given a valid filename.
     */
    @Test
    public void saveWithValidFilename() {}

    /**
     * Test if saveGame saves the state given an invalid filename.
     */
    @Test
    public void saveWithInvalidFilename() {}

    /**
     * Test if restoreGame loads the game given a valid filename.
     */
    @Test
    public void restoreWithValidFilename() {}

    /**
     * Test if restoreGame loads the game given an invalid filename.
     */
    @Test
    public void restoreWithInvalidFilename() {}

    /**
     * Test if restoreGame loads the game given a valid filename, but the file has no data inside.
     */
    @Test
    public void restoreWithEmptyFile() {}

    /**
     * Test if readBattles loads the battles given a valid filename.
     */
    @Test
    public void readWithValidFilename() {}

    /**
     * Test if readBattles loads the battles given an invalid filename.
     */
    @Test
    public void readWithInvalidFilename() {}

    /**
     * Test if readBattles loads the battles given a valid filename, but the file has no data inside.
     */
    @Test
    public void readWithEmptyFile() {}
}
