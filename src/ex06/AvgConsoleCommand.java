package ex06;

import ex02.Calc;
import ex03.View;
import ex05.ConsoleCommand;

public class AvgConsoleCommand implements ConsoleCommand {
    private View view;

    public AvgConsoleCommand(View view) {
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
        int sum = view.viewItems().get(0).getNumber();

        for (Calc calc : view.viewItems()) {
            sum += calc.getNumber();
        }

        double avg = sum / (double)view.viewItems().size();

        Thread.sleep(1000);

        System.out.printf("Середнє число: %d", avg);
    }
}

