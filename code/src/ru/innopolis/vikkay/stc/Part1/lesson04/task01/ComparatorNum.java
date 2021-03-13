package ru.innopolis.vikkay.stc.Part1.lesson04.task01;

import java.util.Comparator;

/**
 * Comparator
 *
 * Класс сравнивает числа
 *
 * @author Viktor Kochetkov
 * @version 2.0 (13.03.2021)
 */

public class ComparatorNum implements Comparator<Number> {

    private int i;

    @Override
    public int compare(Number o1, Number o2){

        if(o1.getClass().equals(Double.class) && o2.getClass().equals(Double.class)){

            i = Double.compare((double)o1, (double)o2);
            return i;
        }
        if(o1.getClass().equals(Integer.class) && o2.getClass().equals(Integer.class)){

            i = Integer.compare((int)o1, (int)o2);
            return i;
        }
        if(o1.getClass().equals(Integer.class) && o2.getClass().equals(Double.class)){

            i = Double.compare((int)o1, (double)o2);
            return i;
        }
        if(o1.getClass().equals(Double.class) && o2.getClass().equals(Integer.class)){

            i = Double.compare((double)o1, (int)o2);
            return i;
        }
        return i;
    }
}

