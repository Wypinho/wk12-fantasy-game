package QuestTests.RoomTests;

import Items.Treasure.Gold;
import Items.Treasure.Treasure;
import Players.Enemies.Enemy;
import Players.Enemies.Orc;
import Players.Healer.Cleric;
import Players.Player;
import Quest.Rooms.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    Room room;
    Player bob;
    Treasure treasure;
    ArrayList<Treasure> treasures;
    Enemy orc;

    @Before
    public void before(){
        bob = new Cleric("Bob");
        treasure = new Gold();
        room = new Room();
        orc = new Orc();
    }

    @Test
    public void canAddTreasureToRoom(){
        room.addTreasure(treasure);
        assertEquals(1, room.treasureCount());
    }

//    @Test
//    public void canAddPlayerToRoom(){
//        room.addPlayer(bob);
//        assertEquals(1, room.getPlayerCount());
//    }

    @Test
    public void canAddEnemyToRoom(){
        room.addEnemy(orc);
        assertEquals(1, room.enemyCount());
    }

    @Test
    public void treasureCanBeRaided(){
        room.giveTreasure();
        assertEquals(0, room.treasureCount());
    }

}
