## Завдання 1
Написати просту консольну програму
```java
class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

## Завдання 2
Індивідуальне завдання: Знайти двійкове, вісімкове та шістнадцяткове уявлення цілочисленного
значення.
1. Розробити клас, що серіалізується, для зберігання параметрів і результатів
обчислень.
Використовуючи агрегування, розробити клас для знаходження рішення
задачі. 
2. Розробити клас для демонстрації в діалоговому режимі збереження та
відновлення стану об'єкта, використовуючи серіалізацію. Показати особливості
використання transient полів. 
3. Розробити клас для тестування коректності результатів обчислень та
серіалізації/десеріалізації.

Main.java

```java
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
```

Calc.java
```java
package ex02;

import java.io.Serializable;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;


/**
 * Клас який повертає число у двійковому, вісімковому та шістнадцятковому уявленні
 *
 * @author Таїсія деркач
 */
public class Calc implements Serializable {
    private int number;
    private transient String binRepresentation;
    private transient String octRepresentation;
    private transient String hexRepresentation;

    /**
     * Ініціалізація класу {@link Calc}
     * @param number число представлення якого будуть видаватися
     */
    public Calc(int number) {
        this.number = number;
    }

    /**
     * Розрахування числа для кожного із представлень
     */
    private void calculateRepresentations() {
        binRepresentation = Integer.toBinaryString(this.number);
        octRepresentation = Integer.toOctalString(this.number);
        hexRepresentation = Integer.toHexString(this.number);
    }

    /**
     * Зміна числа представлення якого будуть видаватися
     */
    public void setNumber(int number) {
        this.number = number;
        calculateRepresentations();
    }

    /**
     * Повертає число представлення якого будуть видаватися
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Повертає значення у двійковому форматі
     */
    public String getBinRepresentation() {
        if (binRepresentation == null) {
            calculateRepresentations();
        }

        return binRepresentation;
    }

    /**
     * Повертає значення у вісімковому форматі
     */
    public String getOctRepresentation() {
        if (octRepresentation == null) {
            calculateRepresentations();
        }

        return octRepresentation;
    }

    /**
     * Повертає значення у шістнадцятковому форматі
     */
    public String getHexRepresentation() {
        if (hexRepresentation == null) {
            calculateRepresentations();
        }

        return hexRepresentation;
    }

    /**
     * Серіалізує клас {@link Calc} в файл class.ser
     */
    public void serialize() throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("src/ex02/class.ser");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(this);
        } finally {
            if (fos != null) { fos.close(); }
            if (oos != null) { oos.close(); }
        }
    }

    /**
     * Десеріалізує клас {@link Calc} з файлу class.ser
     *
     * @return десеріалізований клас {@link Calc}
     */
    public static Calc deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("src/ex02/class.ser");
            ois = new ObjectInputStream(fis);

            return (Calc) ois.readObject();
        } finally {
            if (fis != null) { fis.close(); }
            if (ois != null) { ois.close(); }
        }
    }
}
```

MainTest.java
```java
package ex01;

import ex02.Calc;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Тести для обчислень, серіалізації та десеріалізації
 *
 * @author Таїсія Деркач
 */
public class MainTest {
    /**
     * Тестування переведення числа в двійкове, вісімкове та шістнадцяткове представлення
     */
    @Test
    public void testCalc() {
        Calc number = new Calc(123);
        assertEquals("1111011", number.getBinRepresentation());
        assertEquals("173", number.getOctRepresentation());
        assertEquals("7b", number.getHexRepresentation());
    }

    /**
     * Тестування серіалізації та десеріалізації
     */
    @Test
    public void restore() throws IOException, ClassNotFoundException {
        Calc number = new Calc(123);

        number.serialize();

        Calc deserializedNumber = Calc.deserialize();

        assertNotNull(deserializedNumber);

        assertEquals("1111011", deserializedNumber.getBinRepresentation());
        assertEquals("173", deserializedNumber.getOctRepresentation());
        assertEquals("7b", deserializedNumber.getHexRepresentation());
    }
}

```
