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
