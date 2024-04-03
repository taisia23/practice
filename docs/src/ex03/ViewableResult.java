package ex03;

public class ViewableResult implements Viewable {
    /**
     * Створює об'єкт, реалізуючий {@link View}
     */
    @Override
    public View getView() {
        return new ViewResult();
    }
}
