package Items;

public class Potion extends Item{



    public Potion(String name, int recovery){
        super("Potion", 0, 0, 0, 30, 0);
    }

    public int getRecovery() {
        return super.getRec();
    }
}
