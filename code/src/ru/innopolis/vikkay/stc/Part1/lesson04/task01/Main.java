package ru.innopolis.vikkay.stc.Part1.lesson04.task01;
import ru.innopolis.vikkay.stc.Part1.lesson04.task01.task01.MathBox;
/**
 * Main
 *
 * Класс тестирует класс MathBox
 *
 * @author Viktor Kochetkov
 * @version 1.0 (11.03.2021)
 */

public class Main {
    public static void main(String[] args) {

        /* Работа на заданном масиве */
        Number[] num = {1, 2, 2, 4.1, 5, 10, 11.3, 13.14, 22, 75, 1};

        System.out.println("[Заданный массив]");
        MathBox mathBoxNum = new MathBox(num);       // создаем объект класса MathBox
        System.out.println("Коллекция:              " + mathBoxNum.setArray);
        mathBoxNum.summator(num);                    // суммируем
        mathBoxNum.remove(1);                     // удаляем заданный элемент
        mathBoxNum.splitter(2);                   // делим на заданное число
        System.out.println();

        /* Работа на случайном масиве */
        System.out.println("[Случайный массив]");
        ArrayNumber arr = new ArrayNumber();        // создаем объект класса ArrayNumber
        arr.generatorArray();                       // генерируем массив

        MathBox mathBox = new MathBox(arr.array);  // создаем объект класса MathBox
        System.out.println("Коллекция:              " + mathBox.setArray);
        mathBox.summator(arr.array);               // суммируем
        mathBox.remove(5);                      // удаляем заданный элемент
        mathBox.splitter( 2);                   // делим на заданное число

//        System.out.println();
//        System.out.println(mathBox.toString());
//        System.out.println(mathBox.hashCode());
//        System.out.println(mathBox.setArray.equals(arr.array));

    }
}
