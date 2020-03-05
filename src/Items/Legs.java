package Items;

public class Legs extends Item{

    public Legs(String name, int recovery){
        super("Legs", 0, 0, 0, 0, 0);
    }

    public String getNam() { return super.getName(); }
    public int getDur() { return super.getDurability(); }
    public int getAtt() { return super.getAttack(); }
    public int getDef() { return super.getDefense(); }
    public int getRecovery() { return super.getRec(); }
    public int getExH() { return super.getExHealth(); }
}
