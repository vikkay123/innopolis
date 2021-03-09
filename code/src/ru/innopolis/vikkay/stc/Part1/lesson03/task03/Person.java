package ru.innopolis.vikkay.stc.Part1.lesson03.task03;


/**
 * Person
 *
 * Класс Person (для генерации объектов Person)
 *
 *     @author Viktor Kochetkov
 *     @version 1.0 (07.03.2021)
 */

public class Person  {

        String name;
        String sex;
        int age;

        public int getAge() {
            return age;
        }
        public String getName() {
            return name;
        }
        public String getSex() {
            return sex;
        }


        public Person (String name, String sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
}


