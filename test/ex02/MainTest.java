package ex02;

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
