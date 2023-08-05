package MVP.View.Command;

import MVP.View.Console.ConsoleFT;

import java.text.ParseException;

public class PrintTree extends CommandClass{
    public PrintTree(ConsoleFT console) {
        super("Посмотреть дерево", console);
    }

    @Override
    public void execute() throws ParseException {
        super.getConsole().printTree();
    }
}
