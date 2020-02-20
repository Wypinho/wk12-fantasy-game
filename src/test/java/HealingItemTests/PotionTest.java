package HealingItemTests;

import Items.HealingItems.Potion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PotionTest {
    Potion potion;

    @Before
    public void before(){
        potion = new Potion();
    }

    @Test
    public void canGetHealingPowerIfQuantityGreaterThan0(){
        assertEquals(10, potion.getHealingPower(), 0.01);
    }

    @Test
    public void cantGetHealingPowerIfQuantity0(){
        potion.getHealingPower();
        potion.getHealingPower();
        potion.getHealingPower();
        potion.getHealingPower();
        potion.getHealingPower();
        assertEquals(0, potion.getHealingPower(), 0.01);
    }
}
