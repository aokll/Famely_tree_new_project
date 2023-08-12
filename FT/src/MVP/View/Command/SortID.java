package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class SortID extends CommandClass{

    public SortID(ConsoleFT console) {
        super("Отсортировать базу данных ледей по значению ID", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().sortID();
    }
}
