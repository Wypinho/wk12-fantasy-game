package Items.HealingItems;

import Items.Item;

public class HealingItem extends Item {

    private double healingPower;

    public HealingItem(String name, double healingPower) {
        super(name);
        this.healingPower = healingPower;
    }

    public double getHealingPower() {
        return healingPower;
    }
}
