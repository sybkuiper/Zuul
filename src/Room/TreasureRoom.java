package Room;

import Items.Item;

import java.util.ArrayList;

public class TreasureRoom extends Room {

    private ArrayList<Item> items;

    public TreasureRoom(String desc, Item item){
        super(desc);

    }

    public TreasureRoom(String desc, Item item, Item item2, Item item3){
        super(desc);
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}
