package Items;

public class Chestplate extends Item{

    public Chestplate(String name, int recovery){ super("Chestplate", 0, 0, 0, 30, 0); }

    public int getRecovery() { return super.getRec(); }
}
