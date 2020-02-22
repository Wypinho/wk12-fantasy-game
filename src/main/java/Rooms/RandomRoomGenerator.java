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
    private Gold gold;
    private Gold gold1;
    private Gold gold2;
    private Gem gem;
    private Gem gem1;
    private Gem gem2;
    private ArrayList<Enemy> potentialEnemies;
    private ArrayList<Treasure> potentialTreasure;
    private Random random;

    public RandomRoomGenerator(){
        this.random = new Random();
        this.potentialEnemies = new ArrayList<Enemy>();
        this.gold = new Gold();
        this.gold1 = new Gold();
        this.gold2 = new Gold();
        this.gem = new Gem();
        this.gem1 = new Gem();
        this.gem2 = new Gem();
        this.potentialTreasure = new ArrayList<Treasure>(Arrays.asList(gold, gold1, gold2, gem, gem1, gem2));
    }

    public int potentialEnemiesCount() {
        return this.potentialEnemies.size();
    }

    public Room generateRoom(int difficulty){
        this.generatePotentialEnemies(difficulty);
        this.generatePotentialTreasure(difficulty);
        Room room = new Room();
        this.populateRoomWithEnemies(difficulty, room);
        return room;
    }

    private void generatePotentialEnemies(int difficulty){
        for (int i = 0; i < 6; i++) {
            Orc orc = new Orc();
            this.potentialEnemies.add(orc);
        }
        if (difficulty > 2){
            for (int j = difficulty - 2; j > 0; j--){
                Troll troll = new Troll();
                this.potentialEnemies.add(troll);
            }
        }
    }

    private void generatePotentialTreasure(int difficulty){
        for (int i = 0; i < 6; i++) {
            Gold gold = new Gold();
            this.potentialTreasure.add(gold);
        }
        if (difficulty > 2){
            for (int j = difficulty - 2; j > 0; j--){
                Gem gem = new Gem();
                this.potentialTreasure.add(gem);
            }
        }
    }

    private void populateRoomWithEnemies(int difficulty, Room room){
        int timesToRepeat = difficulty;
        Enemy enemy = null;
        while (timesToRepeat > 0){
            enemy = this.potentialEnemies.get(random.nextInt(this.potentialEnemies.size()));
            room.addEnemy(enemy);
            this.potentialEnemies.remove(enemy);
            timesToRepeat -= 1;
        }
    }
}
