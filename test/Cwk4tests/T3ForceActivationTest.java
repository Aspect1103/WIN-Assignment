package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class T3ForceActivationTest {
    WIN game;

    @Before
    public void setUp() {
        game = new SpaceWars("Olenka");
    }

    @Test
    public void forceActivationReturn() {
        assertEquals(game.activateForce("IW1"), 0);
    }

    @Test
    public void forceActivationWorks() {
        String forceRef = "IW1";
        game.activateForce(forceRef);
        assertTrue(game.isInASFleet(forceRef));
    }

    @Test
    public void warchestAfterForceActivated() {
        game.activateForce("IW1");
        assertEquals(800, game.getWarchest());
    }

    @Test
    public void statusActiveForActivatedForce() {
        game.activateForce("IW1");
        assertTrue(game.getForceDetails("IW1").toLowerCase().contains("active"));
    }

    @Test
    public void notEnoughCreditInWarchest() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.activateForce("WB5");
        assertEquals(200, game.getWarchest());
    }

    @Test
    public void returnValueForNotEnoughInWarchest() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        assertEquals(2, game.activateForce("WB5"));
    }

    @Test
    public void returnValueForNotEnoughInWarchestOnNonExistentForce() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.activateForce("WB5");
        assertEquals(-1, game.activateForce("XX3"));
    }

    @Test
    public void reactivateExistingForceHasNoEffectOnWarchest() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.activateForce("IW1");
        assertEquals(200, game.getWarchest());
    }

    @Test
    public void forceRecallUpdatesWarchestForActivatedForce() {
        game.activateForce("WB5");
        game.recallForce("WB5");
        assertEquals(800, game.getWarchest());
    }

    @Test
    public void forceRecallDoesNotUpdateWarchestForNonActiveForce() {
        game.activateForce("WB5");
        game.recallForce("WB5");
        game.recallForce("IW1"); // Not activated
        assertEquals(800, game.getWarchest());
    }

    @Test
    public void forceRecallDoesNotUpdateWarchestForNonExistentForce() {
        game.activateForce("WB5");
        game.recallForce("WB5");
        game.recallForce("XX3");
        assertEquals(800, game.getWarchest());
    }
}
