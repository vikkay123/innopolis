package ru.innopolis.vikkay.stc.Part1.lesson07.task02.Generate;

import java.util.Random;

/**
 *
 *  Класс GenerateWord
 *
 *         метод generateRandomWord() - генерирует случайное слово
 *
 *
 *  @version   1.0  (21.03.2021)
 *  @author    Viktor Kochetkov
 *
 */

public class GenerateWord {

      private char [] smallSymbol = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','v','x','y','z'};

      private int randomSymbol() {                                  // случайный выбор символа
            int random = new Random().nextInt(23);
            return random;
        }

        public  StringBuilder generateRandomWord() {                 // генерируем случайное слово
            StringBuilder sb = new StringBuilder(randomSymbol());
            for (int i = 0; i <= randomSymbol(); i++) {
                sb.append(smallSymbol[randomSymbol()]);
            }
            return sb;
        }



}