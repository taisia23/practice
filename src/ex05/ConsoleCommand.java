package ex05;

/**
 * Інтерфейс, який розширює інтерфейс Command та представляє команду консолі з гарячою клавішою.
 */
public interface ConsoleCommand extends Command {
    /**
     * Метод, що повертає гарячу клавішу для команди консолі.
     *
     * @return гаряча клавіша для команди
     */
    char getKey();
}
