package Quest.Rooms;

import Items.Treasure.Treasure;
import Items.Weapons.Sword;
import Players.Enemies.Enemy;
import Players.IDamage;
import Players.Player;

import java.util.ArrayList;
import java.util.Random;

public class Room {

    private ArrayList<Treasure> treasures;
    private ArrayList<Player> playersInRoom;
    private ArrayList<Enemy> enemies;
    private Random random;

    public Room() {
        this.treasures = new ArrayList<Treasure>();
        this.playersInRoom = new ArrayList<Player>();
        this.enemies = new ArrayList<Enemy>();
        this.random = new Random;
    }

    public void addTreasure(Treasure treasure) {
        this.treasures.add(treasure);
    }

    public void populateRoom(ArrayList<Player> players){
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

    public Treasure giveTreasure() {
        return this.treasures.remove(0);
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

    public void enemiesPlay() {
        Enemy enemy;
        while (!this.roomClear() && !this.questFailed()) {
            for (int i = 0; i < this.enemies.size(); i++) {
                if (this.roomClear() || this.questFailed()) {
                    break;
                }
                enemy = this.enemies.get(i);
                this.enemyAttack(enemy);
                this.checkForDead();
            }
        }
    }

    private void enemyAttack(Enemy enemy) {
        Player player;
        String identifyEnemy = String.format("%s is attacking...", enemy.getType());
        System.out.println(identifyEnemy);
        for (int j=0; j<this.currentRoom.enemyCount(); j++){
            enemy = this.currentRoom.getEnemy(j);
            String identifyEnemy = String.format("Type %s for %s, health %s", j+1, enemy.getType(), enemy.getHealthPoints());
            System.out.println(identifyEnemy);
        }

        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }
        int target = scanner.nextInt();
        while (target < 1 || target > this.currentRoom.enemyCount()) {
            String validTargetPrompt = String.format("Please type a number between 1 and %s", this.currentRoom.enemyCount());
            System.out.println(validTargetPrompt);
            target = scanner.nextInt();
        }
//        temporarily assigning sword to fight
        Sword sword = new Sword();
//                casting - aaargh! how can I avoid this?
        ((IDamage) player).receiveNewWeapon(sword);
        enemy = currentRoom.getEnemy(target-1);
        ((IDamage) player).attack(enemy);
        if (enemy.isDead()){
            String confirmKill = String.format("%s the %s killed the %s!", player.getName(), player.getType(), enemy.getType());
            System.out.println(confirmKill);
        } else {
            String attackResult = String.format("The %s's health is down to %s!", enemy.getType(), enemy.getHealthPoints());
            System.out.println(attackResult);
        }
    }
}
