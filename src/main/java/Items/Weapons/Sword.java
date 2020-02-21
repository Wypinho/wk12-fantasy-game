package Items.Weapons;

import Players.Player;

public class Sword implements IWeapon {
    private double attackPower;
    private String effectiveAgainst;

    public Sword() {
        this.attackPower = 10;
        this.effectiveAgainst = "Orc";
    }

    public String getType() {
        return "Sword";
    }

    public double getAttackPower(Player victim) {
        victim.
        return this.attackPower;
    }
}
