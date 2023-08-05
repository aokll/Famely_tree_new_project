package MVP.View;

import MVP.View.Command.*;
import MVP.View.Console.ConsoleFT;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MenuClass {
    private List<CommandClass> CList;

    public MenuClass(ConsoleFT consoleFT) {
        CList = new ArrayList<>();
        CList.add(new PrintTree(consoleFT));
        CList.add(new AddHuman(consoleFT));
        CList.add(new RemoveHuman(consoleFT));
        CList.add(new Save(consoleFT));
        CList.add(new Load(consoleFT));
        CList.add(new SortName(consoleFT));
        CList.add(new SortBirthdate(consoleFT));
        CList.add(new ClearTree(consoleFT));
        CList.add(new Finish(consoleFT));
    }
    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CList.size(); i++) {
            stringBuilder.append(i+1).append(". ").append(CList.get(i).getDiscript()).append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int numComm) throws ParseException {
        CommandClass commandClass = CList.get(numComm - 1);
        commandClass.execute();
    }

    public List<CommandClass> getCList() {
        return CList;
    }
}
