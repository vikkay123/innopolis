package ru.innopolis.vikkay.stc.Part1.lesson03.task03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * SortOne
 * Сортировка методами Java.
 *
 * @author Viktor Kochetkov
 */

public class SortOne implements PersonSort {


    @Override
    public Person[] sort(Person[] arrayPersons, Comparator <Person> comparator) {
        Arrays.sort(arrayPersons, comparator);
        return arrayPersons;
    }


}









