package HealingItemTests;

import Items.HealingItems.Herb;
import Items.HealingItems.Potion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HerbTest {
    Herb herb;

    @Before
    public void before(){
        herb = new Herb();
    }

    @Test
    public void canGetHealingPowerIfNotExpired(){
        assertEquals(5, herb.getHealingPower(), 0.01);
    }

    @Test
    public void cantGetHealingPowerIfExpired(){
        herb.moveRooms();
        herb.moveRooms();
        herb.moveRooms();
        assertEquals(0, herb.getHealingPower(), 0.01);
    }
}
