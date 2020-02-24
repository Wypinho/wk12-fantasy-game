package Players.MeleeFighter;

import Items.Weapons.IWeapon;
import Players.Player;

public abstract class MeleeFighter extends Player {
//    protected IWeapon weapon;
    protected String specialism;
//    private String vulnerability;

    public MeleeFighter() {
//        this.weapon = null;
        this.specialism = null;
    }

//    public void receiveNewWeapon(IWeapon newItem){
//        this.weapon = newItem;
//    }
//
//    public IWeapon getWeapon(){
//        return this.weapon;
//    }

    @Override
    public void attack(Player victim) {
        double multiplier = 1;
        if (this.weapon.getType().equals(this.specialism)){
            multiplier += 1;
        }
        double damage = this.weapon.getAttackPower(victim) * multiplier;
        victim.takeHealthDamage(damage);
    }

}
