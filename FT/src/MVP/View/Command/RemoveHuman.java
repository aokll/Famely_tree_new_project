package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class RemoveHuman extends CommandClass{
    public RemoveHuman(ConsoleFT console) {
        super("Удалить человека из дерева", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().RemoveHuman();
    }
}
