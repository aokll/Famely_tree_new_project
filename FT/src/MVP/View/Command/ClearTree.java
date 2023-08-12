package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class ClearTree extends CommandClass{

    public ClearTree(ConsoleFT console) {
        super("Очистить список связей", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().clearTree();
    }
}
