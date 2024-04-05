package ex05;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MainTest {

    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void testAdd() {
        ConsoleCommand command1 = new GenerateConsoleCommand(null);
        ConsoleCommand command2 = new SaveConsoleCommand(null);

        menu.add(command1);
        menu.add(command2);

        assertEquals(Arrays.asList(command1, command2), menu.getCommands());
    }

    @Test
    public void testExecute() {
        String simulatedInput = "1\n0\n";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            menu.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.setIn(savedStandardInputStream);
    }
}
