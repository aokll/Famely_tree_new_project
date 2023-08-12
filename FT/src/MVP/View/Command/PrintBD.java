package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class PrintBD extends CommandClass{
    public PrintBD(ConsoleFT console) {
        super("Посмотреть базу данных", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().printBD();
    }
}
