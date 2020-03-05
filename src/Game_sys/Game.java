package Game_sys;

import Items.*;
import Room.*;
import Player.*;

import java.util.Iterator;

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private int encounterRate;

    public Game(){
        createRooms();
        parser = new Parser();
        player = new Player("Bas");
        encounterRate = 50;
    }

    private void createRooms(){
        Room bushalte, kantine, hal, servicebalie, dVleugel, trapNaarCVleugel, bVleugel, aVleugel, kantoorRealTime, auditorium, toiletten, a218, lerarenkamer, b250, a224, a162, makerspace, a230;

        //create the rooms
        bushalte = new RestPlace("Bij de bushalte 'Zernikeplein'.", 100);
        kantine = new RestPlace("In de kantine op de 2e verdieping.", 30);
        hal = new RestPlace("In de grote hal van de Van Dooren Veste.", 30);
        servicebalie = new EncounterRoom("Bij de servicebalie.", encounterRate);
        dVleugel = new RestPlace("Aan het begin van de D-vleugel.", 0);
        trapNaarCVleugel = new RestPlace("Bovenaan de trap bij de C-vleugel.", 0);
        bVleugel = new RestPlace("Bij het begin van de B-vleugel.", 0);
        aVleugel = new RestPlace("Bij het begin van de A-vleugel.", 0);
        kantoorRealTime = new EncounterRoom("In het kantoor van S.V. RealTime.", encounterRate);
        auditorium = new EncounterRoom("In het auditorium.", encounterRate);
        toiletten = new RestPlace("In de toiletten van de B-vleugel.", 30);
        a218 = new EncounterRoom("In het lokaal A218.", encounterRate);
        lerarenkamer = new EncounterRoom("In de lerarenkamer.", encounterRate);
        b250 = new EncounterRoom("In het lokaal B250.", encounterRate);
        a224 = new EncounterRoom("In het lokaal A224.", encounterRate);
        a162 = new EncounterRoom("In het lokaal A162.", encounterRate);
        makerspace = new RestPlace("In de Makerspace.", 30);
        a230 = new EncounterRoom("In het lokaal A230", encounterRate);

        bushalte.setExit("west", hal);

        kantine.setExit("north", dVleugel);

        hal.setExit("north", trapNaarCVleugel);
        hal.setExit("east", servicebalie);
        hal.setExit("south", bushalte);

        servicebalie.setExit("north", aVleugel);
        servicebalie.setExit("west", hal);

        dVleugel.setExit("north", kantoorRealTime);
        dVleugel.setExit("east", trapNaarCVleugel);
        dVleugel.setExit("south", kantine);

        trapNaarCVleugel.setExit("north", auditorium);
        trapNaarCVleugel.setExit("east", bVleugel);
        trapNaarCVleugel.setExit("south", hal);
        trapNaarCVleugel.setExit("west", dVleugel);

        bVleugel.setExit("north", toiletten);
        bVleugel.setExit("east", aVleugel);
        bVleugel.setExit("west", trapNaarCVleugel);

        aVleugel.setExit("north", a218);
        aVleugel.setExit("south", servicebalie);
        aVleugel.setExit("west", bVleugel);

        kantoorRealTime.setExit("north", lerarenkamer);
        kantoorRealTime.setExit("south", dVleugel);

        auditorium.setExit("south", trapNaarCVleugel);

        toiletten.setExit("north", b250);
        toiletten.setExit("south", bVleugel);

        a218.setExit("north", a224);
        a218.setExit("south", aVleugel);

        lerarenkamer.setExit("north", makerspace);
        lerarenkamer.setExit("south", kantoorRealTime);

        b250.setExit("east", a224);
        b250.setExit("south", toiletten);

        a224.setExit("north", a230);
        a224.setExit("east", a162);
        a224.setExit("south", a218);
        a224.setExit("west", b250);

        a162.setExit("west", a224);

        makerspace.setExit("east", a230);
        makerspace.setExit("south", lerarenkamer);

        a230.setExit("south", a224);
        a230.setExit("west", makerspace);

        // initialise room exits
//        bushalte.setExit("east", theater);
//        bushalte.setExit("south", lab);
//        bushalte.setExit("west", pub);
//
//        theater.setExit("west", bushalte);
//
//        pub.setExit("east", bushalte);
//
//        lab.setExit("north", bushalte);
//        lab.setExit("east", office);
//
//        office.setExit("west", lab);

        currentRoom = bushalte;//start the game bushalte
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
        switch (commandWord) {
            case "help":
                printHelp();
                break;
            case "go":
                goRoom(command);
                break;
            case "quit":
                wantToQuit = quit(command);
                break;
            case "inventory":
                printInventory();
                break;
            case "chest":
                chestRoom(command);
                break;
        }

        return wantToQuit;
    }

    private void printHelp(){
        System.out.println("Je bent net aangekomen op de Hanze. Je bent op zoek naar punten, EC's om precies te zijn.");
        System.out.println("Deze kun je vinden in de Van Dooren Veste");
        System.out.println();
        System.out.println("De commands zijn:");
        parser.showCommands();
    }

    private void goRoom(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Waar naartoe?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);
        if(nextRoom == null){
            System.out.println("Hier is geen deur.");
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
            System.out.println("Stop met wat?");
            return false;
        }else{
            return true;
        }
    }

    public void chestRoom(Command command){
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

//        if (nextRoom instanceof TreasureRoom){
//            Iterator<Item> it = ((TreasureRoom)nextRoom).getItems().iterator();
//            while(it.hasNext()){
//                Inventory.addToInv((Item) it);
//            }
//        }
    }

    private void printInventory(){
        player.getInventory();
    }

    public Player getPlayer(){
        return player;
    }
}
