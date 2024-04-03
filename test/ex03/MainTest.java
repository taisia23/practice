package ex03;

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
