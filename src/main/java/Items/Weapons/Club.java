package Items.Weapons;

public class Club implements IWeapon {
    private double attackPower;

    public Club() {
        this.attackPower = 5;
    }

    public String getType() {
        return "Club";
    }

    public double getAttackPower() {
        return this.attackPower;
    }
}
