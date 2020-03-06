package Room;

import java.util.Random;

public class EncounterRoom extends Room {

    private boolean encounter;

    public EncounterRoom(String descN, String descE, int rate){
        super(descN, descE);
        encountering(rate);
    }

    public void encountering(int rate){
        Random rand = new Random();
        int r = rand.nextInt(100);
        encounter = rate > r;
    }

    public void encounter(){
        if (encounter){
            System.out.println("Oh nee!");
        }else{
            System.out.println("Er is niemand");
        }
    }

    public boolean isEncounter() {
        return encounter;
    }
}
