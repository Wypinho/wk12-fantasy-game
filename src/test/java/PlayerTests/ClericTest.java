package PlayerTests;

import Items.HealingItems.Potion;
import Items.Treasure.Gold;
import Items.Treasure.Treasure;
import Players.Healer.Cleric;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    private Cleric jeff;
    private Cleric bob;
    private Potion potion;
    private Treasure gold;

    @Before
    public void before(){
        jeff = new Cleric("Jeff");
        bob = new Cleric("Bob");
        potion = new Potion();
        gold = new Gold();
    }

    @Test
    public void canReceiveHealingItem(){
        jeff.receiveNewHealingItem(potion);
        assertEquals(10, jeff.getHealingItem().getHealingPower(), 0.01);
    }

    @Test
    public void canTakeDamage(){
        jeff.takeHealthDamage(6.0);
        assertEquals(74, jeff.getHealthPoints(), 0.01);
    }

    @Test
    public void clericCanHealAnotherPlayer(){
        jeff.receiveNewHealingItem(potion);
        bob.takeHealthDamage(15);
        jeff.healPlayer(bob);
        assertEquals(75, bob.getHealthPoints(), 0.01);
    }

    @Test
    public void clericCanAddTreasure(){
        bob.addTreasure(gold);
        assertEquals(10, bob.getWalletValue());
    }
}
