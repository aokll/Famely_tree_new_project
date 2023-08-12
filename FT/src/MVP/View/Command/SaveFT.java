package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.io.IOException;
import java.text.ParseException;

public class SaveFT extends CommandClass{
    public SaveFT(ConsoleFT console) {
        super("Сохранить созданные связи в файл", console);
    }

    @Override
    public void execute() throws ParseException, IOException {
        super.getConsole().saveFT();
    }
}
