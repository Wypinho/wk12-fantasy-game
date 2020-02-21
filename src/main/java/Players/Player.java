package Players;

import Items.Treasure.Treasure;

import java.util.ArrayList;

public abstract class Player {

    protected String name;
    protected double healthPoints;
    private ArrayList<Treasure> wallet;
    protected String type;

    public Player() {
        this.healthPoints = 0;
        this.wallet = new ArrayList<Treasure>();
    }

    public String getName(){
        return this.name;
    }

    public String getType() {
        return type;
    }

    public double getHealthPoints() {
        return this.healthPoints;
    }

    public int getWalletValue() {
        int walletValue = 0;
        for ( Treasure treasure : this.wallet ){
            walletValue += treasure.getValue();
        }
        return walletValue;
    }

    public void takeHealthDamage(double amountToRemove){
        this.healthPoints -= amountToRemove;
    }

    public void beHealed(double amountToAdd){
        this.healthPoints += amountToAdd;
    }

    public void addTreasure(Treasure treasure){
        this.wallet.add(treasure);
    }

}
