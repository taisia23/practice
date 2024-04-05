package ex05;

import ex03.View;
import ex04.ViewableTable;

/**
 * Клас, що представляє додаток, який використовується для управління меню та виконання команд.
 */
public class Application {
    private static final Application instance = new Application(); // Єдиний екземпляр додатку
    private View view = new ViewableTable().getView();
    private Menu menu = new Menu();

    private Application() {
        // Приватний конструктор для заборони створення екземплярів ззовні класу
    }

    /**
     * Метод для отримання єдиного екземпляру додатку.
     *
     * @return єдиний екземпляр додатку
     */
    public static Application getInstance() {
        return instance;
    }

    /**
     * Метод для запуску додатку, який додає команди до меню та виконує їх.
     *
     * @throws Exception виняток, якщо сталася помилка під час виконання
     */
    public void run() throws Exception {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.execute();
    }
}
