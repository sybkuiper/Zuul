package Room;

import java.util.HashMap;
import java.util.Set;

public abstract class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description){
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbour){
        exits.put(direction, neighbour);
    }

    public String getShortDescription(){
        return description;
    }

    public String getLongDescription(){
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString(){
        String returnString = "Exits:";
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
