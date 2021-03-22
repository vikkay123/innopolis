package ru.innopolis.vikkay.stc.Part1.lesson07.task02.Generate;

import java.util.Random;

/**
 *
 * Класс GenerateRandomWord
 *
 *       метод generateRanWord() - генерирует предложение
 *
 *  @version   1.0  (21.03.2021)
 *  @author    Viktor Kochetkov
 *
 */

public class GenerateRandomWord {

     private int generateWord() {                      // генерируем случайное число от 1 до 15. Для контроля длины предложения
        int random = new Random().nextInt(15)+1;
        return random;
    }

    public StringBuilder generateRanWord() {           // генерируем случайное предложение

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= generateWord(); i++) {

                int rng = new Random().nextInt(10)+1;

                if (rng == 3 || rng == 7 || rng == 9) {
                    sb.append(" "+ new GenerateWord().generateRandomWord()+",");

                } else {
                    sb.append(" "+ new GenerateWord().generateRandomWord());

                }
        }
        return sb;
    }

}
