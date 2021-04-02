package ru.innopolis.vikkay.stc.Part1.lesson13;

/**
 * Задание 1.     Необходимо создать программу, которая продемонстрирует утечку памяти в Java.
 * При этом объекты должны не только создаваться, но и периодически частично удаляться, чтобы GC
 * имел возможность очищать часть памяти. Через некоторое время программа должна завершиться с ошибкой
 * OutOfMemoryError c пометкой Java Heap Space.
 *
 * Создание массивов с размерами растущими в геометрической прогресии
 * Ошибка - OutOfMemoryError: Java heap space
 *
 * @author Viktor Kochetkov
 * @version 1.0 (01.04.2021)
 */


public class Array_OutOfMemoryError {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Размер памяти JVM: " + Runtime.getRuntime().maxMemory() + " байт");

        int num = 5;
        long[] array;

        for (int i = 0; i < 100; i++) {

            array = new long[num];
            array[0] = 1l;
            num += num * 2;
        }

    }
}
