package Items;

public class Legs extends Item{

    public Legs(String name, int recovery){
        super("Legs", 0, 0, 0, 0, 0);
    }

    public int getRecovery() {
        return super.getRec();
    }
}
