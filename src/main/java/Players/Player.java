package Players;

import Items.Item;
import Items.Treasure;

import java.util.ArrayList;

public abstract class Player {

    private String name;
    private double healthPoints;
    private ArrayList<Treasure> wallet;

    public Player(String name, double healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.wallet = new ArrayList<Treasure>();
    }

    public String getName(){
        return this.name;
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
