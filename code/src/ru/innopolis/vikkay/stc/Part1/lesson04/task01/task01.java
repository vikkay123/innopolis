package ru.innopolis.vikkay.stc.Part1.lesson04.task01;



import ru.innopolis.vikkay.stc.Part1.lesson03.task03.Person;
import ru.innopolis.vikkay.stc.Part1.lesson03.task03.PersonComparator;
import ru.innopolis.vikkay.stc.Part1.lesson03.task03.SortOne;
import ru.innopolis.vikkay.stc.Part1.lesson03.task03.SortTwo;

import java.util.*;

/*
Задание 1. Написать класс MathBox, реализующий следующий функционал:

        Конструктор на вход получает массив Number. Элементы не могут повторяться.
        Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
        Существует метод summator, возвращающий сумму всех элементов коллекции.
        Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
        являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления.
        Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать MathBox
        для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap).
        Выполнение контракта обязательно!
        Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
 */

/**
 * MathBox
 *
 * Класс работает с массивом Number.
 * Mетод summator, возвращает сумму всех элементов коллекции
 * Mетод splitter, выполняет поочередное деление всех хранящихся в коллекции элементов на заданный делитель
 * Метод remove, получает на вход Integer и если такое значение есть в коллекции, удаляет его
 *
 * @author Viktor Kochetkov
 * @version 1.0 (11.03.2021)
 */

public class task01 {

    public static class MathBox <T extends Number>  {

        public Set<T> getSetArray() {
            return setArray;
        }

        private Set<T> setArray = new TreeSet(new ComparatorNum());  // создаем объект коллекции TreeSet

        public MathBox(T[] array) {                     // метод принимает на вход массив array
            setArray.addAll(Arrays.asList(array));      // и добавляет его в коллекцию
        }


            protected double summator(Number[] numbers) {       // метод суммирует все элементы коллекции
            double scale = Math.pow(10, 1);
            double sum = 0;

            for (Number i : setArray) {
                sum += i.doubleValue();
            }
            System.out.println("Сумма всех элементов в коллекции = " + (Math.ceil(sum * scale)) / scale);
            return sum;
        }

           protected Set splitter(int n) {                      // метод делит все элементы коллекции на заданное число n

            Set temp = new HashSet();                      // временная коллекция

            double div;
            double scale = Math.pow(10, 1);

            for (Number i : setArray) {
                div =  i.doubleValue() / n;
                temp.add((Math.ceil(div * scale)) / scale);
            }
            setArray.clear();
            setArray.addAll(temp);                          // переносим коллекцию из временной в основную
            System.out.println("Результат деления на " + n + ": "+ setArray);

        return setArray;
        }

           protected void remove (Integer n){                    // метод удаляет из коллекции элемент если он совпадает с заданным числом n

            Iterator <T> iterator = setArray.iterator();   // создаем итератор
            while (iterator.hasNext()) {
                T e = iterator.next();
                if (e.equals(n)) {                          // если элемент совпадает с заданным
                    iterator.remove();                      // удаляем его
                }
            }
            System.out.println("Удален элемент       " + n + ": "+ setArray);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MathBox)) return false;
            MathBox mathBox = (MathBox) o;
            return setArray.equals(mathBox.setArray);
        }
        @Override
        public int hashCode() {
            return  Objects.hash(setArray);
        }

        @Override
        public String toString() {
            return "MathBox :               "  + setArray;
        }
    }
}
