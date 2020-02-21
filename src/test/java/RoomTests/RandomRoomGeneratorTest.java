package RoomTests;

import Rooms.RandomRoomGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomRoomGeneratorTest {
    RandomRoomGenerator randomRoomGenerator;

    @Before
    public void before(){
        randomRoomGenerator = new RandomRoomGenerator(1);
    }

    @Test
    public void startsWithPotentialEnemies(){
        assertEquals(2, randomRoomGenerator.potentialEnemiesCount());
    }
}
