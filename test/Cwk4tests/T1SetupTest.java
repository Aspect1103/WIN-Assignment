package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class T1SetupTest {
    WIN game;

    @Before
    public void setUp() {
        game = new SpaceWars("David");
    }

    private boolean containsText(String text, String[] str) {
        boolean result = true;
        for (String temp : str) {
            result = result && (text.toLowerCase()).contains(temp.toLowerCase());
        }
        return result;
    }

    @Test
    public void gameCorrectlyInitialised() {
        String[] details = {"David", "1000", ""};
        assertTrue(containsText(game.toString(), details));
    }

    @Test
    public void warChestWhenNoBattle() {
        assertEquals(1000, game.getWarchest());
    }

    @Test
    public void battleAtSetup() {
        assertTrue(game.isBattle(3));
    }

    @Test
    public void allBattleLoadedAtSetup() {
        boolean result = true;
        for (int i = 1; i < 8; i++) {
            result = result && game.isBattle(i);
        }
        assertTrue(result);
    }

    @Test
    public void forceInUFFAtSetup() {
        assertTrue(game.isInUFFDock("IW1"));
    }

    @Test
    public void UFFleetLoadedAtTheBeginning() {
        boolean result = true;
        String[] forces = {"IW1", "WB3", "SS2", "IW4", "WB5", "SS6", "SS7", "WB9", "IW10"};
        for (String force : forces) {
            result = result && game.isInUFFDock(force);
        }
        assertTrue(result);
    }

    @Test
    public void ASFleetEmptyAtTheBeginning() {
        boolean result = true;
        String[] forces = {"IW1", "WB3", "SS2", "IW4", "WB5", "SS6", "SS7", "WB9", "IW10"};
        for (String force : forces) {
            result = result && !game.isInASFleet(force);
        }
        assertTrue(result);
    }

    @Test
    public void detailsOfWB3() {
        String[] target = {"WB3", "Droop", "100", "300", "In dock", "false"};
        assertTrue(containsText(game.getForceDetails("WB3"), target));
    }

    @Test
    public void detailsOfSS2() {
        String[] target = {"SS2", "Enterprise", "200", "300", "In dock", "20", "10"};
        assertTrue(containsText(game.getForceDetails("SS2"), target));
    }

    @Test
    public void detailsOfIW1() {
        String[] target = {"IW1", "Twisters", "200", "200", "In dock", "10"};
        assertTrue(containsText(game.getForceDetails("IW1"), target));
    }

    @Test
    public void detailsOfNonExistantForce() {
        String[] target = {"No such force"};
        assertTrue(containsText(game.getForceDetails("XX3"), target));
    }

    @Test
    public void detailsOfBattle() {
        String[] details = {"2", "Skirmish", "Kardassians", "700", "200", "120"};
        assertTrue(containsText(game.getBattle(2), details));
    }
}
