package Quest.Rooms;

import Items.HealingItems.Herb;
import Items.HealingItems.IHealable;
import Items.HealingItems.Potion;
import Items.Spells.Burn;
import Items.Spells.Freeze;
import Items.Spells.ISpell;
import Items.Treasure.Gem;
import Items.Treasure.Gold;
import Items.Treasure.Treasure;
import Items.Weapons.Axe;
import Items.Weapons.Club;
import Items.Weapons.IWeapon;
import Items.Weapons.Sword;
import Players.Enemies.Enemy;
import Players.Enemies.Orc;
import Players.Enemies.Troll;

import java.util.ArrayList;
import java.util.Random;

public class RandomRoomGenerator {
    private ArrayList<Enemy> potentialEnemies;
    private ArrayList<Treasure> potentialTreasure;
    private ArrayList<IWeapon> potentialWeapons;
    private ArrayList<IHealable> potentialHealingItems;
    private ArrayList<ISpell> potentialSpells;
    private Random random;

    public RandomRoomGenerator(){
        this.random = new Random();
        this.potentialEnemies = new ArrayList<Enemy>();
        this.potentialTreasure = new ArrayList<Treasure>();
        this.potentialWeapons = new ArrayList<IWeapon>();
        this.potentialHealingItems = new ArrayList<IHealable>();
        this.potentialSpells = new ArrayList<ISpell>();
    }

    public int potentialEnemiesCount() {
        return this.potentialEnemies.size();
    }

    public int potentialTreasureCount() {
        return this.potentialTreasure.size();
    }

    public Room generateRoom(int roomDifficulty){
        this.generatePotentialEnemies(roomDifficulty);
        this.generatePotentialTreasure(roomDifficulty);
        this.generatePotentialWeapons();
        this.generatePotentialHealingItems();
        this.generatePotentialSpells();
        Room room = new Room();
        this.populateRoomWithEnemies(roomDifficulty, room);
        this.populateRoomWithTreasure(roomDifficulty, room);
        this.populateRoomWithWeapons(room);
        this.populateRoomWithHealingItems(room);
        this.clearPotentialArrays();
        return room;
    }

    private void generatePotentialHealingItems() {
        for (int i = 0; i < 3; i++) {
            Herb herb = new Herb();
            this.potentialHealingItems.add(herb);
        }
        for (int i = 0; i < 3; i++) {
            Potion potion = new Potion();
            this.potentialHealingItems.add(potion);
        }
    }

    private void generatePotentialSpells() {
        for (int i = 0; i < 3; i++) {
            Burn burn = new Burn();
            this.potentialSpells.add(burn);
        }
        for (int i = 0; i < 3; i++) {
            Freeze freeze = new Freeze();
            this.potentialSpells.add(freeze);
        }
    }

    private void generatePotentialWeapons() {
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
    }

    private void clearPotentialArrays() {
        potentialEnemies.clear();
        potentialTreasure.clear();
        potentialWeapons.clear();
        potentialHealingItems.clear();
        potentialSpells.clear();
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

    private void populateRoomWithWeapons(Room room) {
        IWeapon weapon;
        boolean populate;
        for (int i = 0; i < 2; i++) {
            populate = random.nextBoolean();
            if (populate) {
                weapon = this.potentialWeapons.get(random.nextInt(this.potentialWeapons.size()));
                room.addWeapon(weapon);
                this.potentialWeapons.remove(weapon);
            }
        }
    }

    private void populateRoomWithHealingItems(Room room) {
        IHealable healingItem;
        boolean populate;
        for (int i = 0; i < 2; i++) {
            populate = random.nextBoolean();
            if (populate) {
                healingItem = this.potentialHealingItems.get(random.nextInt(this.potentialHealingItems.size()));
                room.addHealingItem(healingItem);
                this.potentialHealingItems.remove(healingItem);
            }
        }
    }

    private void populateRoomWithSpells(Room room) {
        ISpell spell;
        boolean populate;
        for (int i = 0; i < 2; i++) {
            populate = random.nextBoolean();
            if (populate) {
                spell = this.potentialSpells.get(random.nextInt(this.potentialSpells.size()));
                room.addSpell(spell);
                this.potentialSpells.remove(spell);
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
