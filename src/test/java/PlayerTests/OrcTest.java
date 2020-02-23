package PlayerTests;

import Players.Enemies.Orc;
import Players.MeleeFighter.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrcTest {
    Orc orc;
    Knight knight;

    @Before
    public void before(){
        orc = new Orc();
        knight = new Knight("Deadmeat");
    }

    @Test
    public void canAttackKnight(){
        orc.attack(knight);
        assertEquals(90, knight.getHealthPoints(),0.01);
    }
}
