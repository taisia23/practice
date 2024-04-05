package ex05;

/**
 * Інтерфейс, що представляє команду, яка може бути виконана.
 */
public interface Command {
    /**
     * Метод для виконання команди.
     *
     * @throws Exception виняток, якщо сталася помилка під час виконання команди
     */
    void execute() throws Exception;
}
