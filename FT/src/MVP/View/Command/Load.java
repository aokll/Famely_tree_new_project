package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class Load  extends CommandClass{

    public Load(ConsoleFT console) {
        super("Загрузить сохраненные данные из файла в дерево и вывести их в консоль", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().load();
    }
}
