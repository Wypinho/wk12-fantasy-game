package Rooms;

import Items.Treasure;
import Players.Player;

import java.util.ArrayList;

public class Room {

    private ArrayList<Treasure> treasures;
    private ArrayList<Player> players;

    public Room(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public int getPlayerCount() {
        return this.players.size();
    }

    public ArrayList<Treasure> giveTreasure() {
        ArrayList<Treasure> treasuresCopy = new ArrayList<Treasure>(this.treasures);
        this.treasures.clear();
        return treasuresCopy;
    }


    public int getTreasureCount() {
        return this.treasures.size();
    }
}
