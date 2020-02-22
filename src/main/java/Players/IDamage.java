package Players;

import Items.Weapons.IWeapon;

public interface IDamage {
    void attack(Player victim);
    void receiveNewWeapon(IWeapon newItem);
}
