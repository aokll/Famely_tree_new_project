package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.io.IOException;
import java.text.ParseException;

public class LoadFT extends CommandClass{

    public LoadFT(ConsoleFT console) {
        super("Загрузить сохраненные связи из файла, и вывести их в консоль", console);
    }

    @Override
    public void execute() throws ParseException, IOException {
        super.getConsole().loadFT();
    }
}
