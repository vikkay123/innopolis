package ru.innopolis.vikkay.stc.Part1.lesson03.task03;


import java.util.Comparator;

public interface PersonSort {
    /**
     *
     * Интерфейс sort
     *
     * @author Viktor_Kochetkov
     * @version 1.0 (07.03.2021)
     */

        Person[] sort(Person[] arrayPersons, Comparator<Person> comparator);  //массив объектов Person и компаратор для сравнения этих объектов

}

