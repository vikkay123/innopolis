package ru.innopolis.vikkay.stc.Part1.lesson03.task03;

/**
 * PersconException
 *
 * Исключение выбрасываемое при совпадении имен и возрастов
 *
 *     @author Viktor Kochetkov
 *     @version 1.0 (07.03.2021)
 */

public class PersconException extends IllegalArgumentException {

    public PersconException(String message) {

        super(message);
    }
}
