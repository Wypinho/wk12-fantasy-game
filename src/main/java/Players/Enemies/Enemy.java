package Players.Enemies;

import Players.Player;

public abstract class Enemy extends Player {
    protected String vulnerability;
    private String type;


    public String getVulnerability() {
        return this.vulnerability;
    }

    public String getType() {
        return this.type;
    }
}
