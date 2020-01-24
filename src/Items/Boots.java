package Items;

public class Boots extends Item{

    public Boots(String name, int recovery){
        super("Boots", 0, 0, 0, 0, 0);
    }

    public int getRecovery() {
        return super.getRec();
    }
}
