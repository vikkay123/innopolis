package ru.innopolis.vikkay.stc.Part1.lesson05;


import java.util.Comparator;

/**
 * Comparator
 *
 * Класс сравнивает объекты Person
 * Поля для сортировки –  хозяин, кличка животного, вес
 *
 * @author Viktor Kochetkov
 * @version 1.0 (16.03.2021)
 */

public class PersonComparator implements Comparator <Person> {

    public int compare(Person o1, Person o2) {

        if ( o1.getId()==o2.getId() && o1 != o2) { // Если id объекта равны - бросаем исключение
            throw new PersconException("Данный id занят:\n" + o1.getOwnerName() + " " + o1.getAnimalName() + " " + o1.getAge());
        }

        int nameResult = o1.getOwnerName().compareTo(o2.getOwnerName());          // Сравниваем имена владельцев
        if (nameResult != 0) {
            return nameResult;
        }

        int nameAnimalResult = o2.getAnimalName().compareTo(o1.getAnimalName());  // Сравниваем клички
        if (nameAnimalResult != 0){ return nameAnimalResult;}

        int weightResult  = (int) (o2.getWeight() - o1.getWeight());              // Сравниваем вес
        if (weightResult  != 0){ return weightResult;}
        return weightResult;
    }
}

