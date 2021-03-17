package ru.innopolis.vikkay.stc.Part1.lesson05;

import java.util.*;

/**
 * AddListAnimal
 *
 * Методы работы с коллекцией
 *    - arrayToMap - добавляем строку если id свободен
 *    - removeToMap - удаляем строку по id
 *    - changeToMap - заменяем строку по id
 *    - searchToMap - ищем строку по кличке животного
 *
 *  @version   1.0  (16 03 2021)
 *  @author    Viktor Kochetkov
 */

public class AddListAnimal {

      public static List<Person> animalList = new ArrayList<Person>() {};

      public  List<Person> getAnimalList() {                                    // Создаем коллекцию из значений мапы
           animalList.addAll(IdMap.values());
           return animalList;
      }

      private Map<Integer, Person> IdMap = new HashMap<>();
      public Map<Integer, Person> getIdMap() {
                    return IdMap;
                }


           public void arrayToMap(Person person) {                          // добавляем строку если id свободен

                if (IdMap.containsKey(person.getId())) {
                    System.err.println("Вы пытаетесь добавить уже существующую строку. id = "+person.getId()+" занят!");
                }
                    else IdMap.put(person.getId(), person);
           }

           public void removeToMap(int id) {                                 // удаляем строку по id

                   if(IdMap.containsKey(id)){
                        IdMap.remove(id);
                        animalList.clear();
                        animalList.addAll(IdMap.values());
                        animalList.sort(new PersonComparator());
                    }
                   else System.err.println("Вы пытаетесь удалить не существующую строку. Такого id нет!");
           }

           public void changeToMap(int id, Person p) {                     // заменяем строку по id

                    if(IdMap.containsKey(id)){
                        IdMap.replace(id,  p);
                        animalList.clear();
                        animalList.addAll(IdMap.values());
                        animalList.sort(new PersonComparator());
                    }
                    else System.err.println("Вы пытаетесь заменить не существующую строку. Такого id нет!");
            }

            public void searchToMap(String animalName) {                       // ищем строку по кличке животного

                    for (Map.Entry<Integer, Person> p : IdMap.entrySet()) {
                        if (animalName.equals(p.getValue().getAnimalName())) {
                                System.out.println(p.getKey() + " Владелец: " + p.getValue().getOwnerName() +", "+ " кличка: " + p.getValue().getAnimalName()+ ", возраст: " + p.getValue().getAge() + ", " + p.getValue().getAnimalSex() + ", вес: " + p.getValue().getWeight());
                        }
                    }
            }
}