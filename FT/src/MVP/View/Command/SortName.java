package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class SortName extends CommandClass{
    public SortName(ConsoleFT console) {
        super("Отсортировать по имени", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().sortName();
    }
}
