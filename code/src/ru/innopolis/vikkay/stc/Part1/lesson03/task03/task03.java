package ru.innopolis.vikkay.stc.Part1.lesson03.task03;

import java.util.Arrays;
import java.util.List;

/**
 * Дан массив объектов Person.
 * Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN),
 * name (имя - строка).
 * Создать два класса, методы которых будут реализовывать сортировку объектов.
 * Предусмотреть единый интерфейс для классов сортировки.
 * Реализовать два различных метода сортировки этого массива по правилам:
 *
 *         первые идут мужчины
 *         выше в списке тот, кто более старший
 *         имена сортируются по алфавиту
 *
 *     Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
 *     Предусмотреть генерацию исходного массива (10000 элементов и более).
 *     Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
 *
 *     @author Viktor Kochetkov
 *     @version 1.0 (07.03.2021)
 */

public class task03 {

    public static void main(String[] args) {
        long startTimeSortOne, startTimeSortTwo, startTimeSortThree,
             stopTimeSortOne, stopTimeSortTwo, stopTimeSortThree;

        //GeneratePersons gp = new GeneratePersons();
        GeneratePersonsTwo gp = new GeneratePersonsTwo(); // Создаем объект генерирующий список Person
        gp.generatorPersons();                            // генерируем сам список объектов Person

        //System.out.println("Список до сортировки: ");
       // gp.printPersons();                                //выводим сгенерированный список на экран

        System.out.println();

        try {
            /* Первая сортировка */

            startTimeSortOne = System.nanoTime(); //Засекаем время первой сортировки

            List<Person> listSortOne = Arrays.asList(new SortOne().sort(gp.persons, new PersonComparator())); // Первая сортировка списка

            System.out.println("Список после первой сортировки: ");

                for (Person p : listSortOne) {
                    System.out.println(p.getName() + " " + p.getSex() + " " + p.getAge()); // Вывод отсортированного списка на экран
                }
            stopTimeSortOne = System.nanoTime();    //Останавливаем время первой сортировки

            System.out.println("Время сортировки методом Java - " + (stopTimeSortOne - startTimeSortOne) + ", нс"); // Считаем время сортировки и выводим его на экран
            System.out.println();

            /* Вторая сортировка */

            startTimeSortTwo = System.nanoTime(); //Засекаем время второй сортировки

            List<Person> listSortTwo = Arrays.asList(new SortTwo().sort(gp.persons, new PersonComparator())); // Вторая сортировка списка

            System.out.println("Список после второй сортировки: ");

                for (Person p : listSortTwo) {
                    System.out.println(p.getName() + " " + p.getSex() + " " + p.getAge()); // Вывод отсортированного списка на экран
                }
            stopTimeSortTwo = System.nanoTime();    //Останавливаем время второй сортировки

            System.out.println("Время быстрой сортировки - " + (stopTimeSortTwo - startTimeSortTwo) + ", нс");// Считаем время сортировки и выводим его на экран
            System.out.println();

            /* Третья сортировка */

            startTimeSortThree = System.nanoTime(); //Засекаем время третьей сортировки

            List<Person> listSortThree = Arrays.asList(new SortThree().sort(gp.persons, new PersonComparator())); // Третья сортировка списка
            System.out.println("Список после третьей сортировки: ");

                    for (Person p : listSortThree) {
                        System.out.println(p.getName() + " " + p.getSex() + " " + p.getAge()); // Вывод отсортированного списка на экран
                    }
            stopTimeSortThree = System.nanoTime();    //Останавливаем время третьей сортировки

            System.out.println("Время сортировки вставками - " + (stopTimeSortThree - startTimeSortThree) + ", нс");// Считаем время сортировки и выводим его на экран

        } catch (PersconException e) {
            System.out.println(e.getMessage()); // Исключение при совпадении имени и возраста
        }

    }
}







