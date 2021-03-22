package ru.innopolis.vikkay.stc.Part1.lesson05;

import java.io.IOException;
import java.util.*;

/**
 * Разработать программу – картотеку домашних животных.
 * У каждого животного есть уникальный идентификационный номер, кличка, хозяин
 * (объект класс Person с полями – имя, возраст, пол), вес.
 *
 * Реализовать:
 *
 *     метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
 *     поиск животного по его кличке (поиск должен быть эффективным)
 *     изменение данных животного по его идентификатору
 *     вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 *
 *
 *   @version   2.0  (19.03.2021)
 *   @author    Viktor Kochetkov
 */

public class task01 {

    public static void main(String[] args) throws IOException {

        char punkt;
        PetRepository <Person> list = new PetRepository();
        List<Person> animalList = new ArrayList<Person>() {};
        // заполняем картотеку
        list.arrayToMap(new Person(new Id().getId(), WomanNames.Сидорова_Анастасия.name(), AnimalName.Киса.name(), 4, SexAnimal.самка.toString(), 4.3));
        list.arrayToMap(new Person(new Id().getId(), ManNames.Белов_Роман.name(), AnimalName.Амур.name(), 7, SexAnimal.самец.toString(), 10.2));
        list.arrayToMap(new Person(new Id().getId(), ManNames.Куликов_Дмитрий.name(), AnimalName.Васька.name(), 8, SexAnimal.самец.toString(), 7.5));
        list.arrayToMap(new Person(new Id().getId(), WomanNames.Петрова_София.name(), AnimalName.Пушок.name(), 3, SexAnimal.самка.toString(), 5.8));
        list.arrayToMap(new Person(new Id().getId(), ManNames.Букин_Иван.name(), AnimalName.Азор.name(), 5, SexAnimal.самец.toString(), 7.9));
        list.arrayToMap(new Person(new Id().getId(), WomanNames.Потемкина_Ксения.name(), AnimalName.Амур.name(), 2, SexAnimal.самец.toString(), 5.5));
        list.arrayToMap(new Person(new Id().getId(), ManNames.Букин_Никита.name(), AnimalName.Азор.name(), 8, SexAnimal.самец.toString(), 10.5));

        do {
            System.out.println("Картотека домашних животных");
            System.out.println("    1. Просмотр картотеки");
            System.out.println("    2. Сортировка картотеки");
            System.out.println("    3. Удаление записи");
            System.out.println("    4. Добавление записи");
            System.out.println("    5. Замена записи");
            System.out.println("    6. Поиск записи");
            System.out.println("Введите номер нужного пункта:");
            punkt = (char) System.in.read();
        }
        while (punkt <'1' || punkt >'6');
        System.out.println();
        switch (punkt) {
            case '1':
                System.out.println("Картотека животных: ");

                for (Map.Entry<Integer, Person> p : list.getIdMap().entrySet()) {
                    System.out.println(p.getKey() + " Владелец: " + p.getValue().getOwnerName() +". Кличка животного: " + p.getValue().getAnimalName()+ ", возраст: " + p.getValue().getAge() + ", " + p.getValue().getAnimalSex() + ", вес: " + p.getValue().getWeight());
                }
                break;

            case '2':
                System.out.println("Картотека до сортировки: ");
                for (Map.Entry<Integer, Person> p : list.getIdMap().entrySet()) {
                    System.out.println(p.getKey() + " Владелец: " + p.getValue().getOwnerName() +". Кличка животного: " + p.getValue().getAnimalName()+ ", возраст: " + p.getValue().getAge() + ", " + p.getValue().getAnimalSex() + ", вес: " + p.getValue().getWeight());
                }
                System.out.println();
                //List<Person> animalList = new ArrayList<Person>() {};
                animalList.addAll(list.getAnimalList());
                animalList.sort(new PersonComparator());       // сортировка
                System.out.println("Картотека после сортировки: ");

                for (Person p : animalList) {
                    System.out.println(p.getId() + " Владелец: " + p.getOwnerName() +". Кличка животного: " + p.getAnimalName()+ ", возраст: " + p.getAge() + ", " + p.getAnimalSex() + ", вес: " + p.getWeight());
                }

                break;

            case '3':
                System.out.println("Картотека до удаления: ");
                for (Map.Entry<Integer, Person> p : list.getIdMap().entrySet()) {
                    System.out.println(p.getKey() + " Владелец: " + p.getValue().getOwnerName() +". Кличка животного: " + p.getValue().getAnimalName()+ ", возраст: " + p.getValue().getAge() + ", " + p.getValue().getAnimalSex() + ", вес: " + p.getValue().getWeight());
                }
                System.out.println();
                int id1 = 2;                                    // id удаляемой строки
                list.removeToMap(id1);
                animalList.addAll(list.getAnimalList());
                animalList.sort(new PersonComparator());       // сортировка
                System.out.printf("Картотека после сортировки и удаления строки №: %d", id1 );
                System.out.println();
                for (Person p : animalList) {
                    System.out.println(p.getId() + " Владелец: " + p.getOwnerName() + ". Кличка животного: " + p.getAnimalName() + ", возраст: " + p.getAge() + ", " + p.getAnimalSex() + ", вес: " + p.getWeight());
                }
                break;

            case '4':
                System.out.println("Картотека до добавления строки: ");
                for (Map.Entry<Integer, Person> p : list.getIdMap().entrySet()) {
                    System.out.println(p.getKey() + " Владелец: " + p.getValue().getOwnerName() +". Кличка животного: " + p.getValue().getAnimalName()+ ", возраст: " + p.getValue().getAge() + ", " + p.getValue().getAnimalSex() + ", вес: " + p.getValue().getWeight());
                }
                System.out.println();
                int n = 4;                                     // id добавляемой строки
                System.out.printf("Картотека после добавления строки №" + n +":");
                list.arrayToMap(new Person(n, "Крылова Ирина", "Киса", 4, SexAnimal.самка.toString(), 4.3));

                animalList.addAll(list.getAnimalList());
                animalList.sort(new PersonComparator());       // сортировка
                System.out.println();
                for (Person p : animalList) {
                    System.out.println(p.getId() + " Владелец: " + p.getOwnerName() + ". Кличка животного: " + p.getAnimalName() + ", возраст: " + p.getAge() + ", " + p.getAnimalSex() + ", вес: " + p.getWeight());
                }
                break;

            case '5':
                System.out.println("Картотека до замены строки: ");
                for (Map.Entry<Integer, Person> p : list.getIdMap().entrySet()) {
                    System.out.println(p.getKey() + " Владелец: " + p.getValue().getOwnerName() +". Кличка животного: " + p.getValue().getAnimalName()+ ", возраст: " + p.getValue().getAge() + ", " + p.getValue().getAnimalSex() + ", вес: " + p.getValue().getWeight());
                }
                System.out.println();
                int id2 = 3;

                list.changeToMap(id2, new Person(id2,"Зубов Степан", "Джерри", 3, SexAnimal.самка.toString(), 4.6));

                animalList.addAll(list.getAnimalList());
                animalList.sort(new PersonComparator());       // сортировка

                System.out.printf("Картотека после сортировки и замены строки №: %d", id2 );
                System.out.println();
                for (Person p : animalList) {
                    System.out.println(p.getId() + " Владелец: " + p.getOwnerName() + ". Кличка животного: " + p.getAnimalName() + ", возраст: " + p.getAge() + ", " + p.getAnimalSex() + ", вес: " + p.getWeight());
                }
                break;

            case '6':
                    System.out.println("Картотека животных: ");

                    for (Map.Entry<Integer, Person> p : list.getIdMap().entrySet()) {
                        System.out.println(p.getKey() + " Владелец: " + p.getValue().getOwnerName() +". Кличка животного: " + p.getValue().getAnimalName()+ ", возраст: " + p.getValue().getAge() + ", " + p.getValue().getAnimalSex() + ", вес: " + p.getValue().getWeight());
                    }
                    System.out.println();
                    String animalName = "Азор";

                    System.out.println("Поиск по кличке: " + animalName);
                    list.searchToMap(animalName);
        }
    }
}