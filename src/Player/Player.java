package Player;

public class Player {

    private String name;
    private int health;
    private int currentHealth;
    private int attack;
    private int defense;
    private int speed;
    private int xp;
    Inventory inventory = new Inventory();

    public Player(String name){

        this.name = name;
        this.health = 100;
        this.currentHealth = health;
        this.attack = 10;
        this.speed = 10;
        this.xp = 0;
    }

    public void recoverHealth(int health){
        if((currentHealth + health)>=this.health) {
            currentHealth = this.health;
        }else{
            currentHealth += health;
        }
        System.out.println("Je hebt nu " + currentHealth + " health.");
    }

    public int getCurrentHealth(){
        return currentHealth;
    }

    public void getInventory() {
        inventory.printInv();
    }
}

