package ex02;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Calc num = new Calc(0);
        boolean run = true;

        while (run) {
            System.out.println("1 - Задати число");
            System.out.println("2 - Двійкове представлення");
            System.out.println("3 - Вісімкове представлення");
            System.out.println("4 - Шістнадцяткове представлення");
            System.out.println("5 - Серіалізувати");
            System.out.println("6 - Десеріалізувати");
            System.out.println("7 - Вийти");
            System.out.print("\nВиберіть функцію: ");

            String selected = sc.nextLine();

            switch (selected) {
                case "1":
                    System.out.println("Введіть число: ");
                    num.setNumber(sc.nextInt());
                    break;
                case "2":
                    System.out.println("Двійкове представлення числа " + num.getNumber() + ": " + num.getBinRepresentation());
                    break;
                case "3":
                    System.out.println("Вісімкове представлення числа " + num.getNumber() + ": " + num.getOctRepresentation());
                    break;
                case "4":
                    System.out.println("Шістнадцяткове представлення числа " + num.getNumber() + ": " + num.getHexRepresentation());
                    break;
                case "5":
                    num.serialize();
                    System.out.println("Клас серіалізовано");
                    break;
                case "6":
                    try {
                        num = Calc.deserialize();
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Помилка десеріалізації");
                    }
                    break;
                case "7":
                    run = false;
            }
        }
    }
}
