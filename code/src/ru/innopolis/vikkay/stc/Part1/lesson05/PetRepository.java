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
 *  @version   2.0  (19 03 2021)
 *  @author    Viktor Kochetkov
 */

public class PetRepository<P> {

      public  List<Person> getAnimalList() {                                    // Создаем коллекцию из значений мапы
           return new ArrayList<>(IdMap.values());
      }

      private Map<Integer, Person> IdMap = new HashMap<>();

      public Map<Integer, Person> getIdMap() {
                    return IdMap;
                }



           public void arrayToMap(Person person) {                          // добавляем строку если id свободен

                if (IdMap.containsKey(person.getId())) {
                    System.err.println("Вы пытаетесь добавить уже существующую строку. id = "+person.getId()+" занят!");
                }
                    else {
                        IdMap.put(person.getId(), person);
                }
           }


           public void removeToMap(int id) {                                 // удаляем строку по id

                   if(IdMap.containsKey(id)){
                        IdMap.remove(id);
                    }
                   else System.err.println("Вы пытаетесь удалить не существующую строку. Такого id нет!");
           }


           public void changeToMap(int id, Person p) {                     // заменяем строку по id

                    if(IdMap.containsKey(id)){
                        IdMap.replace(id,  p);
                    }
                    else System.err.println("Вы пытаетесь заменить не существующую строку. Такого id нет!");
            }



    public void searchToMap(String animalName) {                       // ищем строку по кличке животного
            ArrayList <Person> persons = new ArrayList<>();             // создаем лист для хранения person
            persons.addAll(getAnimalList());

            HashMap <String, ArrayList<Person>> personsMap = new HashMap<>();  // Map для хранения пар: Кличка - список Персон

                    for (int i = 0; i < persons.size(); i++) {

                            String key = persons.get(i).getAnimalName();

                            if(!personsMap.containsKey(key)){
                                personsMap.put(key, new ArrayList<Person>());
                            }
                                personsMap.get(key).add(persons.get(i));
                    }

                    if(personsMap.containsKey(animalName)) {
                        ArrayList<Person> t = personsMap.get(animalName);
                            for (Person per : t) {
                            System.out.println(per.getId() + " Владелец: " + per.getOwnerName() +", кличка: " + per.getAnimalName()+ ", возраст: " + per.getAge() + ", " + per.getAnimalSex() + ", вес: " + per.getWeight());
                            }
                    }
/*
        for (Map.Entry<Integer, Person> p : IdMap.entrySet()) {
            if (animalName.equals(p.getValue().getAnimalName())) { // убрать
                System.out.println(p.getKey() + " Владелец: " + p.getValue().getOwnerName() +", "+ " кличка: " + p.getValue().getAnimalName()+ ", возраст: " + p.getValue().getAge() + ", " + p.getValue().getAnimalSex() + ", вес: " + p.getValue().getWeight());
            }
        }
*/
    }
}