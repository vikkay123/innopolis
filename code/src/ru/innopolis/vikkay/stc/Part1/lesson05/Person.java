package ru.innopolis.vikkay.stc.Part1.lesson05;


/**
 * Person
 *
 * Класс Person (для генерации объектов Person)
 * (объект класс Person с полями – имя, возраст, пол), вес.
 *
 *     @author Viktor Kochetkov
 *     @version 1.0 (16.03.2021)
 */

public class Person {

        private int id;            // уникальный идентификационный номер животного
        private String ownerName;  // имя хозяина
        private String animalName; // кличка животного
        private int age;           // возраст животного
        private String animalSex;  // пол животного
        private double weight;     // вес животного



        public int getId() {
        return id;
    }
        public  int getAge() {
            return age;
        }
        public  String getOwnerName() {
            return ownerName;
        }
        public  String getAnimalName() {
        return animalName;
    }
        public  String getAnimalSex() {
            return animalSex;
        }
        public  double getWeight() {
        return weight;
    }


        public Person(String ownerName, String animalName, int age, String animalSex, double weight) {

            this.ownerName = ownerName;
            this.animalName = animalName;
            this.age = age;
            this.animalSex = animalSex;
            this.weight = weight;
        }

    public Person(int id, String ownerName, String animalName, int age, String animalSex, double weight) {
        this.id = id;
        this.ownerName = ownerName;
        this.animalName = animalName;
        this.age = age;
        this.animalSex = animalSex;
        this.weight = weight;
    }
}


