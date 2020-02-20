package ItemTests;

import Items.HealingItems.HealingItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HealingItemTest {

    HealingItem potion;

    @Before
    public void before(){
        potion = new HealingItem("Potion", 10);
    }

    @Test
    public void canReturnHealingItemHealingPower(){
        assertEquals(10, potion.getHealingPower(), 0.01);
    }
}
