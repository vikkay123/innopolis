package ru.innopolis.vikkay.stc.Part1.lesson07.task02;

import ru.innopolis.vikkay.stc.Part1.lesson07.task02.Generate.ArrayWord;
import ru.innopolis.vikkay.stc.Part1.lesson07.task02.Generate.GenerateRandomWord;
import ru.innopolis.vikkay.stc.Part1.lesson07.task02.Generate.UpperCash;

import java.io.*;
import java.nio.file.Files;
import java.util.Random;

/**
 * класс GetFiles
 *
 *      метод getFiles(String path, int n, int size, String[] words, int probability),
 *            создает n файлов размером size в каталоге path.
 *            words - массив слов, probability - вероятность.
 *
 *      метод randomMark() - генерирует случайное число от 0 до 2. Для выбора одного из трех символов ('.' || '!' || '?')
 *      метод generateSentence() - генерирует случайное число от 1 до 20. Для задания размера абзаца
 *
 *
 * @version   1.0  (21.03.2021)
 * @author    Viktor Kochetkov
 *
 */

public class GetFiles {

    private String path;
    private int n;
    private int size;
    private int probability;

    private char [] mark = {'.','!','?'};

    private int randomMark() {
        int random = new Random().nextInt(3);
        return random;
    }

    private int generateSentence() {
        int random = new Random().nextInt(20)+1;
        return random;
    }

    public void getFiles(String path, int n, int size, ArrayWord words, int probability){
        this.path = path;
        this.n = n;
        this.size = size;
        this.probability = probability;

        /* блок записи в файл */

        String prefix = "file_";        // имя файла
        String ext = ".txt";            // расширение записываемого файла
        int j = 1;                      // счетчик для имени файла

        for (int i = 0; i < n; i++) {   // задаем количество записываемых файлов

           File fileName = new File(path + prefix + j++ + ext); // путь и имя записываемого файла

            try (BufferedWriter bw = Files.newBufferedWriter(fileName.toPath())) {

                while (fileName.length() <= size) {                  // контрольруем размер записываемого файла

                        StringBuilder sb = new StringBuilder();

                    for (int k = 1; k <= generateSentence(); k++) {  // контрольруем размер абзаца

                                int randomProbability = new Random().nextInt(probability);

                                 // генерируем случайное предложение со словами из массива
                                if (randomProbability <= 0) {

                                sb.append(new GenerateRandomWord().generateRanWord() + " " + words.getArrayWord()[new Random().nextInt(words.getArrayWord().length)]);
                                sb.append(mark[randomMark()]);

                              }
                                else{
                                    // генерируем случайное предложение без слов из массива
                                    sb.append(new GenerateRandomWord().generateRanWord());
                                    sb.replace(sb.length()-1, sb.length(), "");
                                    sb.append(mark[randomMark()]);
                                }
                    }

                    bw.write(new UpperCash().upperCashString(sb + "\n\r")); // записываем сгенерированный текст в файл
            }
                    bw.flush();  // закрываем поток

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
