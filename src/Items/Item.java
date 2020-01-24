package Items;

public abstract class Item {

    private int durability;
    private String name;
    private int attack;
    private int defense;
    private int rec;
    private int exHealth;

    public Item(String name, int durability, int attack, int defense, int rec, int exHealth){
        this.name = name;
        this.durability = durability;
        this.attack = attack;
        this.defense = defense;
        this.rec = rec;
        this.exHealth = exHealth;
    }

    public String getName(){
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public int getExHealth() {
        return exHealth;
    }

    public int getRec() {
        return rec;
    }

    @Override
    public String toString(){
        return "Name: " +name + ",  Defense: " + defense + ",  Attack: " + attack + ",  Recovery/extraHealth" +
                rec + "/" + exHealth + ",  Durability: " + durability;
    }
}
