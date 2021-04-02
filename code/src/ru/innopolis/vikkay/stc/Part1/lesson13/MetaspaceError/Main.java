package ru.innopolis.vikkay.stc.Part1.lesson13.MetaspaceError;

/**
 * Задание 2. Доработать программу так, чтобы ошибка OutOfMemoryError возникала в Metaspace /Permanent Generation
 *
 *  ключ для ограничения Metaspace:   -XX:MaxMetaspaceSize=10m
 *
 * @author Viktor Kochetkov
 * @version 1.0 (01.04.2021)
 */

public class Main {

    static int count = 0;

    public static void main(String[] args) throws ClassNotFoundException {

        while (true) {

            MyClassLoader myClassLoader = new MyClassLoader();                               // создаем экземпляр MyClassLoader

            final Class<?> simpleClass = Class.forName("SomeClass", true, myClassLoader); // загружаем класс
            System.out.println(simpleClass.getName()+"_"+count++);

        }
    }
}
