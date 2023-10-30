package com.rish.algo.searching.binarySearch;

/**
 * Smallest index such that arr[ind] > num
 */
public class UpperBound {
    public static void main(String[] args) {
        int[] sortedArr = {1, 3, 6, 8, 9, 11};
        int num = 3;
        System.out.println(findUpperBoundIndex(sortedArr, num, sortedArr.length));
    }

    private static int findUpperBoundIndex(int[] sortedArr, int num, int candidateIndex) {
        int low = 0, high = candidateIndex - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (sortedArr[mid] > num) {
                candidateIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return candidateIndex;
    }
}