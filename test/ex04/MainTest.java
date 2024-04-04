package ex04;

import ex03.View;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void restore() throws Exception {
        View view = new ViewableTable().getView();
        view.viewInit(10);
        int startSize = view.viewItems().size();

        view.viewSave();
        view.viewInit(20);
        view.viewRestore();

        assertEquals(startSize, view.viewItems().size());
    }
}
