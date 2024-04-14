package ex07;

import java.util.Objects;

/**
 * Десеріалізує дані при натисненні на відповідну кнопку
 */
public class RestoreViewer implements Viewer {
    private final App app;

    public RestoreViewer(App app) {
        this.app = app;
    }

    /**
     * Оновлює спостерігача
     */
    @Override
    public void update(String message) throws Exception {
        if (!Objects.equals(message, "Відновити")) {
            return;
        }

        app.getView().viewRestore();
        app.updateTable();
    }
}
