package ru.innopolis.vikkay.stc.Part1.lesson04.task02;

import java.util.*;
import java.lang.*;

/**
 *
 * Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.
 *
 *         У класса должен быть метод addObject, добавляющий объект в коллекцию.
 *         У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
 *         Должен быть метод dump, выводящий содержимое коллекции в строку.
 *
 *  @author Viktor Kochetkov
 *  @version 1.0 (12.03.2021)
 */

public  class ObjectBox  {

      private Set<Object> object = new HashSet();

      private void addObject(Object o) {                      // метод добавляющий объект в коллекцию
        object.add(o);
    }

              private void deleteObject(Object o) {                  // метод проверяющий наличие объекта в коллекции и при наличии удаляющий его

                Iterator <Object> iterator = object.iterator();   // создаем итератор
                while (iterator.hasNext()) {
                    Object e = iterator.next();
                    if (e.equals(o)) {                            // если элемент совпадает с заданным
                        iterator.remove();                        // удаляем его
                    }
                }
            }

       private void dump() {                                  //метод выводящий содержимое коллекции в строку

        for (Object o : object ) {
            System.out.println(o.getName() + " " + o.getAge() + " " + o.getSex());
        }
    }


//    public static void main(String[] args) {             // для проверки работы класса ObjectBox
//
//        ObjectBox obj = new ObjectBox();
//
//        Object objectOne = new Object("Иван", 25, "мужчина");
//
//        obj.addObject(objectOne);
//        obj.addObject(new Object("Марья", 34, "женщина"));
//        obj.addObject(new Object("Дарья", 30, "женщина"));
//        obj.addObject(new Object("Кирилл", 41, "мужчина"));
//        obj.addObject(new Object("Сергей", 18, "мужчина"));
//
//        System.out.println("Созданная коллекция:");
//        obj.dump();
//
//        System.out.println();
//        obj.deleteObject(objectOne);
//        System.out.println("Один элемент удален: [" + objectOne.getName() + "]");
//        obj.dump();
//    }
}
