package ru.innopolis.vikkay.stc.Part1.lesson04.task03;

/**
 *
 * Класс Object
 *
 * Для создания объектов и тестирования работы класса ObjectBox
 *
 *  @author Viktor Kochetkov
 *  @version 2.0 (13.03.2021)
 */

public class Object {

    private String name;
    private int age;
    private String sex;

    public Object(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }
}
