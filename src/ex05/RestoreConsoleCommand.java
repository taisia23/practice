package ex05;

import ex03.View;

/**
 * Клас, що представляє команду для консолі.
 */
public class RestoreConsoleCommand implements ConsoleCommand {
    private final View view;

    /**
     * Конструктор, що ініціалізує об'єкт команди з вказаним представленням даних.
     *
     * @param view представлення даних
     */
    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди.
     *
     * @return ключ команди
     */
    public char getKey() {
        return '5';
    }

    /**
     * Повертає рядок, що представляє команду.
     *
     * @return рядок команди
     */
    public String toString() {
        return "Відновити";
    }

    /**
     * Виконує команду, яка відновлює стан представлення даних.
     *
     * @throws Exception виняток, якщо сталася помилка під час виконання команди
     */
    @Override
    public void execute() throws Exception {
        view.viewRestore();
    }
}
