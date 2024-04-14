package ex07;

import ex03.View;
import ex04.ViewableTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Реалізує шаблон Observer
 */
public class App extends JFrame implements Viewed {
    private final ArrayList<Viewer> viewers = new ArrayList<>();
    View view = new ViewableTable().getView();

    private JPanel Panel;
    private JTable Table;
    private JSpinner Count;
    private JButton Enter;
    private JButton Save;
    private JButton Restore;
    private JButton Undo;

    public App() {
        setContentPane(Panel);
        setSize(800, 480);
        setVisible(true);

        OnClick listener = new OnClick();

        Enter.addActionListener(listener);
        Save.addActionListener(listener);
        Restore.addActionListener(listener);
        Undo.addActionListener(listener);

        addViewer(new EnterViewer(this));
        addViewer(new SaveViewer(this));
        addViewer(new RestoreViewer(this));
        addViewer(new UndoViewer(this));
    }

    /**
     * Додає спостерігача
     */
    public void addViewer(Viewer viewer) {
        viewers.add(viewer);
    }

    /**
     * Оновлює спостерігачів
     */
    public void updateViewers(String message) throws Exception {
        for (Viewer viewer: viewers) {
            viewer.update(message);
        }
    }

    /**
     * Оновлює дані в таблиці
     */
    public void updateTable() {
        Object[][] values = new Object[view.viewItems().size()][4];

        for (int i = 0; i < values.length; i++) {
            values[i][0] = view.viewItems().get(i).getNumber();
            values[i][1] = view.viewItems().get(i).getBinRepresentation();
            values[i][2] = view.viewItems().get(i).getOctRepresentation();
            values[i][3] = view.viewItems().get(i).getHexRepresentation();
        }

        Table.setModel(new DefaultTableModel(values, new String[]{"Число", "Двійкове", "Вісімкове", "Шістнадцяткове"}));
    }

    /**
     * Повертає кількість очікуваних результатів
     */
    public int getCount() {
        return (Integer) Count.getValue();
    }

    /**
     * Повертає екземпляр класу {@link View}
     */
    public View getView() {
        return this.view;
    }

    /**
     * Обробляє натиснення на кнопки
     */
    class OnClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton button) {
                try {
                    updateViewers(button.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
