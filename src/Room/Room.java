package Room;

import Game_sys.Game;
import Game_sys.Language;

import java.util.HashMap;
import java.util.Set;

public abstract class Room {
    private String descriptionN;
    private String descriptionE;
    private HashMap<String, Room> exits;

    public Room(String descriptionN, String descriptionE){
        this.descriptionN = descriptionN;
        this.descriptionE = descriptionE;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbour){
        exits.put(direction, neighbour);
    }

    public String getShortDescription(){
        return descriptionN;
    }

    public String getLongDescriptionN(){
        return "Je bent " + descriptionN + ".\n" + getExitString();
    }

    public String getLongDescriptionE(){
        return "You are " + descriptionE + ".\n" + getExitString();
    }

    private String getExitString(){
        String returnString = "";

        returnString = "Exits: ";

        Set<String> keys = exits.keySet();
        for(String exit : keys){
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction){
        return exits.get(direction);
    }
}
