package ex05;

import ex03.View;

import java.io.IOException;
import java.util.Scanner;

/**
 * Клас, який представляє команду для консолі.
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    private final View view;

    /**
     * Конструктор, що ініціалізує об'єкт команди з вказаним представленням даних.
     *
     * @param view представлення даних
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди.
     *
     * @return ключ команди
     */
    public char getKey() {
        return '2';
    }

    /**
     * Повертає рядок, що представляє команду.
     *
     * @return рядок команди
     */
    public String toString() {
        return "Ввести";
    }

    /**
     * Виконує команду, яка зчитує кількість результатів з консолі та ініціалізує відображення з вказаною кількістю результатів.
     *
     * @throws IOException виняток, якщо сталася помилка вводу/виводу
     */
    @Override
    public void execute() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Кількість результатів: ");
        int count = scanner.nextInt();

        view.viewInit(count);
    }
}
