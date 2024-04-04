package ex04;

import ex03.View;
import ex03.Viewable;
import ex03.ViewableResult;

/**
 * Клас, що реалізує інтерфейс {@link Viewable} та надає об'єкт {@link ViewTable}.
 */
public class ViewableTable extends ViewableResult {

    /**
     * Повертає об'єкт {@link ViewTable} для відображення результатів.
     *
     * @return об'єкт {@link ViewTable}
     */
    @Override
    public View getView() {
        return new ViewTable();
    }
}
