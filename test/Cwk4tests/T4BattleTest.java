package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class T4BattleTest {
    WIN game;

    @Before
    public void setUp() {
        game = new SpaceWars("Jean");
    }

    @Test
    public void wingFacingSkirmishWins() {
        game.activateForce("IW1");
        game.doBattle(6);
        assertEquals(900, game.getWarchest());
    }

    @Test
    public void wingFacingSkirmishLoseOnStrength() {
        game.activateForce("IW1");
        game.doBattle(2);
        assertEquals(600, game.getWarchest());
    }

    @Test
    public void wingFacingAmbushWins() {
        game.activateForce("IW1");
        game.doBattle(3);
        assertEquals(950, game.getWarchest());
    }

    @Test
    public void wingFacingAmbushLoseOnSkill() {
        game.activateForce("IW1");
        game.doBattle(5);
        assertEquals(400, game.getWarchest());
    }

    @Test
    public void wingFacingBattleNotAllowed() {
        game.activateForce("IW1");
        game.doBattle(1);
        assertEquals(500, game.getWarchest());
    }

    @Test
    public void starshipFacingSkirmishWins() {
        game.activateForce("SS6");
        game.doBattle(6);
        assertEquals(650, game.getWarchest());
    }

    @Test
    public void starshipFacingSkirmishLoseOnStrength() {
        game.activateForce("SS2");
        game.doBattle(2);
        assertEquals(500, game.getWarchest());
    }

    @Test
    public void starshipFacingAmbushNotAllowed() {
        game.activateForce("SS2");
        game.doBattle(3);
        assertEquals(300, game.getWarchest());
    }

    @Test
    public void starshipFacingBattleWins() {
        game.activateForce("SS6");
        game.doBattle(1);
        assertEquals(650, game.getWarchest());
    }

    @Test
    public void starshipFacingBattleLoseOnStrength() {
        game.activateForce("SS7");
        game.doBattle(1);
        assertEquals(580, game.getWarchest());
    }

    @Test
    public void warbirdFacingSkirmishNotAllowed() {
        game.activateForce("WB9");
        game.doBattle(6);
        assertEquals(600, game.getWarchest());
    }

    @Test
    public void warbirdNoCloakingFacingAmbushNotAllowed() {
        game.activateForce("WB9");
        game.doBattle(3);
        assertEquals(300, game.getWarchest());
    }

    @Test
    public void warbirdWithCloakingFacingAmbushWins() {
        game.activateForce("WB5");
        game.doBattle(3);
        assertEquals(750, game.getWarchest());
    }

    @Test
    public void warbirdWithCloakingFacingAmbushLoseOnStrength() {
        game.activateForce("WB5");
        game.doBattle(5);
        assertEquals(200, game.getWarchest());
    }

    @Test
    public void warbirdFacingBattleWinsOnStrength() {
        game.activateForce("WB5");
        game.doBattle(1);
        assertEquals(700, game.getWarchest());
    }

    @Test
    public void warbirdFacingBattleLoseOnStrength() {
        game.activateForce("WB3");
        game.doBattle(4);
        assertEquals(100, game.getWarchest());
    }

    @Test
    public void recallingDestroyedForceInFightDoesntAffectWarchest() {
        game.activateForce("IW1");
        game.doBattle(2);
        game.recallForce("IW1");
        assertEquals(600, game.getWarchest());
    }

    @Test
    public void recallingDestroyedInFightForceDoesntAffectWarchestOnReactivation() {
        game.activateForce("IW1");
        game.doBattle(2);
        game.activateForce("IW1");
        assertEquals(600, game.getWarchest());
    }

    @Test
    public void checkNotDefeatedWhileStillActiveForces() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.doBattle(4);
        game.doBattle(5);
        assertFalse(game.isDefeated());
    }

    @Test
    public void checkDefeatedWhenGoingBust() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.doBattle(4);
        game.doBattle(5);
        game.doBattle(4);
        assertTrue(game.isDefeated());
    }
}
