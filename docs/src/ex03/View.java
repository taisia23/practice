package ex03;

import java.io.IOException;

/** Шаблон проєктування Factory Method. Інтерфейс фабрикуємих об'єктів об'являє методи відображення об'єктів
 * @author Таїсія Деркач
 */
public interface View {
    /** Відображає заголовки */
    public void viewHeader();
    /** Відображає головну чатину */
    public void viewBody();
    /** Відображає закінчення */
    public void viewFooter();
    /** Відображає об'єкт цілком */
    public void viewShow();
    /** Виконує ініціалізацію */
    public void viewInit(int num);
    /** Зберігає для майбутнього відновлення */
    public void viewSave() throws IOException;
    /** Відновлює раніше збережені дані */
    public void viewRestore() throws Exception;
}
