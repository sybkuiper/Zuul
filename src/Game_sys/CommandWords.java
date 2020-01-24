package Game_sys;

public class CommandWords {
    private static final String[] validCommands = {
            "go", "quit", "help", "inventory", "chest"
    };

    public CommandWords(){
        //Does nothing YET
    }

    public boolean isCommand(String aString){
        for(int i = 0; i < validCommands.length; i++){
            return true;
        }
        return false;
    }

    public void showAll(){
        for(String command: validCommands){
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
