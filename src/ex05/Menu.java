package ex05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє меню команд.
 */
public class Menu implements Command {
    private ArrayList<ConsoleCommand> menu = new ArrayList<>();

    /**
     * Додає нову команду до меню.
     *
     * @param command команда для додавання
     * @return додана команда
     */
    public ConsoleCommand add(ConsoleCommand command) {
        menu.add(command);
        return command;
    }

    /**
     * Отримує список команд меню.
     *
     * @return список команд меню
     */
    public List<ConsoleCommand> getCommands() {
        return menu;
    }

    @Override
    public String toString() {
        StringBuilder commandsList = new StringBuilder();

        for (ConsoleCommand command : menu) {
            commandsList.append(String.format("%c - %s | ", command.getKey(), command));
        }

        return commandsList.toString();
    }

    /**
     * Виконує команди з меню.
     *
     * @throws Exception виняток, якщо сталася помилка під час виконання команди
     */
    @Override
    public void execute() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        menuLoop:
        while (true) {
            System.out.println(this);
            System.out.print("Виберіть команду: ");

            char key = in.readLine().charAt(0);

            if (key == '0') {
                return;
            }

            for (ConsoleCommand command : menu) {
                if (key == command.getKey()) {
                    command.execute();
                    continue menuLoop;
                }
            }

            System.out.println("Не вірна команда!");
        }
    }
}
