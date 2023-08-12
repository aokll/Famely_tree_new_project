package MVP.View.Console;

import java.io.IOException;
import java.text.ParseException;

public interface IConsole {
    void start() throws ParseException, IOException;
    void printAnswer(String answer);
}
