package Items.Weapons;

import Players.Player;

public class Axe implements IWeapon {

    private double attackPower;
    private String effectiveAgainst;

    public Axe() {
        this.attackPower = 10;
        this.effectiveAgainst = "Orc";
    }

    public double getAttackPower(Player victim) {
        if (victim.getType().equals(this.effectiveAgainst)) {
            return this.attackPower * 2;
        }
        return this.attackPower;
    }

    public String getType() {
        return "Axe";
    }

}
