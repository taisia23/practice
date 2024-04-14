package ex07;

/**
 * Інтерфейс об'єкта який буде спостерігатися. Реалізацію шаблону Observer
 */
public interface Viewed {
    /**
     * Додає спостерігача
     */
    public void addViewer(Viewer viewer);

    /**
     * Оновлює спостерігачів
     */
    public void updateViewers(String message) throws Exception;
}
