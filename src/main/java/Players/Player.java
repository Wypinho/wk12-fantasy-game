package Players;

import Items.Item;

public abstract class Player {

    private String name;
    private double healthPoints;
    private double wallet;

    public Player(String name, double healthPoints, double wallet) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.wallet = wallet;
    }

    public String getName(){
        return this.name;
    }

    public double getHealthPoints() {
        return this.healthPoints;
    }

    public double getWallet() {
        return this.wallet;
    }

    public void takeHealthDamage(double amountToRemove){
        this.healthPoints -= amountToRemove;
    }

    public void beHealed(double amountToAdd){
        this.healthPoints += amountToAdd;
    }

}
