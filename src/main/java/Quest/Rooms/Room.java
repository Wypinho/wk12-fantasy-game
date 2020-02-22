package Quest.Rooms;

import Items.Treasure.Treasure;
import Players.Enemies.Enemy;
import Players.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Room {

    private ArrayList<Treasure> treasures;
    private ArrayList<Player> playersInRoom;
    private ArrayList<Enemy> enemies;

    public Room() {
        this.treasures = new ArrayList<Treasure>();
        this.playersInRoom = new ArrayList<Player>();
        this.enemies = new ArrayList<Enemy>();
    }

    public void addTreasure(Treasure treasure) {
        this.treasures.add(treasure);
    }

    public void populateRoom(ArrayList<Player> players){
//        ArrayList<Player> newPlayers = new ArrayList<Player>();
//        Collections.copy(this.playersInRoom, players);
//        this.playersInRoom = newPlayers;
        Player player = null;
        for (int i=0; i<players.size(); i++){
            player = players.get(i);
            this.playersInRoom.add(player);
        }
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public int getPlayerCount() {
        return this.playersInRoom.size();
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

    public String getEnemyType(int index) {
        String type = this.enemies.get(index).getType();
        String enemyDescription = "";
        if (type.equals("Orc")){
            enemyDescription = String.format("A hideous %s!", type);
        } else if (type.equals("Troll")){
            enemyDescription = String.format("An enormous %s!", type);
        }
        return enemyDescription;
    }

    public String getTreasureType(int index) {
        String type = this.treasures.get(index).getType();
        String treasureDescription = "";
        if (type.equals("Gold")){
            treasureDescription = String.format("Some gleaming %s!", type);
        } else if (type.equals("Gem")){
            treasureDescription = String.format("A glittering %s!", type);
        }
        return treasureDescription;
    }

    public void clearRoom() {
        this.playersInRoom.clear();
    }

    public Enemy getEnemy(int index) {
        return this.enemies.get(index);
    }

    public void checkForDead() {
        ArrayList<Enemy> enemiesAlive = new ArrayList<Enemy>();
        for (Enemy enemy : this.enemies){
            if (!enemy.isDead()){
                enemiesAlive.add(enemy);
            }
        }
        this.enemies = enemiesAlive;

        ArrayList<Player> playersAlive = new ArrayList<Player>();
        for (Player player : this.playersInRoom){
            if (!player.isDead()){
                playersAlive.add(player);
            }
        }
        this.playersInRoom = playersAlive;
    }

    public boolean roomClear(){
        return this.enemies.size() == 0;
    }

    public boolean questFailed(){
        return this.playersInRoom.size() == 0;
    }
}
