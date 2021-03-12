package ru.innopolis.vikkay.stc.Part1.lesson04.task03;

import java.util.*;

/*
 * Задание 3. Доработать классы MathBox и ObjectBox таким образом,
 * чтобы MathBox был наследником ObjectBox.
 * Необходимо сделать такую связь, правильно распределить поля и методы.
 * Функциональность в целом должна сохраниться.
 * При попытке положить Object в MathBox должно создаваться исключение.
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
 * @version 1.0 (12.03.2021)
 *
 */

public class task03 {

    public static class MathBox <T extends Number > extends ObjectBox {

        public Set<T> setArray = new HashSet();         // создаем объект коллекции HashSet

        public MathBox(T[] array) {                     // метод принимает на вход массив array
            setArray.addAll(Arrays.asList(array));      // и добавляет его в коллекцию
            //setArray = new HashSet(Arrays.asList(array));
        }

        public double summator(Number[] numbers) {       // метод суммирует все элементы коллекции
            double scale = Math.pow(10, 1);              // переменная scale для округления до десятых
            double sum = 0;

            for (Number i : setArray) {
                sum += i.doubleValue();
            }
            System.out.println("Сумма всех элементов в коллекции = " + (Math.ceil(sum * scale)) / scale);
            return sum;
        }

        public Set splitter(int n) {                      // метод делит все элементы коллекции на заданное число n

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

        public void remove (Integer n){                    // метод удаляет из коллекции элемент если он совпадает с заданным числом n

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
        public void addObject(Object o) {                    // метод ObjectBox - добавляет объект
            super.addObject(o);
        }

        @Override
        public void deleteObject(Object o) {                 // метод ObjectBox - удаляет объект
            super.deleteObject(o);
        }

        @Override
        public void dump() {                                  // метод ObjectBox - выводит на экран
            super.dump();
        }

        @Override
        public boolean equals(java.lang.Object o) {
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
