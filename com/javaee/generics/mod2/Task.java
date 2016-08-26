package com.javaee.generics.mod2;

/**
 * Created by Den on 24.08.2016.
 */
public interface Task<T> {

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();
}


