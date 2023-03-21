package Cwk4tests;

import cwk4.SpaceWars;
import cwk4.WIN;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class T2DisplayBattlesForcesTest {
    WIN swim;

    @Before
    public void setUp() {
        swim = new SpaceWars("Bob");
    }

    private boolean containsText2(String text, String s1, String s2, String s3) {
        return text.contains(s1) && text.contains(s2) && text.contains(s3);
    }

    @Test
    public void battleNo1Displayed() {
        assertTrue(containsText2(swim.getAllBattles(), "1", "Fight", "Borg"));
    }

    @Test
    public void battleNo2Displayed() {
        assertTrue(containsText2(swim.getAllBattles(), "2", "Skirmish", "Kardassians"));
    }

    @Test
    public void battleNo3Displayed() {
        assertTrue(containsText2(swim.getAllBattles(), "3", "Ambush", "Ferengi"));
    }

    @Test
    public void battleNo4Displayed() {
        assertTrue(containsText2(swim.getAllBattles(), "4", "Fight", "Ewoks"));
    }

    @Test
    public void battleNo5Displayed() {
        assertTrue(containsText2(swim.getAllBattles(), "5", "Ambush", "Borg"));
    }

    @Test
    public void battleNo6Displayed() {
        assertTrue(containsText2(swim.getAllBattles(), "6", "Skirmish", "Groaners"));
    }

    @Test
    public void forceFleetIW1Displayed() {
        assertTrue(containsText2(swim.getForcesInDock(), "IW1", "Twisters", ""));
    }

    @Test
    public void forceFleetSS2Displayed() {
        assertTrue(containsText2(swim.getForcesInDock(), "SS2", "Enterprise", ""));
    }


    @Test
    public void forceFleetWB3Displayed() {
        assertTrue(containsText2(swim.getForcesInDock(), "WB3", "Droop", ""));
    }

    @Test
    public void forceFleetIW4Displayed() {
        assertTrue(containsText2(swim.getForcesInDock(), "IW4", "Wingers", ""));
    }

    @Test
    public void forceFleetWB5Displayed() {
        assertTrue(containsText2(swim.getForcesInDock(), "WB5", "Hang", ""));
    }

    @Test
    public void forceFleetSS6Displayed() {
        assertTrue(containsText2(swim.getForcesInDock(), "SS6", "Voyager", ""));
    }

    @Test
    public void forceFleetSS7Displayed() {
        assertTrue(containsText2(swim.getForcesInDock(), "SS7", "Explorer", ""));
    }

    @Test
    public void forceFleetWB9Displayed() {
        assertTrue(containsText2(swim.getForcesInDock(), "WB9", "Hover", ""));
    }

    @Test
    public void forceFleetIW10Displayed() {
        assertTrue(containsText2(swim.getForcesInDock(), "IW10", "Flyers", ""));
    }
}
