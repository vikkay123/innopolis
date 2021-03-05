package ru.innopolis.vikkay.stc.Part1.lesson03;

/*
 * Задание 1. Написать программу ”Hello, World!”.
 * В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
 *
 *         Смоделировав ошибку «NullPointerException»
 *         Смоделировав ошибку «ArrayIndexOutOfBoundsException»
 *         Вызвать свой вариант ошибки через оператор throw
 */

/**
 *         @author Viktor Kochetkov
 *
 *         @version   1.0  (05 03 2021)
 */


public class task01 {
    public static void main(String[] args)  {

            String [] str = new String[1];
            String string = null;

            try {
                if (string.equals("Hello, World!")) {    // данная строка вызывает NPE
                    System.out.println(string);
                }
            }

            catch(NullPointerException e){
                System.out.println(e);
                }

            try{
                for (int i = 0; i < 2; i++) {  // данная строка вызывает ArrayIndexOutOfBoundsException
                    str[i] = string;
                }
                System.out.println(str[0]);

            }
            catch (Exception e){
                System.out.println(e);
            }
            try {
                throw new Exception("бросаем свое исключение");
            } catch (Exception e) {
                System.out.println(e);
            }
    }
}


