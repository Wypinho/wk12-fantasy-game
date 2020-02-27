package Players;

import Items.HealingItems.IHealable;
import Items.Spells.ISpell;
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
    protected IHealable healingItem;
    protected ISpell spell;


    public Player() {
        this.healthPoints = 0;
        this.wallet = new ArrayList<Treasure>();
        this.dead = false;
        this.weapon = null;
        this.healingItem = null;
        this.spell = null;
    }

    public void receiveNewSpell(ISpell newSpell){
        this.spell = newSpell;
    }

    public void receiveNewWeapon(IWeapon newItem){
        this.weapon = newItem;
    }

    public IWeapon getWeapon(){
        return this.weapon;
    }

    public ISpell getSpell(){
        return this.spell;
    }

    public abstract void attack(Player victim);
//    {
//        double damage = this.weapon.getAttackPower(victim);
//        victim.takeHealthDamage(damage);
//    }

    public String getName(){
        return this.name;
    }

    public IHealable getHealingItem() {
        return this.healingItem;
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

    public abstract void healPlayer(Player player);

    public void receiveNewHealingItem(IHealable newItem){
        this.healingItem = newItem;
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
