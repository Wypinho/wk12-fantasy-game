package Players.MeleeFighter;

import Players.Player;

public class Barbarian extends MeleeFighter {

    public Barbarian(String name) {
        this.name = name;
        this.healthPoints = 150;
        this.specialism = "Club";
        this.type = "Barbarian";
    }

    @Override
    public void attack(Player victim) {
        double multiplier = 1;
        if (this.weapon.getType().equals(this.specialism)){
            multiplier += 3;
        }
        double damage = this.weapon.getAttackPower(victim) * multiplier;
        victim.takeHealthDamage(damage);
    }

}
