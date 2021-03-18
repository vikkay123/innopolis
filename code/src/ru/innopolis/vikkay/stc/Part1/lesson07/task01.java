package ru.innopolis.vikkay.stc.Part1.lesson07;

import java.io.*;
import java.util.*;

/**
 * Задание 1. Написать программу, читающую текстовый файл.
 *            Программа должна составлять отсортированный по алфавиту список слов,
 *            найденных в файле и сохранять его в файл-результат.
 *            Найденные слова не должны повторяться, регистр не должен учитываться.
 *            Одно слово в разных падежах – это разные слова.
 *
 *  * @author Viktor Kochetkov
 *  * @version 1.0 (18.03.2021)
 */

public class task01 {

    public static void main(String[] args) {

            Set<String> setList = new LinkedHashSet<>(); // лист для хранения уникальных элементов

        /* Блок чтения из файла и обработки текста */

        try(BufferedReader br = new BufferedReader(new FileReader("c:/Temp/java/tmpIN.txt"))) // создаем переменную в которую будем считывать содержимое файла расположенного по указанному пути
        {
            String s;
            String stringOne = "";

            while((s = br.readLine()) != null){         //чтение построчно из файла
                stringOne  += Arrays.toString(s.toLowerCase().trim().split(" ")); // записываем в строку текст разбивая его на слова
            }
            String[] arr = stringOne.replaceAll("[^\\p{L}]+",  " ").trim().split(" "); // создаем массив слов, удаляем лишние символы

            Collections.sort(Arrays.asList(arr));       // сортировка массива
            Collections.addAll(setList, arr);           // запись массива в коллекцию, удаление дубликатов

//              for (String  str : setList) {System.out.println(str);} // для проверки заполнения коллекции

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        /* Блок записи в файл */

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("c:/Temp/java/tmpOUT.txt")))  // создаем переменную в которую будем записывать содержимое файла расположенного по указанному пути
        {
            for (String str : setList) {
                bw.write(str + "\n");                            //запись в файл
            }
//           for (String str : setList ) { System.out.println(str); }  // для проверки записанного файла

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
