package Items.Weapons;

import Players.Player;

public class Club implements IWeapon {
    private double attackPower;
    private String effectiveAgainst;

    public Club() {
        this.attackPower = 5;
        this.effectiveAgainst = "Troll";
    }

    public double getAttackPower(Player victim) {
        if (victim.getType().equals(this.effectiveAgainst)) {
            return this.attackPower * 2;
        }
        return this.attackPower;
    }

    public String getType() {
        return "Club";
    }

}
