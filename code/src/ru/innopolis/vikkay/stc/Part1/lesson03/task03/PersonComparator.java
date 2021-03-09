package ru.innopolis.vikkay.stc.Part1.lesson03.task03;

import java.util.Comparator;

/**
 * Comparator
 *
 * Класс сравнивает объекты Person
 *
 * @author Viktor Kochetkov
 * @version 1.0 (07.03.2021)
 */

public class PersonComparator implements Comparator <Person> {

    public int compare(Person o1, Person o2) {

        /* строки ниже работают некорректно. Исключение вылетает даже на минимальном массиве */

//        if (o1.name == o2.name && o1.age == o2.age) { // Если совпадает имя и возраст - бросаем исключение
//            throw new PersconException("Найдены объекты с одинаковым именем и возрастом:\n" + o1.name + " " + o1.sex + " " + o1.age);
//       }

        int sexResult = o1.getSex().compareTo(o2.getSex());      // Сравниваем пол
        if (sexResult != 0) return sexResult;

        int ageResult = o2.getAge() - o1.getAge();              // Сравниваем возраст
        if (ageResult != 0) return ageResult;

        int nameResult = o2.getName().compareTo(o1.getName());  // Сравниваем имена
        if (nameResult != 0) return nameResult;
        return nameResult;
    }
}

