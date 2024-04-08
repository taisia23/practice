package ex06;

import ex03.View;
import ex05.ConsoleCommand;

import java.util.concurrent.TimeUnit;

public class ExecuteConsoleCommand implements ConsoleCommand {
    private final View view;

    public ExecuteConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Метод, що повертає гарячу клавішу для команди консолі.
     *
     * @return гаряча клавіша для команди
     */
    @Override
    public char getKey() {
        return '6';
    }

    @Override
    public String toString() {
        return "Виконати";
    }

    /**
     * Метод для виконання команди.
     *
     * @throws Exception виняток, якщо сталася помилка під час виконання команди
     */
    @Override
    public void execute() throws Exception {
        System.out.println("Початок виконання потоків");

        CommandQueue queue1 = new CommandQueue();
        CommandQueue queue2 = new CommandQueue();

        AvgConsoleCommand avgCommand = new AvgConsoleCommand(view);
        MaxConsoleCommand maxCommand = new MaxConsoleCommand(view);
        MinConsoleCommand minCommand = new MinConsoleCommand(view);

        queue1.put(avgCommand);
        queue2.put(maxCommand);
        queue2.put(minCommand);

        while (avgCommand.isRunning() || maxCommand.isRunning() || minCommand.isRunning()) {
            TimeUnit.MICROSECONDS.sleep(100);
        }

        queue1.shutdown();
        queue2.shutdown();

        System.out.println("Всі потоки завершили свою роботу");
    }
}
