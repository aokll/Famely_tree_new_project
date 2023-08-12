package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class ClearBD extends CommandClass{
    public ClearBD(ConsoleFT console) {
        super("Очистить базу данных", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().clearBD();
    }
}
