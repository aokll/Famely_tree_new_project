package MVP.View;

import MVP.View.Command.*;
import MVP.View.Console.ConsoleFT;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MenuClass {
    private List<CommandClass> listOfCommands;

    public MenuClass(ConsoleFT consoleFT) {
        listOfCommands = new ArrayList<>();
        listOfCommands.add(new PrintTree(consoleFT));
        listOfCommands.add(new AddHuman(consoleFT));
        listOfCommands.add(new RemoveHuman(consoleFT));
        listOfCommands.add(new Save(consoleFT));
        listOfCommands.add(new Load(consoleFT));
        listOfCommands.add(new SortName(consoleFT));
        listOfCommands.add(new SortBirthdate(consoleFT));
        listOfCommands.add(new ClearTree(consoleFT));
        listOfCommands.add(new Finish(consoleFT));
    }
    public String menu(){
        StringBuilder commandStatusBar = new StringBuilder();
        for (int i = 0; i < listOfCommands.size(); i++) {
            commandStatusBar.append(i+1).append(". ").append(listOfCommands.get(i).getDiscript()).append("\n");
        }
        return commandStatusBar.toString();
    }
    public void execute(int numberOfTheCommand) throws ParseException {
        CommandClass commandClass = listOfCommands.get(numberOfTheCommand - 1);
        commandClass.execute();
    }

    public List<CommandClass> getListOfCommands() {
        return listOfCommands;
    }
}
