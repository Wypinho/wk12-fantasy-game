package Players.Enemies;

import Items.Weapons.IWeapon;
import Items.Weapons.Sword;
import Players.Player;

public class Orc extends Enemy{
    private IWeapon weapon;

    public Orc(){
        this.healthPoints = 100;
        this.type = "Orc";
        this.weapon = new Sword();
    }

    public void attack(Player victim) {
        double damage = this.weapon.getAttackPower(victim);
        victim.takeHealthDamage(damage);
    }

    public void receiveNewWeapon(IWeapon newItem) {

    }
}
