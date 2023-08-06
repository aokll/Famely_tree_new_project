package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class AddHuman extends CommandClass{
    public AddHuman(ConsoleFT console) {

        super("Добавить человека", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().addHuman();
    }
}
