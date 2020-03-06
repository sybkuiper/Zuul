package Game_sys;

import Items.*;
import Room.*;
import Player.*;

import java.util.Iterator;
import java.util.Scanner;

import Game_sys.Language;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private int encounterRate;
    public Language language;

    public Game(){
        createRooms();
        parser = new Parser();
        player = new Player("Bas");
        encounterRate = 50;
    }

    private void createRooms(){
        Room bushalte, kantine, hal, servicebalie, dVleugel, trapNaarCVleugel, bVleugel, aVleugel, kantoorRealTime, auditorium, toiletten, a218, lerarenkamer, b250, a224, a162, makerspace, a230;

        //create the rooms
        bushalte = new RestPlace("bij de bushalte 'Zernikeplein'.", "at the bus stop 'Zernikeplein'.",100);
        kantine = new RestPlace("in de kantine op de 2e verdieping.", "in the cantine on the 2nd floor.", 30);
        hal = new RestPlace("in de grote hal van de VanDooren Veste.", "in the 'VanDooren Veste' entrance hall.", 30);
        servicebalie = new EncounterRoom("bij de servicebalie.", "at the service desk.", encounterRate);
        dVleugel = new RestPlace("aan het begin van de D-vleugel.", "at the beginning of the D-wing.", 0);
        trapNaarCVleugel = new RestPlace("bovenaan de trap bij de C-vleugel.", "at the top of the stairway at the C-wing.", 0);
        bVleugel = new RestPlace("bij het begin van de B-vleugel.", "at the beginning of the B-wing.", 0);
        aVleugel = new RestPlace("bij het begin van de A-vleugel.", "at the beginning of the A-wing.", 0);
        kantoorRealTime = new EncounterRoom("in het kantoor van S.V. RealTime.", "at RealTime's office.", encounterRate);
        auditorium = new EncounterRoom("in het auditorium.", "at the auditorium.", encounterRate);
        toiletten = new RestPlace("in de toiletten van de B-vleugel.", "in the B-wing's toilets.", 30);
        a218 = new EncounterRoom("in het lokaal A218.", "in classroom A218.", encounterRate);
        lerarenkamer = new EncounterRoom("in de lerarenkamer.", "in the teacher's room.", encounterRate);
        b250 = new EncounterRoom("in het lokaal B250.", "in classroom B250.", encounterRate);
        a224 = new EncounterRoom("in het lokaal A224.", "in classroom A224.", encounterRate);
        a162 = new EncounterRoom("in het lokaal A162.", "in classroom A162.", encounterRate);
        makerspace = new RestPlace("in de Makerspace.", "in the Makerspace.", 30);
        a230 = new EncounterRoom("in het lokaal A230", "in classroom A230.", encounterRate);

        if (language == Language.ENGELS) {
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
        } else {
            bushalte.setExit("west", hal);

            kantine.setExit("noord", dVleugel);

            hal.setExit("noord", trapNaarCVleugel);
            hal.setExit("oost", servicebalie);
            hal.setExit("zuid", bushalte);

            servicebalie.setExit("noord", aVleugel);
            servicebalie.setExit("west", hal);

            dVleugel.setExit("noord", kantoorRealTime);
            dVleugel.setExit("oost", trapNaarCVleugel);
            dVleugel.setExit("zuid", kantine);

            trapNaarCVleugel.setExit("noord", auditorium);
            trapNaarCVleugel.setExit("oost", bVleugel);
            trapNaarCVleugel.setExit("zuid", hal);
            trapNaarCVleugel.setExit("west", dVleugel);

            bVleugel.setExit("noord", toiletten);
            bVleugel.setExit("oost", aVleugel);
            bVleugel.setExit("west", trapNaarCVleugel);

            aVleugel.setExit("noord", a218);
            aVleugel.setExit("zuid", servicebalie);
            aVleugel.setExit("west", bVleugel);

            kantoorRealTime.setExit("noord", lerarenkamer);
            kantoorRealTime.setExit("zuid", dVleugel);

            auditorium.setExit("zuid", trapNaarCVleugel);

            toiletten.setExit("noord", b250);
            toiletten.setExit("zuid", bVleugel);

            a218.setExit("noord", a224);
            a218.setExit("zuid", aVleugel);

            lerarenkamer.setExit("zuid", makerspace);
            lerarenkamer.setExit("zuid", kantoorRealTime);

            b250.setExit("oost", a224);
            b250.setExit("zuid", toiletten);

            a224.setExit("noord", a230);
            a224.setExit("oost", a162);
            a224.setExit("zuid", a218);
            a224.setExit("west", b250);

            a162.setExit("west", a224);

            makerspace.setExit("oost", a230);
            makerspace.setExit("zuid", lerarenkamer);

            a230.setExit("zuid", a224);
            a230.setExit("west", makerspace);
        }

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
        chooseLanguage();
        printWelcome();

        boolean finished = false;
        while(!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        if (language == Language.NEDERLANDS) {
            System.out.println("Dankjewel voor het spelen!");
        } else {
            System.out.println("Thank you for playing");
        }
    }

    private void chooseLanguage() {
        Scanner languageInput = new Scanner(System.in);
        System.out.println("Kies je taal/Choose your language (NEDERLANDS/ENGELS)");

        String chosenLanguage = languageInput.nextLine();

        language = Language.valueOf(chosenLanguage);
    }

    public Language getLanguage() {
        return language;
    }

    private void printWelcome() {
        if (language == Language.NEDERLANDS) {
            System.out.println();
            System.out.print("Welkom bij mijn versie van Zuul!");
            System.out.println("Dit is een tekstgebaseerd avonturenspel.");
            System.out.println("Typ 'help' als je hulp nodig hebt.");
            System.out.println();
            System.out.println(currentRoom.getLongDescriptionN());
        } else {
            System.out.println();
            System.out.println("Welcome my version of Zuul!");
            System.out.println("This is a text based game");
            System.out.println("Type 'help' if you need help");
            System.out.println();
            System.out.println(currentRoom.getLongDescriptionE());
        }
    }

    private boolean processCommand(Command command){
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            if (language == Language.NEDERLANDS) {
                System.out.println("Ik weet niet wat je bedoelt.");
            } else {
                System.out.println("I don't know what you mean.");
            }
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
        if (language == Language.NEDERLANDS) {
            System.out.println("Je bent net aangekomen op de Hanze. Je bent op zoek naar punten, EC's om precies te zijn.");
            System.out.println("Deze kun je vinden in de VanDooren Veste.");
            System.out.println();
            System.out.println("De commands zijn: ");
            parser.showCommands();
        } else {
            System.out.println("You have arrived at the Hanzehogeschool Groningen. You are looking for points, EC's to be precise.");
            System.out.println("You can find these in the VanDooren Veste.");
            System.out.println();
            System.out.println("The commands are: ");
            parser.showCommands();
        }
    }

    private void goRoom(Command command){
        if(!command.hasSecondWord()) {
            if (language == Language.NEDERLANDS) {
                System.out.println("Waar naartoe?");
            } else {
                System.out.println("Where do you want to go?");
            }
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);
        if(nextRoom == null){
            if (language == Language.NEDERLANDS) {
                System.out.println("Hier is geen deur.");
            } else {
                System.out.println("There is no door here.");
            }
        }else{
            currentRoom = nextRoom;
            if (language == Language.NEDERLANDS) {
                System.out.println(currentRoom.getLongDescriptionN());
                if (nextRoom instanceof EncounterRoom) {
                    ((EncounterRoom) nextRoom).encounter();
                    if (!((EncounterRoom) nextRoom).isEncounter()) {
                        encounterRate += 10;
                    } else {
                        encounterRate = 50;
                    }
                } else if (nextRoom instanceof RestPlace) {
                    player.recoverHealth(((RestPlace) nextRoom).recover());
                }
            } else {
                System.out.println(currentRoom.getLongDescriptionE());
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
    }

    private boolean quit(Command command){
        if(command.hasSecondWord()) {
            if (language == Language.NEDERLANDS) {
                System.out.println("Stop met wat?");
            } else {
                System.out.println("Stop with wat?");
            }
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
