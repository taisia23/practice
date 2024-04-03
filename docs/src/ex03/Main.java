package ex03;

import ex02.Calc;

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
            System.out.println("1 - Задати число");
            System.out.println("2 - Вивести представлення чисел");
            System.out.println("3 - Зберегти");
            System.out.println("4 - Відновити");
            System.out.println("5 - Вийти");
            System.out.print("\nВиберіть функцію: ");

            String selected = sc.nextLine();

            switch (selected) {
                case "1":
                    System.out.println("Введіть число: ");
                    view.viewInit(sc.nextInt());
                    break;
                case "2":
                    view.viewShow();
                    break;
                case "3":
                    view.viewSave();
                    System.out.println("Клас збережено");
                    break;
                case "4":
                    try {
                        view.viewRestore();
                    } catch (Exception e) {
                        System.out.println("Помилка відновлено");
                    }
                    break;
                case "5":
                    run = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }
}
