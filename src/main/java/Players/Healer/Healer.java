package Players.Healer;
import Items.HealingItems.HealingItem;
import Players.Player;

public abstract class Healer extends Player {

    private HealingItem healingitem;

    public Healer(String name, double healthPoints) {
        super(name, healthPoints);
        this.healingitem = null;
    }

    public void receiveNewHealingItem(HealingItem newItem){
        this.healingitem = newItem;
    }

    public HealingItem getHealingItem(){
        return this.healingitem;
    }

    public abstract void healPlayer(Player player);

}
