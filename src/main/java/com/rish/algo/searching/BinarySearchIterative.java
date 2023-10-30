package com.rish.algo.searching;

public class BinarySearchIterative {
    public static void main(String[] args) {
        int[] sortedArr = {1, 4, 5, 6, 9, 10, 11};
        System.out.println(binarySearchIndex(sortedArr, 2));
    }

    private static int binarySearchIndex(int[] arr, int num) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (arr[mid] == num)
                return mid;
            else if (num > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


}
