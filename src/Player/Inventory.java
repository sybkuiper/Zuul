package Player;

import Items.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {


    private boolean access;
    private ArrayList<Item> inv;

    public Inventory(){
        this.inv = new ArrayList<Item>();
    }



    public void addToInv(Item item){
        inv.add(item);
    }

    public ArrayList<Item> getInv() {
        return inv;
    }

    public void printInv(){
        Iterator it = inv.iterator();
        System.out.println("Inventory: ");
        while(it.hasNext()){
            System.out.println(it.toString());
        }
    }

}
