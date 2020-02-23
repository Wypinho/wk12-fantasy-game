package PlayerTests;

import Players.Enemies.Orc;
import Players.Enemies.Troll;
import Players.MeleeFighter.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrollTest {
    Troll troll;
    Knight knight;

    @Before
    public void before(){
        troll = new Troll();
        knight = new Knight("Deadmeat");
    }

    @Test
    public void canAttackKnight(){
        troll.attack(knight);
        assertEquals(60, knight.getHealthPoints(),0.01);
    }
}
