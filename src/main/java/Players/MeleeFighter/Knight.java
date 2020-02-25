package Players.MeleeFighter;

import Items.Weapons.IWeapon;
import Items.Weapons.Sword;

public class Knight extends MeleeFighter {

    public Knight(String name) {
        this.name = name;
        this.healthPoints = 100;
        this.specialism = "Sword";
        this.type = "Knight";
//        temporary for gameplay testing
//        this.weapon = new Sword();
    }
}
