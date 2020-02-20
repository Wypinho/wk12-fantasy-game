package Items.Weapons;

import Items.Item;

public abstract class Weapon extends Item {
    private double attackPower;

    public Weapon(String name, double attackPower) {
        super(name);
        this.attackPower = attackPower;
    }

    public double getAttackPower() {
        return this.attackPower;
    }
}
