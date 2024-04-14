package ex07;

import java.io.IOException;
import java.util.Objects;

/**
 * Серіалізує дані при натисненні на відповідну кнопку
 */
public class SaveViewer implements Viewer {
    private final App app;

    public SaveViewer(App app) {
        this.app = app;
    }

    /**
     * Оновлює спостерігача
     */
    @Override
    public void update(String message) throws IOException {
        if (!Objects.equals(message, "Зберегти")) {
            return;
        }

        app.getView().viewSave();
    }
}
