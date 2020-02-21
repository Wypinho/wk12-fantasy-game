package Rooms;

import Items.Treasure.Gem;
import Items.Treasure.Gold;
import Items.Treasure.Treasure;
import Players.Enemies.Enemy;
import Players.Enemies.Orc;
import Players.Enemies.Troll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomRoomGenerator {
    private Orc orc;
    private Orc orc1;
    private Orc orc2;
    private Troll troll;
    private Troll troll1;
    private Troll troll2;
    private Gold gold;
    private Gold gold1;
    private Gold gold2;
    private Gem gem;
    private Gem gem1;
    private Gem gem2;
    private ArrayList<Enemy> potentialEnemies;
    private ArrayList<Enemy> usedEnemies;
    private ArrayList<Treasure> potentialTreasure;
    private ArrayList<Treasure> usedTreasure;
//    private int difficulty;
//    private Room room;
    private Random random;

    public RandomRoomGenerator(){
//        this.room = new Room();
        this.random = new Random();
//        this.difficulty = difficulty;
        this.orc = new Orc();
        this.orc1 = new Orc();
        this.orc2 = new Orc();
        this.troll = new Troll();
        this.troll1 = new Troll();
        this.troll2 = new Troll();
        this.potentialEnemies = new ArrayList<Enemy>(Arrays.asList(orc, orc1, orc2, troll, troll1, troll2));
        this.usedEnemies = new ArrayList<Enemy>();
        this.gold = new Gold();
        this.gold1 = new Gold();
        this.gold2 = new Gold();
        this.gem = new Gem();
        this.gem1 = new Gem();
        this.gem2 = new Gem();
        this.potentialTreasure = new ArrayList<Treasure>(Arrays.asList(gold, gold1, gold2, gem, gem1, gem2));
        this.usedTreasure = new ArrayList<Treasure>();
    }

    public int potentialEnemiesCount() {
        return this.potentialEnemies.size();
    }

    public Room generateRoom(int difficulty){
        Room room = new Room();
        this.populateRoomWithEnemies(difficulty, room);
        return room;
    }

    private void populateRoomWithEnemies(int difficulty, Room room){
        int timesToRepeat = difficulty;
        while (timesToRepeat > 0){

            room.addEnemy(this.potentialEnemies.get(random.nextInt(this.potentialEnemies.size())));
            timesToRepeat -= 1;
        }
    }
}
