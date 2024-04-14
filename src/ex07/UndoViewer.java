package ex07;

import java.util.Objects;

/**
 * Виконує команду відміни
 */
public class UndoViewer implements Viewer {
    private final App app;

    public UndoViewer(App app) {
        this.app = app;
    }

    /**
     * Оновлює спостерігача
     */
    @Override
    public void update(String message) {
        if (!Objects.equals(message, "Відмінити")) {
            return;
        }

        app.getView().viewUndo();
        app.updateTable();
    }
}
