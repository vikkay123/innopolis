package ru.innopolis.vikkay.stc.Part1.lesson05;
/**
 * Id
 *
 * Для генерации порядковых номеров записей в картотеке
 *
 *     @author Viktor Kochetkov
 *     @version 2.0 (19.03.2021)
 */



public class Id {

    private static int id=1;

    public int getId() {

        return id++;
    }
}
