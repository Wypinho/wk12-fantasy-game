package Quest.Rooms;

import Items.HealingItems.IHealable;
import Items.Treasure.Treasure;
import Items.Weapons.IWeapon;
import Players.Enemies.Enemy;
import Players.Player;

import java.util.ArrayList;
import java.util.Random;

public class Room {

    private ArrayList<Treasure> treasures;
    private ArrayList<Player> playersInRoom;
    private ArrayList<Enemy> enemies;
    private ArrayList<IWeapon> weapons;
    private ArrayList<IHealable> healingItems;
    private Random random;

    public Room() {
        this.treasures = new ArrayList<Treasure>();
        this.playersInRoom = new ArrayList<Player>();
        this.enemies = new ArrayList<Enemy>();
        this.weapons = new ArrayList<IWeapon>();
        this.healingItems = new ArrayList<IHealable>();
        this.random = new Random();
    }

    public void addWeapon(IWeapon weapon) {
        this.weapons.add(weapon);
    }

    public void addHealingItem(IHealable healingItem) {
        this.healingItems.add(healingItem);
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
            for (int i = 0; i < this.enemies.size(); i++) {
                if (this.questFailed()) {
                    break;
                }
                enemy = this.enemies.get(i);
                this.enemyAttack(enemy);
                this.checkForDead();
            }
    }

    private void enemyAttack(Enemy enemy) {
        Player player;
        int victimIndex = random.nextInt(this.playersInRoom.size());
        player = this.playersInRoom.get(victimIndex);
        String identifyEnemy = String.format("%s is attacking %s the %s!", enemy.getType(), player.getName(), player.getType());
        System.out.println(identifyEnemy);

        enemy.attack(player);
        if (player.isDead()){
            String confirmKill = String.format("%s killed %s the %s!", enemy.getType(), player.getName(), player.getType());
            System.out.println(confirmKill);
        } else {
            String attackResult = String.format("%s the %s's health is down to %s!", player.getName(), player.getType(), player.getHealthPoints());
            System.out.println(attackResult);
        }
    }
}
