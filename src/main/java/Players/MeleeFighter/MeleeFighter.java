package Players.MeleeFighter;

import Items.Weapons.IWeapon;
import Players.Player;

public abstract class MeleeFighter extends Player {
    private IWeapon weapon;

    public MeleeFighter(String name, double healthPoints) {
        super(name, healthPoints);
        weapon = null;
    }

    public void receiveNewWeapon(IWeapon newItem){
        this.weapon = newItem;
    }

    public IWeapon getWeapon(){
        return this.weapon;
    }

}
