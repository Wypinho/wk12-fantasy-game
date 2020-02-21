package PlayerTests;

import Items.Weapons.Club;
import Items.Weapons.Sword;
import Players.Healer.Cleric;
import Players.MeleeFighter.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {
    Knight knight;
    Sword sword;
    Club club;
    Cleric cleric;

    @Before
    public void before(){
        knight = new Knight("Dave");
        sword = new Sword();
        club = new Club();
        cleric = new Cleric("Fred");
    }

    @Test
    public void canAttackEnemySpecialistWeapon(){
        knight.receiveNewWeapon(sword);
        knight.attack(cleric);
        assertEquals(60, cleric.getHealthPoints(), 0.01);
    }

    @Test
    public void canAttackEnemyNonSpecialistWeapon(){
        knight.receiveNewWeapon(club);
        knight.attack(cleric);
        assertEquals(75, cleric.getHealthPoints(), 0.01);
    }
}
