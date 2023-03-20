import java.util.*;
import java.util.ArrayList;

/**
 * Write a description of class Admiral here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Admiral implements WIN
{
    private ArrayList<Battle> Battles = new ArrayList<Battle>();
    private ArrayList<Force> Available = new ArrayList<Force>();
    private ArrayList<Force> Destroyed = new ArrayList<Force>();
    //private ArrayList<ASF> ASF1 = new ArrayList<ASF>();

    private String name;
    private int chest;

    /**
     * Constructor for objects of class Admiral
     */
    public Admiral(String n)
    {
        name = n;
        this.chest = 1000;
        loadBattles();
        loadForces();


    }

    /**
     * List of available forces
     */
    public String toString()
    {
        String s;

        s = "*************************\nAvailable Forces\n-------------------------";
        for (Force fTemp : Available)
        {
            s = s + fTemp.toString() + "\n";
            //s = s + fTemp.getPassList() + "\n-------------------------\n";
        }
        s = s + "\n*************************\n\n";
        return s;
    }

    /**
     * Returns Chest Total
     */
    public int getChest()
    {
        return chest;
    }

    /**
     * Returns Activate Forces
     */
    public Force activateForces(String ref)
    {
        for(Force temp: Available)
        {
            if (temp.getReference() == ref)
            {
                return temp;
            }
        }
        return null;
    }

    public boolean canActivate(String ref)
    {
        Force f = getForce(ref);
        if (f.getFee() < getChest())
        {
            return true;
        }
        else return false;
    }

    /**
     *
     */
    private void loadBattles()  //so we have the data ready
    {
        Battles.add(new Battle(1, "Fight", "Borg", 200, 300, 100));
        Battles.add(new Battle(2, "Skirmish", "Kardassians", 700, 200, 120));
        Battles.add(new Battle(3, "Amubush", "Ferengi", 100, 400, 150));
        Battles.add(new Battle(4, "Fight", "Ewoks", 600, 600, 200));
        Battles.add(new Battle(5, "Ambush", "Borg", 500, 400, 90));
        Battles.add(new Battle(6, "Skirmish", "Groaners", 150, 100, 100));
        Battles.add(new Battle(7, "Fight", "Borg", 150, 500, 300));
        Battles.add(new Battle(8, "Ambush", "Wailers", 300, 300, 300));
    }

    private void loadForces()  //so we have the data ready
    {
        Force wi1 = new Wing("IW1", "Twister", 200, 200, 10);
        Available.add(wi1);
        Force st2 = new Starship("SS2", "Enterprise", 300, 200, 10, 20);
        Available.add(st2);
        Force wa3 = new WarBird("WB3", "Droop", 300, 100, false);
        Available.add(wa3);
        Force wi4 = new Wing("IW4", "Winger", 200, 400, 20);
        Available.add(wi4);
        Force wa5 = new WarBird("WB5", "Hang", 400, 300, true);
        Available.add(wa5);
        Force st6 = new Starship("SS6", "Voyager", 450, 200, 15, 10);
        Available.add(st6);
        Force st7 = new Starship("SS7", "Explorer", 120, 65, 4, 5);
        Available.add(st7);
        Force wa9 = new WarBird("WB9", "Hover", 300, 400, false);
        Available.add(wa9);
        Force wi10 = new Wing("IW10", "Flyer", 200, 100, 5);
        Available.add(wi10);
    }

    /** Returns the Force with the Force Reference specified by the parameter
     * @param ref - Reference of Force
     * @return the Force with the specified Reference
     **/
    private Force getForce(String ref)
    {
        for(int i = 0; i < Available.size(); i++)
        {
            Force temp = Available.get(i);
            if(temp.getReference() == ref)
            {
                return temp;
            }
        }
        return null;
    }

    /** Returns the ferry with the ferry code specified by the parameter
     * @param fer - Journey Code
     * @return the island with the specified name
     **/
    private Battle getBattle(int bNo)
    {
        for(Battle temp : Battles)
        {
            int no = temp.getBattleNumber();
            if(no == bNo)
            {
                return temp;
            }
        }
        return null;
    }
}
