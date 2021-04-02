package ru.innopolis.vikkay.stc.Part1.lesson13;

import javassist.ClassPool;

/**
 * Задание 2. Доработать программу так, чтобы ошибка OutOfMemoryError возникала в Metaspace /Permanent Generation
 *
 *  ключ для ограничения Metaspace:   java -XX:MaxMetaspaceSize=10m
 *
 * @author Viktor Kochetkov
 * @version 1.0 (01.04.2021)
 */


class OutOfMemoryErrorMetaspace {

    static ClassPool classPool = ClassPool.getDefault();


    public static void main(String[] args) throws Exception {

        int count = 0;

        while (true) {

            Class cl = classPool.makeClass("MyClass" + count++).toClass();
            System.out.println(cl.getName());
        }
    }
}
