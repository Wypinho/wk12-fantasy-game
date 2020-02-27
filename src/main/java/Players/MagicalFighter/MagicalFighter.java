package Players.MagicalFighter;

import Items.Spells.ISpell;
import Items.Weapons.IWeapon;
import Players.Player;

public abstract class MagicalFighter extends Player {

    protected String specialism;

    public MagicalFighter() {
        this.specialism = null;
    }

    @Override
    public void attack(Player victim) {
        double multiplier = 1;
//        should be get element not type
        if (this.spell.getType().equals(this.specialism)){
            multiplier += 1;
        }
        double damage = this.spell.getAttackPower(victim) * multiplier;
        victim.takeHealthDamage(damage);
    }

    //    empty method to avoid casting Player to Cleric in game class
    public void healPlayer(Player player){

    }
}
