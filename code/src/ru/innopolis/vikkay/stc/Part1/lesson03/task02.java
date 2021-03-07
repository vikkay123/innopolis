package ru.innopolis.vikkay.stc.Part1.lesson03;

import java.util.Scanner;

/*
  Задание 2. Составить программу, генерирующую N случайных чисел.
  Для каждого числа k вычислить квадратный корень q.
  Если квадрат целой части q числа равен k, то вывести это число на экран.
  Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.
 */

/**
 * Программа, вычисляющая квадратный корень введенного числа.
 * и проверяющая квадрат целой части полученного числа на равенство целой части введенного числа
 *
 * @version   1.0  (07 03 2021)
 * @author    Viktor Kochetkov
 */

public class task02 {

    public static double sqrt(double q) {  //Метод sqrt() возвращает корень числа
        return Math.sqrt(q);
    }

    public static double pow(double k) {  //Метод pow() возвращает квадрат целой части числа
        return Math.pow((int)(k),2);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите целое положительное число задающее количество проверяемых чисел");

        int n = scan.nextInt();

                if(n  <= 0 ){
                    throw new IllegalArgumentException("Некорректный ввод: "+ n  + ". Введите число > 0.");
                }

        double[] num = new double[n];

        System.out.println("Введите проверяемые числа");

        double m;

            for (int i = 0; i < n; i++) {
                if((m = scan.nextDouble()) > 0) {
                    num[i] = m;
                }
                else throw new IllegalArgumentException("Некорректный ввод: "+ m  + ". Введите число > 0.");
            }


            for (int i = 0; i < num.length; i++) {

                if ((int)num[i] == pow((sqrt(num[i])))) { //Если квадрат целой части q числа равен k
                    System.out.println(num[i]);           // то выводим это число на экран.
                }
            }
    }
}


