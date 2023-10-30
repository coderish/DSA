package com.rish.algo.searching;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] sortedArr = {1, 2, 4, 6, 8, 9};
        System.out.println(binarySearchIndexRecursive(sortedArr, 6));
    }

    private static int binarySearchIndexRecursive(int[] sortedArr, int num) {
        return recursiveSearch(sortedArr, 0, sortedArr.length - 1, num);
    }

    private static int recursiveSearch(int[] sortedArr, int low, int high, int num) {
        if (low > high) return -1;
        int mid = high - (high - low) / 2;
        if (sortedArr[mid] == num) return mid;
        else if (num > sortedArr[mid]) return recursiveSearch(sortedArr, mid + 1, high, num);
        else return recursiveSearch(sortedArr, low, mid - 1, num);
    }

}
