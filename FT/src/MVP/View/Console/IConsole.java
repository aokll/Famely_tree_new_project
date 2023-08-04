package MVP.View.Console;

import java.text.ParseException;

public interface IConsole {
    void start() throws ParseException;
    void printAnswer(String answer);
}
