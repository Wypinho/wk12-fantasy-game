import Items.Treasure.Treasure;
import Items.Weapons.Sword;
import Players.Enemies.Enemy;
import Players.Healer.Cleric;
import Players.IDamage;
import Players.MeleeFighter.Knight;
import Players.Player;
import Quest.Quest;
import Quest.Rooms.Room;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Game {
    private ArrayList<Player> players;
    Scanner scanner;
    Quest quest;
    Room currentRoom;

    public Game(){
        this.players = new ArrayList<Player>();
        this.scanner = new Scanner(System.in);
        this.quest = new Quest();
        this.currentRoom = null;
    }

    public void playGame(){
        System.out.println("Welcome to Dragons & Dungeons!");
        this.playerSetUp();
        this.gameSetUp();
        for (int i = 0; i < quest.roomCount(); i++){
            currentRoom = quest.getCurrentRoom(i);
            this.enterRoom();
            this.describeRoom();
            this.playRoom();
            if (currentRoom.questFailed()){
                break;
            }
            this.exitRoom();

        }
        if (currentRoom.questFailed()){
            System.out.println("Your party are all slain - game over!");
        } else {
            System.out.println("Bravo brave adventurers - the dungeon is conquered!");
        }
    }

    private void playRoom() {
        Player player;
        while (!currentRoom.roomClear() && !currentRoom.questFailed()) {
            for (int i = 0; i < players.size(); i++) {
                if (currentRoom.roomClear() || currentRoom.questFailed()) {
                    break;
                }
                player = this.players.get(i);
                if (player instanceof IDamage) {
                    this.playerAttack(player);
                }
                currentRoom.checkForDead();
            }
        }
        if (currentRoom.roomClear()){
            this.lootTreasure();
        }
    }

    private void lootTreasure() {
        while (currentRoom.treasureCount() > 0) {
            for (Player player : this.players) {
                Treasure treasure = currentRoom.giveTreasure();
                player.addTreasure(treasure);
                String treasureAcquired = String.format("%s acquired %s!", player.getName(), treasure.getType());
                System.out.println(treasureAcquired);
            }
        }
//        ArrayList<Treasure> loot = currentRoom.giveTreasure();
//        for (Treasure treasure : loot){
    }

    private void playerAttack(Player player){
        Enemy enemy;
        String identifyPlayer = String.format("%s the %s, whom shall ye attack?", player.getName(), player.getType());
        System.out.println(identifyPlayer);
        for (int j=0; j<this.currentRoom.enemyCount(); j++){
            enemy = this.currentRoom.getEnemy(j);
            String identifyEnemy = String.format("Type %s for %s, health %s", j+1, enemy.getType(), enemy.getHealthPoints());
            System.out.println(identifyEnemy);
        }
        String enemySelection = scanner.next();
        int target = parseInt(enemySelection);

        Sword sword = new Sword();
//                casting - aaargh! how can I avoid this?
        ((IDamage) player).receiveNewWeapon(sword);
        enemy = currentRoom.getEnemy(target-1);
        ((IDamage) player).attack(enemy);
        String attackResult = String.format("The %s's health is down to %s!", enemy.getType(), enemy.getHealthPoints());
        System.out.println(attackResult);
        if (enemy.isDead()){
            String confirmKill = String.format("You killed the %s!", enemy.getType());
            System.out.println(confirmKill);
        }
    }

    private void describeRoom() {
        System.out.println("You are faced with:");
        for (int i = 0; i < currentRoom.enemyCount(); i++){
            String enemyType = currentRoom.getEnemyType(i);
            System.out.println(enemyType);
        }
        System.out.println("You espy:");
        for (int i = 0; i < currentRoom.treasureCount(); i++){
            String treasureType = currentRoom.getTreasureType(i);
            System.out.println(treasureType);
        }
    }

    private void enterRoom() {
        this.currentRoom.populateRoom(this.players);
    }

    private void exitRoom() {
        this.currentRoom.clearRoom();
    }

    private void gameSetUp() {
        System.out.println("Select thy difficulty level: Easy, Medium or Hard?");

        String difficultySelection = scanner.next();
        String difficulty = difficultySelection;

        if (difficultySelection.equals("Easy")){
            quest.generateQuest(1);
        } else if (difficultySelection.equals("Medium")){
            quest.generateQuest(2);
        } else if (difficultySelection.equals("Hard")){
            quest.generateQuest(3);
        }
    }

    private void playerSetUp() {
        System.out.println("How many shall brave the dungeon?");

        String input = scanner.next();
        int players = parseInt(input);

        for(int i = 0; i < players; i++){
            String namePrompt = String.format("Player %s, enter your name: ", (i + 1));
            System.out.println(namePrompt);
            String playerName = scanner.next();

            String classPrompt = String.format("Player %s, select your class: ", (i + 1));
            System.out.println(classPrompt);
            System.out.println("Select Knight or Cleric?");
            String playerClass = scanner.next();

            this.addPlayer(playerName, playerClass);
        }
    }

//    made public for testing access
    public void addPlayer(String playerName, String playerClass) {
        if (playerClass.equals("Knight")){
            Player player = new Knight(playerName);
            this.players.add(player);
        } else if (playerClass.equals("Cleric")){
            Player player = new Cleric(playerName);
            this.players.add(player);
        }
    }

    public int playerCount() {
        return this.players.size();
    }
}
