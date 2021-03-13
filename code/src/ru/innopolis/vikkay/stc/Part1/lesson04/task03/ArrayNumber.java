package ru.innopolis.vikkay.stc.Part1.lesson04.task03;

import java.util.Random;

/**
 * ArrayNumber
 *
 * Класс заполняет массив случайными числами
 *
 * @author Viktor Kochetkov
 * @version 2.0 (13.03.2021)
 */

public class ArrayNumber  {
    int num = 40; // задаем размер массива

    Number [] array = new Number[num]; // Создаем массив

            public Number []  generatorArray() { // метод заполняет массив случайными числами

                double scale = Math.pow(10, 1);  // для округления до десятых

                for (int i = 0; i < num; i++) {

                    int rng = new Random().nextInt(100);

                    if (rng % 2 == 0) {
                        array[i] = Math.ceil((new Random().nextDouble()*100)* scale)/ scale; // заполняет массив дробными числами

                    } else {
                        array[i] = Math.round(new Random().nextInt(10));    // заполняет массив целыми числами
                    }
                }
                //System.out.println("Исходный массив:        " + Arrays.asList(array));

                return array;
            }
    }
