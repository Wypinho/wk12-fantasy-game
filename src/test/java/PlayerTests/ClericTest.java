package PlayerTests;

import Items.HealingItems.HealingItem;
import Players.Healer.Cleric;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    private Cleric jeff;
    private Cleric bob;
    private HealingItem potion;

    @Before
    public void before(){
        jeff = new Cleric("Jeff", 10.00, 100.00);
        bob = new Cleric("Bob", 20.00, 50.00);
        potion = new HealingItem("Potion", 5);
    }

    @Test
    public void canReceiveHealingItem(){
        jeff.receiveNewHealingItem(potion);
        assertEquals("Potion", jeff.getHealingItem().getName());
    }

    @Test
    public void canTakeDamage(){
        jeff.takeHealthDamage(6.0);
        assertEquals(4.0, jeff.getHealthPoints(), 0.01);
    }

    @Test
    public void clericCanHealAnotherPlayer(){
        bob.receiveNewHealingItem(potion);
        jeff.takeHealthDamage(6.0);
        bob.healPlayer(jeff);
        assertEquals(9.0, jeff.getHealthPoints(), 0.01);
    }
}
