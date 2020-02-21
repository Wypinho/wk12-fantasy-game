package Items.Weapons;

import Players.Player;

public class Sword implements IWeapon {
    private double attackPower;

    public Sword() {
        this.attackPower = 10;
    }

    public String getType() {
        return "Sword";
    }

    public double getAttackPower() {
        return this.attackPower;
    }
}
