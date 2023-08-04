package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class Finish extends CommandClass{
    public Finish(ConsoleFT console) {
        super("Завершить программу", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().finish();
    }
}
