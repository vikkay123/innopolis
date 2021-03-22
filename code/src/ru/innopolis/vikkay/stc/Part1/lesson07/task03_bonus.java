package ru.innopolis.vikkay.stc.Part1.lesson07;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Задание-бонус: напишите простую программу, которая читает файл в кодировке UTF-8,
 * а пишет в другой файл в кодировке UTF-16.
 * Использовать InputStreamReader/OutputStreamWriter
 *
 *  @author Viktor Kochetkov
 *  @version 1.0 (19.03.2021)
 *
 */

public class task03_bonus {

    public static void main(String[] args) throws IOException {

                     /* блок чтения из файла */

                String s;
                String stringIN = "";

                try( BufferedReader br = new BufferedReader(new InputStreamReader
                                         (new FileInputStream("c:/Temp/java/tmpIN.txt"), Charset.forName("UTF-8")))) {

                    while ((s = br.readLine()) != null) {         //чтение построчно из файла
                        stringIN += s;                            // записываем в строку текст
                    }
                }

                     /* блок записи в файл */

        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                                (new FileOutputStream("c:/Temp/java/tmpOUT.txt"), Charset.forName("UTF-16")))) {

            bw.write(stringIN);                                //запись в файл
            bw.flush();
        }
    }
}
