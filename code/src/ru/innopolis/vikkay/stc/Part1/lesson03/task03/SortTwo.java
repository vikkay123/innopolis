package ru.innopolis.vikkay.stc.Part1.lesson03.task03;

import java.util.Comparator;
/**
 * SortTwo
 * Выполняем сортировку моссива, методом быстрой сортировки.
 *
 * @author Viktor Kochetkov
 * @version 1.0 (7.03.2021)
 */

public class SortTwo implements PersonSort {

        @Override
        public Person[] sort (Person[] arrayPersons, Comparator<Person> comparator) {

            return sortTwo(arrayPersons, 0, arrayPersons.length-1, comparator);
        }

    public static Person[] sortTwo(Person [] arrayPersons, int leftBorder, int rightBorder, Comparator<Person> comparator) {

        int leftMarker = leftBorder;
        int rightMarker = rightBorder;

        Person pivot = arrayPersons[(leftMarker + rightMarker) / 2]; // опорный элемент

        while (leftMarker <= rightMarker) {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (comparator.compare(arrayPersons[leftMarker], pivot) < 0) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (comparator.compare(arrayPersons[rightMarker], pivot) > 0) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap

                    Person tmp = arrayPersons[leftMarker];
                    arrayPersons[leftMarker] = arrayPersons[rightMarker];
                    arrayPersons[rightMarker] = tmp;
                // Сдвигаем маркеры, чтобы получить новые границы
                    leftMarker++;
                    rightMarker--;
                }
            }

        // Выполняем рекурсивно для частей
        if (leftBorder < rightMarker) {
            sortTwo(arrayPersons, leftBorder, rightMarker, comparator);
        }
        if (rightBorder > leftMarker) {
            sortTwo(arrayPersons, leftMarker, rightBorder, comparator);
        }
        return arrayPersons;
    }
}
