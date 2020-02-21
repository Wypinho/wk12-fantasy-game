package Players.Enemies;

import Players.Player;

public abstract class Enemy extends Player {
    protected String vulnerability;


    public String getVulnerability() {
        return vulnerability;
    }
}
