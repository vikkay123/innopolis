package ru.innopolis.vikkay.stc.Part1.lesson10;

import java.io.*;

/**
* Класс MyClassLoader
*
* Загрузчик классов.
*
*
*  @author Viktor Kochetkov
*  @version 1.0 (27.03.2021)
*/

public class MyClassLoader  extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) {

        File classFile = new File(name + ".class");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(classFile))) {

            byte[] content = new byte[(int) classFile.length()];

            bis.read(content);

            final Class<?> simple = defineClass(name, content, 0, content.length);

            return simple;

        } catch (IOException e) {
            System.out.println("Что-то пошло не так" + "\n" + e);
            return null;
        }
    }


}
