package ex06;

import ex02.Calc;
import ex03.View;
import ex05.ConsoleCommand;

public class MaxConsoleCommand implements ConsoleCommand {
    private View view;

    public MaxConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Метод, що повертає гарячу клавішу для команди консолі.
     *
     * @return гаряча клавіша для команди
     */
    @Override
    public char getKey() {
        return 0;
    }

    /**
     * Метод для виконання команди.
     *
     * @throws Exception виняток, якщо сталася помилка під час виконання команди
     */
    @Override
    public void execute() throws Exception {
        int max = view.viewItems().get(0).getNumber();

        for (Calc calc : view.viewItems()) {
            if (max < calc.getNumber()) {
                max = calc.getNumber();
            }
        }

        Thread.sleep(1000);

        System.out.printf("Максимальне число: %d", max);
    }
}

