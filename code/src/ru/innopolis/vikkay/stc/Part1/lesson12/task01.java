package ru.innopolis.vikkay.stc.Part1.lesson12;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

/**
 * Задание: Перевести одну из предыдущих работ на использование стримов и лямбда-выражений там,
 * где это уместно (возможно, жертвуя производительностью)
 * <p>
 * Переписана задача ДЗ_8
 * Написать программу для вычисления факториалов всех элементов массива.
 *
 * @author Viktor Kochetkov
 * @version 1.0 (2.04.2021)
 */

public class task01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Задаем размер массива числом с консоли

        Scanner scan = new Scanner(System.in);
        int[] arrayNumber;

        System.out.println("Задайте размер массива. Введите целое число");
        int n = scan.nextInt();                                      // вводим число с консоли

        while (n < 0 || n == 0) {
            System.out.println("Введено не корректное число: " + n);
            System.out.println("Введите целое положительное число: ");
            n = scan.nextInt();
        }

        /* было */

//         arrayNumber = new int[n];                           // инициализируем массив числом n
//        for (int i = 0; i < arrayNumber.length; i++) {      // заполняем массив случайными числами
//            arrayNumber[i] = new Random().nextInt(1000);
//        }

        /* стало */
        arrayNumber = new Random().ints(n, 0, 10).toArray();

        // вывод на экран
        System.out.println("Сгенерированные числа: ");

        /* было */

//        for (int i : arrayNumber) {
//            System.out.print(i + " ");
//        }

        /* стало */
        Arrays.stream(arrayNumber).forEach(s -> System.out.print(s + " "));

        System.out.println("\n");

        System.out.println("Факториалы: ");

        // вычисляем факториалы в пуле потоков

        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2); // Создаем пулл из 2х потоков

        long startTimeСalculationFactorial = System.currentTimeMillis();           // засекаем время начала вычислений

        Future futureResult[] = new Future[arrayNumber.length];

        for (int i = 0; i < arrayNumber.length; i++) {

            final FactorialForStream stream = new FactorialForStream();

            stream.getFactorial(arrayNumber[i]);                                   // подаем число из массива в метод для вычисления его факториала
            futureResult[i] = pool.submit(stream);
        }

        /* было */
//        for (int i = 0; i < futureResult.length; i++) {
//            System.out.println(arrayNumber[i] + ": " + futureResult[i].get());
//        }

        /* стало */
        Arrays.stream(futureResult).forEach(s -> {
            try {
                System.out.println(s.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        long stoptTimeСalculationFactorial = System.currentTimeMillis();         // засекаем время окончания вычислений

        System.out.println("Время выполнения расчетов: " + (stoptTimeСalculationFactorial - startTimeСalculationFactorial) + " мс");

        pool.shutdown();                                                       // останавливаем пул потоков

    }
}
