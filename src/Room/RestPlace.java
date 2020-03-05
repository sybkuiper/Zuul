package Room;


public class RestPlace extends Room {

    private int recoveringHealth;

    public RestPlace(String descN, String descE, int recoveringHealth){
        super(descN, descE);
        this.recoveringHealth = recoveringHealth;
    }

    public int recover(){
       return recoveringHealth;
    }
}
