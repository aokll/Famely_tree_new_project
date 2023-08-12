package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class AddConnection extends CommandClass{
    public AddConnection(ConsoleFT console) {
        super("Создать родственную связь", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().connectGenetic();
    }
}
