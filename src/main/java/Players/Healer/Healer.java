package Players.Healer;
import Items.HealingItems.HealingItem;
import Items.Item;
import Players.Player;

public abstract class Healer extends Player {

    private HealingItem healingitem;

    public Healer(String name, Double healthPoints, Double wallet) {
        super(name, healthPoints, wallet);
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
