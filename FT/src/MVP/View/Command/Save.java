package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class Save extends CommandClass{
    public Save(ConsoleFT console) {
        super("Сохранить базу данных людей в файл", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().save();
    }
}
