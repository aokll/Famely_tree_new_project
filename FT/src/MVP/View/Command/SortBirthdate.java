package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class SortBirthdate extends CommandClass{
    public SortBirthdate(ConsoleFT console) {
        super("Отсортировать базу данных ледей по дате рождения", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().sortBirthdate();
    }
}
