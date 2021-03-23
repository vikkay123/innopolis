package ru.innopolis.vikkay.stc.Part1.lesson_8;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Дан массив случайных чисел.
 * Написать программу для вычисления факториалов всех элементов массива.
 * Использовать пул потоков для решения задачи.
 *
 *   @author Viktor Kochetkov
 *   @version 1.0 (23.03.2021)
 */


public class task01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Задаем размер массива числом с консоли

        Scanner scan = new Scanner(System.in);
        int[] arrayNumber;

        System.out.println("Задайте размер массива. Введите целое число");
        int n = scan.nextInt();                                      // вводим число с консоли

        while( n < 0 || n == 0) {
            System.out.println("Введено не корректное число: " + n);
            System.out.println("Введите целое положительное число: ");
            n = scan.nextInt();
        }
                arrayNumber = new int[n];                           // инициализируем массив числом n

                for (int i = 0; i < arrayNumber.length; i++) {      // заполняем массив случайными числами
                    arrayNumber[i] = new Random().nextInt(10000);
               }

            // вывод на экран
            System.out.println("Сгенерированные числа: " );
            for (int i : arrayNumber) {
                System.out.print(i + " ");
            }
            System.out.println("\n");


        System.out.println("Факториалы: " );


        // вычисляем факториалы в пуле потоков

        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2); // Создаем пулл из 2х потоков

       long startTimeСalculationFactorial = System.nanoTime();           // засекаем время начала вычислений

        for (int i = 0; i < arrayNumber.length; i++) {

            final FactorialForStream stream =  new FactorialForStream();

                  stream.getFactorial(arrayNumber[i]);                  // подаем число из массива в метод для вычисления его факториала

                  Future <BigInteger> futureResult = pool.submit(stream);

            while(!futureResult.isDone()){                              // ждем завершение работы потока

                System.out.println("Идет вычисление...");
                Thread.sleep(3);
            }

            System.out.println(arrayNumber[i] + ": " + futureResult.get()); // вывод результатов в консоль
        }
        long stoptTimeСalculationFactorial = System.nanoTime();             // засекаем время окончания вычислений

        System.out.println("Время выполнения расчетов: " + (stoptTimeСalculationFactorial-startTimeСalculationFactorial)+" нс");

        pool.shutdown();                                                    // останавливаем пул потоков
    }

}
