import Items.HealingItems.Herb;
import Items.HealingItems.IHealable;
import Items.HealingItems.Potion;
import Items.Spells.Burn;
import Items.Spells.Freeze;
import Items.Spells.ISpell;
import Items.Treasure.Treasure;
import Items.Weapons.Axe;
import Items.Weapons.Club;
import Items.Weapons.IWeapon;
import Items.Weapons.Sword;
import Players.Enemies.Enemy;
import Players.Healer.Cleric;
import Players.MagicalFighter.Wizard;
import Players.MeleeFighter.Barbarian;
import Players.MeleeFighter.Dwarf;
import Players.MeleeFighter.Knight;
import Players.Player;
import Quest.Quest;
import Quest.Rooms.Room;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    private Scanner scanner;
    private Quest quest;
    private Room currentRoom;
    private Random random;
    private ArrayList<IWeapon> potentialWeapons;
    private ArrayList<IHealable> potentialHealingItems;
    private ArrayList<ISpell> potentialSpells;

    public Game(){
        this.players = new ArrayList<Player>();
        this.scanner = new Scanner(System.in);
        this.quest = new Quest();
        this.currentRoom = null;
        this.random = new Random();
        this.potentialWeapons = new ArrayList<IWeapon>();
        this.potentialHealingItems = new ArrayList<IHealable>();
        this.potentialSpells = new ArrayList<ISpell>();
    }

    public void playGame(){
        System.out.println("Welcome to Dragons & Dungeons!");
        this.playerSetUp();
        this.gameSetUp();
        this.generatePotentialObjects();
        this.equipStartingObjects();
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
        if (this.questFailed()){
            System.out.println("Your party are all slain - game over!");
        } else {
            System.out.println("Bravo brave adventurers - the dungeon is conquered!");
        }
    }

    private void generatePotentialObjects() {
        for (int i = 0; i < 3; i++) {
            Sword sword = new Sword();
            this.potentialWeapons.add(sword);
        }
        for (int i = 0; i < 3; i++) {
            Axe axe = new Axe();
            this.potentialWeapons.add(axe);
        }
        for (int i = 0; i < 3; i++) {
            Club club = new Club();
            this.potentialWeapons.add(club);
        }
        for (int i = 0; i < 3; i++) {
            Burn burn = new Burn();
            this.potentialSpells.add(burn);
        }
        for (int i = 0; i < 3; i++) {
            Freeze freeze = new Freeze();
            this.potentialSpells.add(freeze);
        }
        for (int i = 0; i < 3; i++) {
            Herb herb = new Herb();
            this.potentialHealingItems.add(herb);
        }
        for (int i = 0; i < 3; i++) {
            Potion potion = new Potion();
            this.potentialHealingItems.add(potion);
        }
    }

    private void equipStartingObjects() {
        for (Player player : this.players){
            if (player.getType().equals("Cleric")) {
                IHealable healingItem = this.potentialHealingItems.get(random.nextInt(this.potentialHealingItems.size()));
                player.receiveNewHealingItem(healingItem);
                String confirmHealerItem = String.format("%s the %s received a %s?", player.getName(), player.getType(), healingItem.getType());
                System.out.println(confirmHealerItem);
                this.potentialHealingItems.remove(healingItem);

                IWeapon weapon = this.potentialWeapons.get(random.nextInt(this.potentialWeapons.size()));
                player.receiveNewWeapon(weapon);
                String confirmHealerWeapon = String.format("%s the %s received a %s?", player.getName(), player.getType(), weapon.getType());
                System.out.println(confirmHealerWeapon);
                this.potentialWeapons.remove(weapon);
            } else if (player.getType().equals("Wizard")) {
                ISpell spell = this.potentialSpells.get(random.nextInt(this.potentialSpells.size()));
                player.receiveNewSpell(spell);
                String confirmSpell = String.format("%s the %s received a %s?", player.getName(), player.getType(), spell.getType());
                System.out.println(confirmSpell);
                this.potentialSpells.remove(spell);
            } else {
                IWeapon weapon = this.potentialWeapons.get(random.nextInt(this.potentialWeapons.size()));
                player.receiveNewWeapon(weapon);
                String confirmHealerWeapon = String.format("%s the %s received a %s?", player.getName(), player.getType(), weapon.getType());
                System.out.println(confirmHealerWeapon);
                this.potentialWeapons.remove(weapon);
            }
        }
    }

    private boolean questFailed() {
        return this.players.size() == 0;
    }

    private void playRoom() {
        Player player;
        while (!currentRoom.roomClear() && !currentRoom.questFailed()) {
            for (int i = 0; i < players.size(); i++) {
                if (currentRoom.roomClear() || currentRoom.questFailed()) {
                    break;
                }
                player = this.players.get(i);

                if (player.getType().equals("Cleric")) {
                    String identifyPlayer = String.format("%s the %s, shall ye Attack or Heal?", player.getName(), player.getType());
                    System.out.println(identifyPlayer);
                    String actionSelection = scanner.next();
                    while (!actionSelection.equals("Attack") && !actionSelection.equals("Heal")) {
                        System.out.println("Please type 'Attack' or 'Heal'?");
                        actionSelection = scanner.next();
                    }
                    if (actionSelection.equals("Attack")) {
                        this.playerAttack(player);
                    } else {
                        this.playerHeal(player);
                    }
                }
                else {
                    this.playerAttack(player);
                }
                currentRoom.checkForDead();
                this.checkForDead();
            }
//            all logic should maybe be in Game but enemies live in Room...???
            currentRoom.enemiesPlay();
            this.checkForDead();
        }
        if (currentRoom.roomClear()){
            this.lootTreasure();
            if (!quest.lastRoom(currentRoom)) {
                this.lootObjects();
            }
        }
    }

    private void lootObjects() {
        Player player;
        ArrayList<IWeapon> weapons = currentRoom.getWeapons();
        for (IWeapon weapon : weapons){
            String weaponOptions = String.format("You found a %s. What is to be done?", weapon.getType());
            System.out.println(weaponOptions);
            for (int j=0; j<this.players.size(); j++){
                player = this.players.get(j);
                if (!player.getType().equals("Wizard")) {
                    String weaponAssignOptions = String.format("Type %s to assign to %s the %s, current weapon is %s", j + 1, player.getName(), player.getType(), player.getWeapon().getType());
                    System.out.println(weaponAssignOptions);
                }
            }
            String weaponDiscardOption = String.format("Type %s to discard the %s.", this.players.size() + 1, weapon.getType());
            System.out.println(weaponDiscardOption);

            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            int weaponChoice = scanner.nextInt();
            while (weaponChoice < 1 || weaponChoice > this.players.size() + 1) {
                String validPrompt = String.format("Please type a number between 1 and %s", this.players.size() + 1);
                System.out.println(validPrompt);
                weaponChoice = scanner.nextInt();
            }
            if (weaponChoice < this.players.size() + 1){
                player = this.players.get(weaponChoice-1);
                player.receiveNewWeapon(weapon);
                String weaponConfirm = String.format("The %s has been allocated to %s the %s!", weapon.getType(), player.getName(), player.getType());
                System.out.println(weaponConfirm);
            } else {
                String weaponConfirm = String.format("The %s has been discarded!", weapon.getType());
                System.out.println(weaponConfirm);
            }
        }

        ArrayList<IHealable> healingItems = currentRoom.getHealingItems();
        for (IHealable healingItem : healingItems){
            String healingItemOptions = String.format("You found a %s. What is to be done?", healingItem.getType());
            System.out.println(healingItemOptions);
            for (int j=0; j<this.players.size(); j++){
                player = this.players.get(j);
                if (player.getType().equals("Cleric")){
                    String healingItemAssignOptions = String.format("Type %s to assign to %s the %s, current healing item is %s.", j+1, player.getName(), player.getType(), player.getHealingItem().getType());
                    System.out.println(healingItemAssignOptions);
                } else {
                    String healingItemUseOptions = String.format("Type %s to heal %s the %s, health %s.", j+1, player.getName(), player.getType(), player.getHealthPoints());
                    System.out.println(healingItemUseOptions);
                }
            }
            String healingItemDiscardOption = String.format("Type %s to discard the %s.", this.players.size() + 1, healingItem.getType());
            System.out.println(healingItemDiscardOption);

            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            int healingItemChoice = scanner.nextInt();
            while (healingItemChoice < 1 || healingItemChoice > this.players.size() + 1) {
                String validPrompt = String.format("Please type a number between 1 and %s", this.players.size() + 1);
                System.out.println(validPrompt);
                healingItemChoice = scanner.nextInt();
            }
            if (healingItemChoice < this.players.size() + 1){
                player = this.players.get(healingItemChoice-1);
                if (player.getType().equals("Cleric")) {
                    player.receiveNewHealingItem(healingItem);
                    String healingItemConfirm = String.format("The %s has been allocated to %s the %s!", healingItem.getType(), player.getName(), player.getType());
                    System.out.println(healingItemConfirm);
                } else {
                    player.beHealed(healingItem.getHealingPower());
                    String healingItemConfirm = String.format("%s the %s's health is now %s!", player.getName(), player.getType(), player.getHealthPoints());
                    System.out.println(healingItemConfirm);
                }
            } else {
                String healingItemConfirm = String.format("The %s has been discarded!", healingItem.getType());
                System.out.println(healingItemConfirm);
            }
        }

        ArrayList<ISpell> spells = currentRoom.getSpells();
//        int magicalFighterCount = 0;
        for (ISpell spell : spells){
            String spellOptions = String.format("You found a %s spell. What is to be done?", spell.getType());
            System.out.println(spellOptions);
            for (int j=0; j<this.players.size(); j++){
                player = this.players.get(j);
                if (player.getType().equals("Wizard")) {
//                    magicalFighterCount += 1;
                    String spellAssignOptions = String.format("Type %s to assign to %s the %s, current spell is %s", j + 1, player.getName(), player.getType(), player.getSpell().getType());
                    System.out.println(spellAssignOptions);
                }
            }
            String spellDiscardOption = String.format("Type %s to discard the %s spell.", this.players.size() + 1, spell.getType());
            System.out.println(spellDiscardOption);

            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            int spellChoice = scanner.nextInt();
            while (spellChoice < 1 || spellChoice > this.players.size() + 1) {
                String validPrompt = String.format("Please type a number between 1 and %s", this.players.size() + 1);
                System.out.println(validPrompt);
                spellChoice = scanner.nextInt();
            }
            if (spellChoice < this.players.size() + 1){
//                int playerIndex = this.players.indexOf(player);
                player = this.players.get(spellChoice-1);
                player.receiveNewSpell(spell);
                String spellConfirm = String.format("The %s spell has been allocated to %s the %s!", spell.getType(), player.getName(), player.getType());
                System.out.println(spellConfirm);
            } else {
                String spellConfirm = String.format("The %s has been discarded!", spell.getType());
                System.out.println(spellConfirm);
            }
        }
    }

    private void playerHeal(Player player) {
        Player playerToHeal;
        String identifyPlayer = String.format("%s the %s, whom shall ye heal?", player.getName(), player.getType());
        System.out.println(identifyPlayer);
        for (int j=0; j<this.players.size(); j++){
            playerToHeal = this.players.get(j);
            String identifyHealee = String.format("Type %s for %s the %s, health %s", j+1, playerToHeal.getName(), playerToHeal.getType(), playerToHeal.getHealthPoints());
            System.out.println(identifyHealee);
        }

        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }
        int target = scanner.nextInt();
        while (target < 1 || target > this.players.size()) {
            String validTargetPrompt = String.format("Please type a number between 1 and %s", this.players.size());
            System.out.println(validTargetPrompt);
            target = scanner.nextInt();
        }
        playerToHeal = this.players.get(target-1);
        player.healPlayer(playerToHeal);

        String healResult = String.format("%s the %s's health is now %s!", playerToHeal.getName(), playerToHeal.getType(), playerToHeal.getHealthPoints());
        System.out.println(healResult);

    }

    private void checkForDead() {
        ArrayList<Player> playersAlive = new ArrayList<Player>();
        for (Player player : this.players){
            if (!player.isDead()){
                playersAlive.add(player);
            }
        }
        this.players = playersAlive;
    }

    private void lootTreasure() {
        int lootFirstDibs = random.nextInt(this.players.size());
        do {
            for (int i=lootFirstDibs; i < this.players.size(); i++){
                if (currentRoom.treasureCount() > 0) {
                    Player player = this.players.get(i);
                    Treasure treasure = currentRoom.giveTreasure();
                    player.addTreasure(treasure);
                    String treasureAcquired = String.format("%s acquired %s!", player.getName(), treasure.getType());
                    System.out.println(treasureAcquired);
                }
            }
            lootFirstDibs = 0;
        } while (currentRoom.treasureCount() > 0);
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
        enemy = currentRoom.getEnemy(target-1);
        player.attack(enemy);
        if (enemy.isDead()){
            String confirmKill = String.format("%s the %s killed the %s!", player.getName(), player.getType(), enemy.getType());
            System.out.println(confirmKill);
        } else {
            String attackResult = String.format("The %s's health is down to %s!", enemy.getType(), enemy.getHealthPoints());
            System.out.println(attackResult);
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
        while (!difficultySelection.equals("Easy") && !difficultySelection.equals("Medium") && !difficultySelection.equals("Hard")) {
            System.out.println("Please type 'Easy', 'Medium' or 'Hard'?");
            difficultySelection = scanner.next();
        }

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

        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }
        int players = scanner.nextInt();

        for(int i = 0; i < players; i++){
            String namePrompt = String.format("Player %s, enter your name: ", (i + 1));
            System.out.println(namePrompt);
            String playerName = scanner.next();

            String classPrompt = String.format("Player %s, select your class: ", (i + 1));
            System.out.println(classPrompt);
            System.out.println("Select Knight, Dwarf, Barbarian, Cleric or Wizard?");
            String playerClass = scanner.next();
            while (!playerClass.equals("Knight") && !playerClass.equals("Dwarf") && !playerClass.equals("Barbarian") && !playerClass.equals("Cleric") && !playerClass.equals("Wizard")) {
                System.out.println("Please type 'Knight', 'Dwarf', 'Barbarian', 'Cleric' or 'Wizard'?");
                playerClass = scanner.next();
            }

            this.addPlayer(playerName, playerClass);
        }
    }

//    made public for testing access
    public void addPlayer(String playerName, String playerClass) {
        if (playerClass.equals("Knight")) {
            Player player = new Knight(playerName);
            this.players.add(player);
        } else if (playerClass.equals("Dwarf")) {
            Player player = new Dwarf(playerName);
            this.players.add(player);
        } else if (playerClass.equals("Barbarian")){
            Player player = new Barbarian(playerName);
            this.players.add(player);
        } else if (playerClass.equals("Cleric")){
            Player player = new Cleric(playerName);
            this.players.add(player);
        } else if (playerClass.equals("Wizard")){
            Player player = new Wizard(playerName);
            this.players.add(player);
        }
    }

    public int playerCount() {
        return this.players.size();
    }
}
