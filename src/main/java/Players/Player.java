package Players;

public abstract class Player {

    private String name;
    private Double healthPoints;
    private Double wallet;

    public Player(String name, Double healthPoints, Double wallet) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.wallet = wallet;
    }

    public String getName(){
        return this.name;
    }

    public Double getHealthPoints() {
        return this.healthPoints;
    }

    public Double getWallet() {
        return this.wallet;
    }

    public void takeHealthDamage(Double amountToRemove){
        this.healthPoints -= amountToRemove;
    }

}
