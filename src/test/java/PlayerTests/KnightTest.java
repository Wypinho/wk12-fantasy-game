package PlayerTests;

import Items.Weapons.Sword;
import Players.Healer.Cleric;
import Players.MeleeFighter.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {
    Knight knight;
    Sword sword;
    Cleric cleric;

    @Before
    public void before(){
        knight = new Knight("Dave", 10);
        sword = new Sword();
        cleric = new Cleric("Fred", 15);
    }

    @Test
    public void canAttackEnemy(){
        knight.receiveNewWeapon(sword);
        knight.getWeapon().attack(cleric);
        assertEquals(5, cleric.getHealthPoints(), 0.01);
    }
}
