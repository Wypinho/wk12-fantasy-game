package Items.Spells;

import Players.Player;

public class Freeze implements ISpell {
    private double attackPower;
    private String effectiveAgainst;
    private String element;
    private String type;

    public Freeze() {
        this.attackPower = 15;
        this.effectiveAgainst = "Troll";
        this.element = "Ice";
        this.type = "Freeze";
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
