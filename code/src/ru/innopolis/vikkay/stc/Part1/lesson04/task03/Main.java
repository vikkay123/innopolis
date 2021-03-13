package ru.innopolis.vikkay.stc.Part1.lesson04.task03;
import ru.innopolis.vikkay.stc.Part1.lesson04.task03.task03.MathBox;

import java.lang.*;
/**
 * Main
 *
 * Класс тестирует класс MathBox
 *
 * @author Viktor Kochetkov
 * @version 2.0 (13.03.2021)
 */

public class Main {
    public static void main(String[] args) {

        /* Работа на заданном масиве */
        Number[] num = {-1, 5, 2, 4.1, 0, 10, 13.3, 11.14, 75, 25, 1};

        System.out.println("[Заданный массив]");
        MathBox mathBoxNum = new MathBox(num);       // создаем объект класса MathBox
        System.out.println("Коллекция:              " + mathBoxNum.getSetArray());
        mathBoxNum.summator(num);                    // суммируем
        mathBoxNum.remove(1);                     // удаляем заданный элемент
        mathBoxNum.splitter(2);                   // делим на заданное число
        System.out.println();

        /* Работа на случайном масиве */
        System.out.println("[Случайный массив]");
        ArrayNumber arr = new ArrayNumber();        // создаем объект класса ArrayNumber
        arr.generatorArray();                       // генерируем массив

        MathBox mathBox = new MathBox(arr.array);  // создаем объект класса MathBox
        System.out.println("Коллекция:              " + mathBox.getSetArray());
        mathBox.summator(arr.array);               // суммируем
        mathBox.remove(5);                      // удаляем заданный элемент
        mathBox.splitter( 2);                   // делим на заданное число

        // попытка положить в коллекцию не Number

        try {
            MathBox mathBoxTwo = new MathBox((Number[]) new java.lang.Object());
        }
        catch (ClassCastException e){
            System.err.println("Кладем Object в MathBox: " + e);
        }
        System.out.println();

        // работа переопределенных методов ObjectBox
        System.out.println("[Работа переопределенных методов ObjectBox]");
        MathBox mathBoxObject = new MathBox(arr.array);
        mathBoxObject.addObject(new Object("Сергей", 24, "мужчина" ));
        mathBoxObject.addObject(new Object("Иван", 25, "мужчина" ));
        mathBoxObject.dump();

        System.out.println();
        //System.out.println(mathBox.toString());
        System.out.println("HashCode: " + mathBox.hashCode());
        System.out.println("Equals: " + mathBox.getSetArray().equals(arr.array));

    }
}
