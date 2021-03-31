package ru.innopolis.vikkay.stc.Part1.lesson10;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Необходимо написать программу, выполняющую следующее:
 *
 *     Программа с консоли построчно считывает код метода doWork.
 *     Код не должен требовать импорта дополнительных классов.
 *     После ввода пустой строки считывание прекращается и считанные строки добавляются в
 *     тело метода public void doWork() в файле SomeClass.java.
 *     Файл SomeClass.java компилируется программой (в рантайме) в файл SomeClass.class.
 *     Полученный файл подгружается в программу с помощью кастомного загрузчика
 *     Метод, введенный с консоли, исполняется в рантайме (вызывается у экземпляра объекта подгруженного класса)
 *
 * @author Viktor Kochetkov
 * @version 1.0 (27.03.2021)
 *
 */

          /* Код для проверки: */

//        public void doWork() {
//        System.out.println("Hello, World!");
//        }

public class Main {

    public static void main(String[] args) {

        ArrayList<String> textFile = new ArrayList<>();     // лист для записи строк программы

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {

                String str = "";

                  textFile.add("public class SomeClass {\n");               // добавляем в файл первую строку

                        while (!(str = br.readLine()).equals(" ")){         // пока не введена пустая строка
                            textFile.add(str);                              // добавляем в файл остальные строки
                            }

                  textFile.add("\n"+"}");

            } catch (IOException e) {
                e.printStackTrace();
            }

                try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                                                          (new FileOutputStream("SomeClass.java"), Charset.forName("UTF-8")))) { // Путь и имя записываемого файла

                        for (String s : textFile) {
                            bw.write(s);                                 // записываем в файл строки из листа
                        }

                bw.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        try {

            Runtime.getRuntime().exec("cmd /c javac SomeClass.java");               // компилируем

            MyClassLoader myClassLoader = new MyClassLoader();                               // создаем экземпляр MyClassLoader

            Thread.sleep(1000);
            final Class <?> simpleClass = Class.forName("SomeClass", true, myClassLoader); // загружаем класс

                     // System.out.println(simpleClass.getClassLoader());                   // проверяем каким ClassLoader-ом загрузилось

                     Method[] sc = simpleClass.getMethods();                               // массив доступных методов в загруженном классе

                     //System.out.println("Доступный метод в нашем классе: " + sc[0]);

                    Object instance = simpleClass.getConstructor().newInstance();          // создаем экземпляр загруженного класса
                    System.out.println("Результат: ");
                    simpleClass.getMethod("doWork").invoke(instance);                 // вызываем метод "doWork" у загруженного класса


        } catch ( ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
