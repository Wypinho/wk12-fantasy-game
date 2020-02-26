package Items.Spells;

import Players.Player;

public class Burn implements ISpell{
    private double attackPower;
    private String effectiveAgainst;
    private String element;
    private String type;

    public Burn() {
        this.attackPower = 15;
        this.effectiveAgainst = "Orc";
        this.element = "Fire";
        this.type = "Burn";
    }

    public String getType() {
        return this.type;
    }


    public double getAttackPower(Player victim) {
        if (victim.getType().equals(this.effectiveAgainst)) {
            return this.attackPower * 2;
        }
        return this.attackPower;
    }

}
