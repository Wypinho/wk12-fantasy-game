package Items.Weapons;

import Players.Player;

public interface IWeapon {

    double getAttackPower(Player victim);
    String getType();
}
