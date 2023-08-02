package com.rish.algo.tailRecursion;

import java.util.function.BiFunction;

public class PowerFunction {
    public static void main(String[] args) {

        BiFunction<Double, Integer, Double> recursivePowerFunction = PowerFunction::powerOf;
//        BiFunction<Double, Integer, Double> binomialExponentialPowerFunction = PowerFunction::powerOf;
//        BiFunction<Double, Integer, Double> tailRecursionPowerFunction = PowerFunction::powerOf;

        System.out.println(calculatePower(2, 2, recursivePowerFunction));
        System.out.println(calculatePower(2, 8, 1));
    }

    private static double calculatePower(double m, int n, BiFunction<Double, Integer, Double> powerFunction) {
        if (n < 0) {
            m = 1 / m;
            n = -1 * n;
        }
        return powerFunction.apply(m, n);
    }

    private static double calculatePower(double m, int n, double value) {
        if (n < 0) {
            m = 1 / m;
            n = -1 * n;
        }
        return powerOf(m, n, value);
    }

    // Recursion - Divide&Conquer
    private static double powerOf(double m, int n) {
        if (m == 0) return 0;
        if (n == 0) return 1;
        double ans = powerOf(m, n / 2);
        if (n % 2 == 0) {
            return ans * ans;
        } else {
            return ans * ans * m;
        }
    }

    private static double powerOf(double number, int power, double value) {
        if (number == 0) return 0;
        if (power == 0) return value;
        if (power == 1) return value * number;
        if (power % 2 == 0) {
            return powerOf(number * number, power / 2, value);
        } else {
            return powerOf(number * number, power / 2, number * value);
        }
    }
}