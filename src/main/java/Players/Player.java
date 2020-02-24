package Players;

import Items.Treasure.Treasure;
import Items.Weapons.IWeapon;

import java.util.ArrayList;

public abstract class Player {

    protected String name;
    protected double healthPoints;
    private ArrayList<Treasure> wallet;
    protected String type;
    private boolean dead;
    protected IWeapon weapon;

    public Player() {
        this.healthPoints = 0;
        this.wallet = new ArrayList<Treasure>();
        this.dead = false;
        this.weapon = null;
    }

    public void receiveNewWeapon(IWeapon newItem){
        this.weapon = newItem;
    }

    public IWeapon getWeapon(){
        return this.weapon;
    }

    public abstract void attack(Player victim);
//    {
//        double damage = this.weapon.getAttackPower(victim);
//        victim.takeHealthDamage(damage);
//    }

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
        if (this.healthPoints <= 0){
            this.dead = true;
            this.healthPoints = 0;
        }
    }

    public void beHealed(double amountToAdd){
        this.healthPoints += amountToAdd;
    }

    public void addTreasure(Treasure treasure){
        this.wallet.add(treasure);
    }

    public boolean isDead() {
        return this.dead;
    }

//    Some suggestions from Alex
//    public void affectPlayer(Player player){
//
//    }
//    public boolean canAffectPlayer(Player player){
//        return false;
//    }
}
