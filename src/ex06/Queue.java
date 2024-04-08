package ex06;

import ex05.Command;

public interface Queue {
    /** Додає задачу в чергу */
    public void put(Command command);
    /** Вилучає задачу з черги */
    public Command take();
}
