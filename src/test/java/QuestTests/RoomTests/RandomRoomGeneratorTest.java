package QuestTests.RoomTests;

import Quest.Rooms.RandomRoomGenerator;
import Quest.Rooms.Room;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomRoomGeneratorTest {
    RandomRoomGenerator randomRoomGenerator;

    @Before
    public void before(){
        randomRoomGenerator = new RandomRoomGenerator();
    }

    @Test
    public void startsWithNoPotentialEnemies(){
        assertEquals(0, randomRoomGenerator.potentialEnemiesCount());
    }

//    @Test
//    public void generateRoomPopulatesPotentialEnemies(){
//        randomRoomGenerator.generateRoom(1);
//        assertEquals(5, randomRoomGenerator.potentialEnemiesCount());
//    }

    @Test
    public void populatesRoomWith1EnemyForDifficulty1(){
        Room room = randomRoomGenerator.generateRoom(1);
        assertEquals(1, room.enemyCount());
    }

    @Test
    public void populatesRoomWith5EnemiesForDifficulty5(){
        Room room = randomRoomGenerator.generateRoom(5);
        assertEquals(5, room.enemyCount());
//        assertEquals(4, randomRoomGenerator.potentialEnemiesCount());
    }

    @Test
    public void startsWithNoPotentialTreasure(){
        assertEquals(0, randomRoomGenerator.potentialTreasureCount());
    }

//    @Test
//    public void generateRoomPopulatesPotentialTreasure(){
//        randomRoomGenerator.generateRoom(1);
//        assertEquals(5, randomRoomGenerator.potentialTreasureCount());
//    }

    @Test
    public void populatesRoomWith1TreasureForDifficulty1(){
        Room room = randomRoomGenerator.generateRoom(1);
        assertEquals(1, room.treasureCount());
    }

    @Test
    public void populatesRoomWith5TreasureForDifficulty5(){
        Room room = randomRoomGenerator.generateRoom(5);
        assertEquals(5, room.treasureCount());
//        assertEquals(4, randomRoomGenerator.potentialTreasureCount());
    }
}
