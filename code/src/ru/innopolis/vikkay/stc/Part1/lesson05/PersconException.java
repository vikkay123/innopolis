package ru.innopolis.vikkay.stc.Part1.lesson05;

/**
 * PersconException
 *
 * Исключение выбрасываемое при ошибке работы с картотекой
 *
 *     @author Viktor Kochetkov
 *     @version 1.0 (16.03.2021)
 */

public class PersconException extends IllegalArgumentException {

    public PersconException(String message) {

        super(message);
    }
}
