package ex07;

import java.io.IOException;

/**
 * Інтерфейс об'єкта який буде спостерігати. Реалізацію шаблону Observer
 */
public interface Viewer {
    /**
     * Оновлює спостерігача
     */
    public void update(String message) throws Exception;
}
