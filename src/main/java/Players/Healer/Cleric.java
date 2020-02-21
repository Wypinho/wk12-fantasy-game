package Players.Healer;

import Players.Player;

public class Cleric extends Healer {

    public Cleric(String name) {
        super(name);
        this.healthPoints = 80;
    }

    public void healPlayer(Player player){
        player.beHealed(getHealingItem().getHealingPower());
    }
}
