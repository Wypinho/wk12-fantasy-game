package RoomTests;

import Rooms.RandomRoomGenerator;
import Rooms.Room;
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
    public void startsWithPotentialEnemies(){
        assertEquals(6, randomRoomGenerator.potentialEnemiesCount());
    }

    @Test
    public void populatesRoomWith1EnemyForDifficulty1(){
        Room room = randomRoomGenerator.generateRoom(1);
        assertEquals(1, room.enemyCount());
    }
}
