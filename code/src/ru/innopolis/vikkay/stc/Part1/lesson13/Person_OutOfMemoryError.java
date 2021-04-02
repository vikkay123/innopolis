package ru.innopolis.vikkay.stc.Part1.lesson13;

import java.util.HashMap;
import java.util.Map;

/**
 * Задание 1. Необходимо создать программу, которая продемонстрирует утечку памяти в Java.
 * При этом объекты должны не только создаваться, но и периодически частично удаляться, чтобы GC
 * имел возможность очищать часть памяти. Через некоторое время программа должна завершиться с ошибкой
 * OutOfMemoryError c пометкой Java Heap Space.
 *
 *  Неверные реализации equals() и hashCode()
 *  Ошибка -  OutOfMemoryError: GC overhead limit exceeded
 *
 *
 * @author Viktor Kochetkov
 * @version 1.0 (01.04.2021)
 *
 */

public class Person_OutOfMemoryError {

    public String name;

    public Person_OutOfMemoryError(String name) {
        this.name = name;
    }


    public static void main(String[] args) {

        Map<Person_OutOfMemoryError, Integer> map = new HashMap<>();

        for (int i = 0; i < 10_000_000; i++) {

            map.put(new Person_OutOfMemoryError("Вася"), 1);
            // Map не может содержать дубликаты ключей
            // Поскольку мы не переопределили метод equals(),
            // дублирующие объекты накопились и заняли память
        }
       // System.out.println(map.values()); // для контроля создаваемых объектов
    }

    /* Для правильной реализации */

//    @Override
//    public int hashCode() {
//        int res = 17;
//        res = 31 * res + name.hashCode();
//        return res;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//        if (!(o instanceof Person_OutOfMemoryError)) {
//            return false;
//        }
//        Person_OutOfMemoryError person = (Person_OutOfMemoryError) o;
//        return person.name.equals(name);
//    }

}
