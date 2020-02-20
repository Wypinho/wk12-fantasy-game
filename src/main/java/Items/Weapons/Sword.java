package Items.Weapons;

import Players.Player;

public class Sword implements IWeapon {
    private double attackPower;

    public Sword() {
        this.attackPower = 10;
    }

    public void attack(Player player) {
        player.takeHealthDamage(this.attackPower);
    }

    public String getType() {
        return "Sword";
    }
}
