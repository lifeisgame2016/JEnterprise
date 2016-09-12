package javaee.generics.mod2;

/**
 * Created by Den on 24.08.2016.
 */
public interface Validator <T> {

    // Валидирует переданое значение
    boolean isValid(T result);
}
