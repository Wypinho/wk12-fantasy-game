package PlayerTests;

import Items.Weapons.Club;
import Items.Weapons.Sword;
import Players.Enemies.Orc;
import Players.Enemies.Troll;
import Players.Healer.Cleric;
import Players.MeleeFighter.Knight;
import Players.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {
    Knight knight;
    Sword sword;
    Club club;
    Orc orc;
    Troll troll;

    @Before
    public void before(){
        knight = new Knight("Dave");
        sword = new Sword();
        club = new Club();
        orc = new Orc();
        troll = new Troll();
    }

    @Test
    public void canAttackEnemyPlayerSpecialistWeaponAndWeaponEffectiveAgainstVictim(){
        knight.receiveNewWeapon(sword);
        knight.attack(troll);
        assertEquals(160, troll.getHealthPoints(), 0.01);
    }

    @Test
    public void canAttackEnemyPlayerNonSpecialistWeaponAndWeaponNotEffectiveAgainstVictim(){
        knight.receiveNewWeapon(club);
        knight.attack(orc);
        assertEquals(95, orc.getHealthPoints(), 0.01);
    }


}
