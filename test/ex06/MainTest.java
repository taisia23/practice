package ex06;

import ex03.View;
import ex04.ViewableTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Перевірка WorkingThread
     */
    @Test
    public void testExecute() throws Exception {
        View view = new ViewableTable().getView();
        ExecuteConsoleCommand executeConsoleCommand = new ExecuteConsoleCommand(view);

        executeConsoleCommand.execute();

        String output = outContent.toString().trim();

        assert (output.contains("Максимальне число: 5"));
        assert (output.contains("Середнє значення: 4,00"));
        assert (output.contains("Мінімальне число: 1"));
    }
}
