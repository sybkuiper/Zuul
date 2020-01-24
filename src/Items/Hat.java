package Items;

public class Hat extends Item{

    public Hat(String name, int recovery){
        super("Hat", 0, 0, 0, 0, 0);
    }

    public int getRecovery() {
        return super.getRec();
    }
}
