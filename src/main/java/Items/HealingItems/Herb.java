package Items.HealingItems;

public class Herb implements IHealable {
    private double healingPower;
    private int roomsTillExpiration;

    public Herb() {
        this.healingPower = 5;
        this.roomsTillExpiration = 3;
    }

    public double getHealingPower() {
        if (this.roomsTillExpiration > 0){
            return this.healingPower;
        }
        return 0;
    }

    public int getRoomsTillExpiration() {
        return this.roomsTillExpiration;
    }

    public void moveRooms(){
        this.roomsTillExpiration -= 1;
    }
}
