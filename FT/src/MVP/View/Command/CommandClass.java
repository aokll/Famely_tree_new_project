package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.io.Console;
import java.io.IOException;
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
    public abstract void execute() throws ParseException, IOException;
}
