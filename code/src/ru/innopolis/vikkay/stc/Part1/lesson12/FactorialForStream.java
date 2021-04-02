package ru.innopolis.vikkay.stc.Part1.lesson12;

import java.math.BigInteger;
import java.util.concurrent.Callable;

/**
 * Класс FactorialForStream
 * <p>
 * вычисляет факториал числа
 *
 * @author Viktor Kochetkov
 * @version 1.0 (23.03.2021)
 */

public class FactorialForStream implements Callable<BigInteger> {

    private BigInteger result = BigInteger.ONE;

    public BigInteger getResult() {
        return result;
    }

    private int number;

    public BigInteger getFactorial(int number) {
        this.number = number;
        return getResult();
    }

    @Override
    public BigInteger call() {

        for (int i = 0; i < number; i++) {

            if (number <= 1) {                                             // проверка на 0 и 1
                return BigInteger.ONE;
            } else for (int k = 2; k <= number; k++) {
                result = getResult().multiply(BigInteger.valueOf(k));      // вычисляем факториал числа
            }

            return result;
        }
        return result;
    }
}