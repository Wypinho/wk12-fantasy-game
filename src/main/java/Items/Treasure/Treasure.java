package Items.Treasure;

public abstract class Treasure{
    protected int value;
    protected String type;

    public Treasure() {
        this.value = 0;
        this.type = "";
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return this.type;
    }
}
