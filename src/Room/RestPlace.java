package Room;


public class RestPlace extends Room {

    private int recoveringHealth;

    public RestPlace(String desc, int recoveringHealth){
        super(desc);
        this.recoveringHealth = recoveringHealth;
    }

    public int recover(){
       return recoveringHealth;
    }
}
