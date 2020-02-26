package Items.Spells;

import Players.Player;

public interface ISpell {

    double getAttackPower(Player victim);
    String getType();
}
