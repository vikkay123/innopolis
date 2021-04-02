package ru.innopolis.vikkay.stc.Part1.lesson13;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание 1.     Необходимо создать программу, которая продемонстрирует утечку памяти в Java.
 * При этом объекты должны не только создаваться, но и периодически частично удаляться, чтобы GC
 * имел возможность очищать часть памяти. Через некоторое время программа должна завершиться с ошибкой
 * OutOfMemoryError c пометкой Java Heap Space.
 *
 * Утечка памяти из-за статических полей
 * Ошибка - OutOfMemoryError: Java heap space
 *
 *
 * @author Viktor Kochetkov
 * @version 1.0 (01.04.2021)
 */

public class Static_OutOfMemoryError {

    //В Java время жизни статических полей обычно совпадает со временем работы приложения.

    public static List<Double> list = new ArrayList<>();
    public static Double num = 1.;

    public void staticTest() {

        for (int i = 0; i < 10_000; i++) {
            list.add(num + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100_000; i++) {
            new Static_OutOfMemoryError().staticTest();
        }


    }
}
