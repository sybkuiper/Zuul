package Game_sys;

import Items.Item;
import Room.*;
import Player.*;

import java.util.Iterator;
import java.util.Random;

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private int encounterRate;

    public Game(){
        createRooms();
        parser = new Parser();
        player = new Player("Sybren");
        encounterRate = 50;
    }

    private void createRooms(){
        Room outside, theater, pub, lab, office;

        //create the rooms
        outside = new TreasureRoom("Outside the main entrance", );
        theater = new EncounterRoom("In a lecture theater", encounterRate);
        pub = new RestPlace("In a campus pub", 30);
        lab = new RestPlace("In a computing lab", 10);
        office = new EncounterRoom("In the computing admin office", encounterRate);

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;//start the game outside
    }

    public void play(){
        printWelcome();

        boolean finished = false;
        while(!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing");
    }

    private void printWelcome(){
        System.out.println();
        System.out.println("Welcome to Zuul!");
        System.out.println("Zuul is a text based game");
        System.out.println("Type 'help' if you need help");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command){
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean");
            return false;
        }

        String commandWord = command.getCommandWord();
        if(commandWord.equals("help")){
            printHelp();
        }else if
        (commandWord.equals("go")) {
            goRoom(command);
        }else if
        (commandWord.equals("quit")){
            wantToQuit = quit(command);
        }else if
        (commandWord.equals("inventory")){
            printInventory();
        }else if
        (commandWord.equals("chest")){
            chestRoom(command);
        }

        return wantToQuit;
    }

    private void printHelp(){
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around the academy");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);
        if(nextRoom == null){
            System.out.println("There is no door");
        }else{
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            if(nextRoom instanceof EncounterRoom) {
                ((EncounterRoom) nextRoom).encounter();
                if (!((EncounterRoom) nextRoom).isEncounter()){
                    encounterRate += 10;
                }else{
                    encounterRate = 50;
                }
            }else if(nextRoom instanceof RestPlace){
                player.recoverHealth(((RestPlace) nextRoom).recover());
            }
        }
    }

    private boolean quit(Command command){
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }else{
            return true;
        }
    }

    public void chestRoom(Command command){
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom instanceof TreasureRoom){
            Iterator<Item> it = ((TreasureRoom)nextRoom).getItems().iterator();
            while(it.hasNext()){
                Inventory.addToInv(it);
            }
        }
    }

    private void printInventory(){
        player.getInventory();
    }

    public Player getPlayer(){
        return player;
    }
}
