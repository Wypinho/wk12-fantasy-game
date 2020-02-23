package Players.Enemies;

import Items.Weapons.IWeapon;
import Players.Player;

public class Troll extends Enemy {
    private double attackPower;

    public Troll(){
        this.healthPoints = 200;
        this.type = "Troll";
        this.attackPower = 40;
    }

    public void attack(Player victim) {
        victim.takeHealthDamage(this.attackPower);
    }

    public void receiveNewWeapon(IWeapon newItem) {

    }
}
