package Rooms;

import Items.Treasure.Gem;
import Items.Treasure.Gold;
import Items.Treasure.Treasure;
import Players.Enemies.Enemy;
import Players.Enemies.Orc;
import Players.Enemies.Troll;

import java.util.ArrayList;
import java.util.Arrays;

public class RandomRoomGenerator {
    private Orc orc;
    private Troll troll;
    private Gold gold;
    private Gem gem;
    private ArrayList<Enemy> potentialEnemies;
    private ArrayList<Treasure> potentialTreasure;

    public RandomRoomGenerator(){
        this.orc = new Orc();
        this.troll = new Troll();
        this.potentialEnemies = new ArrayList<Enemy>(Arrays.asList(orc, troll));
    }

    public int potentialEnemiesCount() {
        return this.potentialEnemies.size();
    }
}
