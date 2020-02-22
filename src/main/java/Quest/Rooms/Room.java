package Quest.Rooms;

import Items.Treasure.Treasure;
import Players.Enemies.Enemy;
import Players.Player;

import java.util.ArrayList;

public class Room {

    private ArrayList<Treasure> treasures;
    private ArrayList<Player> players;
    private ArrayList<Enemy> enemies;

    public Room() {
        this.treasures = new ArrayList<Treasure>();
        this.players = new ArrayList<Player>();
        this.enemies = new ArrayList<Enemy>();
    }

    public void addTreasure(Treasure treasure) {
        this.treasures.add(treasure);
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public int getPlayerCount() {
        return this.players.size();
    }

    public ArrayList<Treasure> giveTreasure() {
        ArrayList<Treasure> treasuresCopy = new ArrayList<Treasure>(this.treasures);
        this.treasures.clear();
        return treasuresCopy;
    }


    public int treasureCount() {
        return this.treasures.size();
    }

    public int enemyCount() {
        return this.enemies.size();
    }
}
