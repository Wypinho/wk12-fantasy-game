package Items.Weapons;

import Players.Player;

public interface IWeapon {

    void attack(Player player);
    String getType();
}
