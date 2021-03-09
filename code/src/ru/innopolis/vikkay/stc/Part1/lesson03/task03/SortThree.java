package ru.innopolis.vikkay.stc.Part1.lesson03.task03;

import java.util.Comparator;

/**
 * Сортировка вставками (Insertion Sort)
 *
 *
 *  @author Viktor Kochetkov
 *  @version 1.0 (7.03.2021)
 *
 */

public class SortThree implements PersonSort {

    @Override
    public Person[] sort(Person[] arrayPersons, Comparator<Person> comparator) {
        return sortThree(arrayPersons, comparator);
    }

    public static Person[] sortThree(Person[] arrayPersons, Comparator<Person> comparator) {

        for (int left = 1; left < arrayPersons.length; left++) {
            // Вытаскиваем значение элемента
            Person value = arrayPersons[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;

            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (comparator.compare(arrayPersons[i], value) >= 0) {

                    arrayPersons[i + 1] = arrayPersons[i];

                    } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                 }
            }
            // В освободившееся место вставляем вытащенное значение
            arrayPersons[i + 1] = value;
        }
        return arrayPersons;
    }
}