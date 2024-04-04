package ex04;

import ex03.ViewResult;

/**
 * Клас для відображення результатів обчислень у вигляді таблиці
 */
public class ViewTable extends ViewResult {
    /**
     * Конструктор за замовчуванням
     */
    public ViewTable() {}

    /**
     * Відображає заголовки таблиці
     */
    @Override
    public void viewHeader() {
        System.out.printf("%-10s| %-10s| %-10s| %-10s\n", "Число", "Двійкове", "Вісімкове", "Шістнадцяткове");
    }

    /**
     * Відображає роздільник між заголовками та даними
     */
    public void separate() {
        System.out.println("-".repeat(10) + "+-" + "-".repeat(10) + "+-" + "-".repeat(10) + "+-" + "-".repeat(10));
    }

    /**
     * Відображає дані у вигляді таблиці
     */
    @Override
    public void viewBody() {
        for (int i = 1; i < viewItems().size(); i++) {
            System.out.printf("%-10s| %-10s| %-10s| %-10s\n", viewItems().get(i).getNumber(), viewItems().get(i).getBinRepresentation(), viewItems().get(i).getOctRepresentation(), viewItems().get(i).getHexRepresentation());
        }
    }

    /**
     * Відображає дані у вигляді таблиці з зовнішнього масиву
     *
     * @param data Масив даних для виведення
     */
    public void viewBody(String[][] data) {
        for (int i = 1; i < viewItems().size(); i++) {
            System.out.printf("%-10s| %-10s| %-10s| %-10s\n", data[i][0], data[i][1], data[i][2], data[i][3]);
        }
    }

    /**
     * Відображає таблицю
     */
    @Override
    public void viewShow() {
        viewHeader();
        separate();
        viewBody();
    }
}