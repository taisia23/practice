package ex05;

import ex03.View;

/**
 * Клас, що представляє команду для консолі.
 */
public class UndoConsoleCommand implements ConsoleCommand {
    private final View view;

    /**
     * Конструктор, що ініціалізує об'єкт команди з вказаним представленням даних.
     *
     * @param view представлення даних
     */
    public UndoConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди.
     *
     * @return ключ команди
     */
    public char getKey() {
        return '6';
    }

    /**
     * Повертає рядок, що представляє команду.
     *
     * @return рядок команди
     */
    public String toString() {
        return "Відмінити";
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
