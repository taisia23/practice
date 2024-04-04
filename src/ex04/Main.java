package ex04;

import ex03.View;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    /**
     * Об'єкт реалізуючий інтерфейс {@linkplain View}
     */
    private View view;

    /** Ініціалізує поле {@linkplain Main} */
    public Main(View view) {
        this.view = view;
    }

    /**
     * Відображення меню програми
     */
    protected void menu() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.print("1 - Задати число | ");
            System.out.print("2 - Вивести представлення чисел | ");
            System.out.print("3 - Зберегти | ");
            System.out.print("4 - Відновити | ");
            System.out.print("5 - Вийти\n");
            System.out.print("Виберіть функцію: ");

            int selected = sc.nextInt();
            System.out.println(" ");

            switch (selected) {
                case 1:
                    System.out.print("Введіть число: ");
                    view.viewInit(sc.nextInt());
                    break;
                case 2:
                    view.viewShow();
                    break;
                case 3:
                    view.viewSave();
                    System.out.println("Клас збережено");
                    break;
                case 4:
                    try {
                        view.viewRestore();
                    } catch (Exception e) {
                        System.out.println("Помилка відновлення");
                    }
                    break;
                case 5:
                    run = false;
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}
