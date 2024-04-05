package ex05;

import ex03.View;

import java.io.IOException;

/**
 * Клас, що представляє команду для консолі.
 */
public class ViewConsoleCommand implements ConsoleCommand {
    private final View view;

    /**
     * Конструктор, що ініціалізує об'єкт команди з вказаним представленням даних.
     *
     * @param view представлення даних
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди.
     *
     * @return ключ команди
     */
    @Override
    public char getKey() {
        return '1';
    }

    @Override
    public String toString() {
        return "Вивести результати";
    }

    /**
     * Виконує команду, яка виводить результати на консоль.
     *
     * @throws IOException виняток, якщо сталася помилка під час виконання команди
     */
    @Override
    public void execute() throws IOException {
        System.out.println(" ");
        view.viewShow();
        System.out.println(" ");
    }
}
