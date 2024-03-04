package com.rish.algo.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] unsortedArray = {8, 5, 10, 2, 4};
        Arrays.stream(sort(unsortedArray)).forEach(num -> System.out.print(num + " "));
    }

    private static int[] sort(int[] arr) {
        int indexOfLowestValue = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfLowestValue]) {
                    indexOfLowestValue = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[indexOfLowestValue];
            arr[indexOfLowestValue] = temp;
            indexOfLowestValue = i + 1;
        }
        return arr;
    }
}
