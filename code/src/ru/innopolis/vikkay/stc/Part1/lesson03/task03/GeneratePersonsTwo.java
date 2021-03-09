package ru.innopolis.vikkay.stc.Part1.lesson03.task03;

import java.util.Random;
/**
 * GeneratePersonsTwo
 *
 * Генерация массива объектов Person
 *
 *
 * @author Viktor Kochetkov
 * @version 1.0 (07.03.2021)
 */

public class GeneratePersonsTwo {

        //случайный выбор мужского имени
        private static String randomManNames() {
            int name = new Random().nextInt(ManNames.values().length);
            return String.valueOf(ManNames.values()[name]);
        }
        //случайный выбор женского имени
        private static String randomWomanNames() {
            int name = new Random().nextInt(WomanNames.values().length);
            return String.valueOf(WomanNames.values()[name]);
        }
        //случайный выбор возраста
        private static int randomAge() {
            int age = new Random().nextInt(100);
            return age;
        }

        int n = 10; // Задаем размер массива. До 10000 и более
        Person[] persons = new Person[n]; // Создаем массив persons

        public void generatorPersons() {
            Sex gender = new Sex();
            String num;
            String sex = "";

            for (int i = 0; i < n; i++) {
                int rng = new Random().nextInt(100);
                if (rng % 2 == 0) {
                    num = randomManNames();
                    sex = gender.sexMan;

                    persons[i] = (new Person(num, sex, randomAge()));

                } else {
                    num = randomWomanNames();
                    sex = gender.sexWoman;

                    persons[i] = (new Person(num, sex, randomAge()));
                }
            }
//        for (Person p : persons) {
//            System.out.println(p.name + " " + p.sex + " " + p.age);
//        }
        }

        public void printPersons() {
            for (Person per : persons) {
                System.out.println(per.getName() + " " + per.getSex() + " " + per.getAge());
            }

    }
}
