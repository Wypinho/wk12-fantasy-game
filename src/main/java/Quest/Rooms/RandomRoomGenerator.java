package Quest.Rooms;

import Items.Treasure.Gem;
import Items.Treasure.Gold;
import Items.Treasure.Treasure;
import Players.Enemies.Enemy;
import Players.Enemies.Orc;
import Players.Enemies.Troll;

import java.util.ArrayList;
import java.util.Random;

public class RandomRoomGenerator {
    private ArrayList<Enemy> potentialEnemies;
    private ArrayList<Treasure> potentialTreasure;
    private Random random;

    public RandomRoomGenerator(){
        this.random = new Random();
        this.potentialEnemies = new ArrayList<Enemy>();
        this.potentialTreasure = new ArrayList<Treasure>();
    }

    public int potentialEnemiesCount() {
        return this.potentialEnemies.size();
    }

    public int potentialTreasureCount() {
        return this.potentialTreasure.size();
    }

    public Room generateRoom(int difficulty){
        this.generatePotentialEnemies(difficulty);
        this.generatePotentialTreasure(difficulty);
        Room room = new Room();
        this.populateRoomWithEnemies(difficulty, room);
        this.populateRoomWithTreasure(difficulty, room);
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

    private void populateRoomWithTreasure(int difficulty, Room room){
        int timesToRepeat = difficulty;
        Treasure treasure = null;
        while (timesToRepeat > 0){
            treasure = this.potentialTreasure.get(random.nextInt(this.potentialTreasure.size()));
            room.addTreasure(treasure);
            this.potentialTreasure.remove(treasure);
            timesToRepeat -= 1;
        }
    }
}
