package RoomTests;

import Items.Treasure.Gold;
import Items.Treasure.Treasure;
import Players.Healer.Cleric;
import Players.Player;
import Rooms.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    Room room;
    Player bob;
    Treasure treasure;
    ArrayList<Treasure> treasures;

    @Before
    public void before(){
        bob = new Cleric("Bob");
        treasure = new Gold();
        treasures = new ArrayList<Treasure>();
        treasures.add(treasure);
        room = new Room(treasures);
    }

    @Test
    public void canAddPlayerToRoom(){
        room.addPlayer(bob);
        assertEquals(1, room.getPlayerCount());
    }

    @Test
    public void treasureCanBeRaided(){
        room.giveTreasure();
        assertEquals(0, room.getTreasureCount());
    }
}
