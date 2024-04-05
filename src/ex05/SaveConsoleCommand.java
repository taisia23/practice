package ex05;

import ex03.View;

import java.io.IOException;

/**
 * Клас, що представляє команду для консолі.
 */
public class SaveConsoleCommand implements ConsoleCommand {
    private final View view;

    /**
     * Конструктор, що ініціалізує об'єкт команди з вказаним представленням даних.
     *
     * @param view представлення даних
     */
    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди.
     *
     * @return ключ команди
     */
    public char getKey() {
        return '4';
    }

    /**
     * Повертає рядок, що представляє команду.
     *
     * @return рядок команди
     */
    public String toString() {
        return "Зберегти";
    }

    /**
     * Виконує команду, яка зберігає стан представлення даних.
     *
     * @throws IOException виняток, якщо сталася помилка під час виконання команди
     */
    @Override
    public void execute() throws IOException {
        view.viewSave();
    }
}
