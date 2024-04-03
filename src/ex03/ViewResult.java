package ex03;

import ex02.Calc;

import java.io.*;
import java.util.ArrayList;

public class ViewResult implements View {
    private ArrayList<Calc> items = new ArrayList<Calc>();

    /**
     * Конструктор класу {@link ViewResult}
     */
    public ViewResult() {
        this(10);
    }

    /**
     * Конструктор класу  {@link ViewResult}
     *
     * @param num Кількість елементів
     */
    public ViewResult(int num) {
        this.viewInit(num);
    }

    /**
     * Відображає заголовки
     */
    @Override
    public void viewHeader() {
        System.out.println("Початок представлень");
    }

    /**
     * Відображає головну частину
     */
    @Override
    public void viewBody() {
        for (Calc calc : items) {
            System.out.println("Двійкове представлення числа " + calc.getNumber() + ": " + calc.getBinRepresentation());
            System.out.println("Вісімкове представлення числа " + calc.getNumber() + ": " + calc.getOctRepresentation());
            System.out.println("Шістнадцяткове представлення числа " + calc.getNumber() + ": " + calc.getHexRepresentation());
        }
    }

    /**
     * Відображає закінчення
     */
    @Override
    public void viewFooter() {
        System.out.println("Кінець представлень");
    }

    /**
     * Відображає об'єкт цілком
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }

    /**
     * Виконує ініціалізацію
     *
     * @param num початок
     */
    @Override
    public void viewInit(int num) {
        items.clear();

        for (int i = 0; i < num; i++) {
            items.add(new Calc(0));
        }

        for (int i = 0; i < items.size(); i++) {
            items.get(i).setNumber(i + num + 1);
        }
    }

    /**
     * Зберігає для майбутнього відновлення
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/ex03/view.ser"));
        objectOutputStream.writeObject(this.items);
    }

    /**
     * Відновлює раніше збережені дані
     */
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/ex03/view.ser"));
        this.items = (ArrayList<Calc>) objectInputStream.readObject();
    }
}
