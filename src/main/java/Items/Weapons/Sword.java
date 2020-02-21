package Items.Weapons;

import Players.Player;

public class Sword implements IWeapon {
    private double attackPower;
    private String effectiveAgainst;

    public Sword() {
        this.attackPower = 10;
        this.effectiveAgainst = "Troll";
    }

    public String getType() {
        return "Sword";
    }

    public double getAttackPower(Player victim) {
        if (victim.getType().equals(this.effectiveAgainst)) {
            return this.attackPower * 2;
        }
        return this.attackPower;
    }
}
