package Items.HealingItems;

public class Potion implements IHealable {

    private double healingPower;
    private int quantity;
    private String type;


    public Potion(){
        this.healingPower = 10;
        this.quantity = 5;
        this.type = "Potion";
    }

    public double getHealingPower() {
        if (this.quantity > 0) {
            this.quantity -= 1;
            return this.healingPower;
        }
        return 0;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getType() {
        return this.type;
    }
}
