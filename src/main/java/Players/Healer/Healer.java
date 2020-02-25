package Players.Healer;
import Items.HealingItems.IHealable;
import Players.Player;

public abstract class Healer extends Player {

//    protected IHealable healingItem;

    public Healer(String name) {
        this.name = name;
        this.healingItem = null;
    }

//    public void receiveNewHealingItem(IHealable newItem){
//        this.healingItem = newItem;
//    }

    public IHealable getHealingItem(){
        return this.healingItem;
    }

//    public abstract void healPlayer(Player player);

}
