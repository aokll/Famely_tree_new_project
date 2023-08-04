package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.io.Console;
import java.text.ParseException;

public abstract class CommandClass{
    private String discript;
    private ConsoleFT console;

    public CommandClass(String discript, ConsoleFT console) {
        this.discript = discript;
        this.console = console;
    }

    ConsoleFT getConsole() {
        return console;
    }
    public String getDiscript() {
        return discript;
    }
    public void execute() throws ParseException {

    }
}
