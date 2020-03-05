package Room;

import Items.Item;

import java.util.ArrayList;

public class TreasureRoom extends Room {

    private ArrayList<Item> items;

    public TreasureRoom(String desc, Item item){
        super(desc);

    }

    public TreasureRoom(String desc, Item item, Item item2, Item item3, Item item4){
        super(desc);
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}
