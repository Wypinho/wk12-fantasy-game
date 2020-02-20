package Players.Healer;

import Players.Player;

public class Cleric extends Healer {

    public Cleric(String name, Double healthPoints, Double wallet) {
        super(name, healthPoints, wallet);
    }

    public void healPlayer(Player player){
        player.beHealed(getHealingItem().getHealingPower());
    }
}
