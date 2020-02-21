package Players.Healer;
import Items.HealingItems.IHealable;
import Players.Player;

public abstract class Healer extends Player {

    private IHealable healingitem;

    public Healer(String name) {
        this.name = name;
        this.healingitem = null;
    }

    public void receiveNewHealingItem(IHealable newItem){
        this.healingitem = newItem;
    }

    public IHealable getHealingItem(){
        return this.healingitem;
    }

    public abstract void healPlayer(Player player);

}
