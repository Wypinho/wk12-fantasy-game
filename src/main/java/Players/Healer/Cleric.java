package Players.Healer;

import Items.HealingItems.Potion;
import Players.Player;

public class Cleric extends Healer {

    public Cleric(String name) {
        super(name);
        this.healthPoints = 80;
        this.healingItem = new Potion();
    }

    public void healPlayer(Player player){
        player.beHealed(getHealingItem().getHealingPower());
    }
}
