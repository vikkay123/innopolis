package ru.innopolis.vikkay.stc.Part1.lesson07.task02.Generate;

/**
 * Делаем первую букву заглавной
 *
 *
 *
 *  @version   1.0  (21.03.2021)
 *  @author    Viktor Kochetkov
 *
 */


public class UpperCash {

    public static String upperCashString(String string) {

        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;

        for (int i = 0; i < chars.length; i++) {

            if (!found && Character.isLetter(chars[i])) {

                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            }
            else if ( chars[i]=='.' || chars[i]=='?'|| chars[i]=='!') {
                found = false;
            }
        }
        return String.valueOf(chars);
    }
}
