package ru.innopolis.vikkay.stc.Part1.lesson05;

/**
 * PersconException
 *
 * Исключение выбрасываемое при ошибке работы с картотекой
 *
 *     @author Viktor Kochetkov
 *     @version 2.0 (19.03.2021)
 */

public class PersconException extends IllegalArgumentException {

    public PersconException(String message) {

        super(message);
    }
}
