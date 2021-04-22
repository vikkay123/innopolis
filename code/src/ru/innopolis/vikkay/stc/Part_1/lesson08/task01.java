package ru.innopolis.vikkay.stc.Part_1.lesson08;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;

/**
 * Задание: Перевести одну из предыдущих работ на использование стримов и лямбда-выражений там,
 * где это уместно (возможно, жертвуя производительностью)
 *
 * @author Viktor Kochetkov
 * @version 2.0 (8.04.2021)
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
        arrayNumber = new int[n];                           // инициализируем массив числом n

        for (int i = 0; i < arrayNumber.length; i++) {      // заполняем массив случайными числами
            arrayNumber[i] = new Random().nextInt(100);
        }

        // вывод на экран
        System.out.println("Сгенерированные числа: ");
        for (int i : arrayNumber) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        System.out.println("Факториалы: ");

        // вычисляем факториалы в пуле потоков

        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2); // Создаем пулл из 2х потоков

        long startTimeСalculationFactorial = System.currentTimeMillis();                      // засекаем время начала вычислений

        Future futureResult[] = new Future[arrayNumber.length];

        Map<Integer, BigInteger> result = new HashMap<>();                                    // для сохранения результатов вычислений

        for (int i = 0; i < arrayNumber.length; i++) {

            final FactorialForStream stream = new FactorialForStream();

            if (!result.isEmpty()) {                                                        // если результаты предыдущих вычислений есть
                if (result.containsKey(arrayNumber[i])) {                                   // ищем по ключу текущее число
                    System.out.println(arrayNumber[i] + ": " + result.get(arrayNumber[i])); // выводим результат
                } else {                                                                    // если икомого числа нет
                    futureResult[i] = pool.submit(stream.getFactorial(arrayNumber[i]));     // подаем число из массива в метод для вычисления его факториала
                    result.put(arrayNumber[i], (BigInteger) futureResult[i].get());         // сохраняем результат вычислений
                    System.out.println(arrayNumber[i] + ": " + futureResult[i].get());
                }
            } else {
                futureResult[i] = pool.submit(stream.getFactorial(arrayNumber[i]));
                result.put(arrayNumber[i], (BigInteger) futureResult[i].get());
                System.out.println(arrayNumber[i] + ": " + futureResult[i].get());
            }
        }
        long stoptTimeСalculationFactorial = System.currentTimeMillis();             // засекаем время окончания вычислений

        System.out.println("Время выполнения расчетов: " + (stoptTimeСalculationFactorial - startTimeСalculationFactorial) + " мс");

        pool.shutdown();                                                            // останавливаем пул потоков

    }
}
