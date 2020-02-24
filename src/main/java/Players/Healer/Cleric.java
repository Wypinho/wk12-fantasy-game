package Players.Healer;

import Items.HealingItems.IHealable;
import Items.HealingItems.Potion;
import Items.Weapons.Sword;
import Players.Player;

public class Cleric extends Healer {

    public Cleric(String name) {
        super(name);
        this.healthPoints = 80;
        this.healingItem = new Potion();
        this.type = "Cleric";
        this.weapon = new Sword();
    }

    @Override
    public void healPlayer(Player player){
        player.beHealed(getHealingItem().getHealingPower());
    }

    @Override
    public void attack(Player victim) {
        double damage = this.weapon.getAttackPower(victim);
        victim.takeHealthDamage(damage);
    }
}
