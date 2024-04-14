package ex07;

import java.util.Objects;

/**
 * Виконує розрахунки при натисненні на відповідну кнопку
 */
public class EnterViewer implements Viewer {
    private final App app;

    public EnterViewer(App app) {
        this.app = app;
    }

    /**
     * Оновлює спостерігача
     */
    @Override
    public void update(String message) {
        if (!Objects.equals(message, "Розрахувати")) {
            return;
        }

        app.getView().viewInit(app.getCount());
        app.updateTable();
    }
}
