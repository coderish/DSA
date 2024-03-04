package com.rish.algo.searching.binarySearch;

public class FirstAndLastOccurrences {
    public static void main(String[] args) {
        int[] sortedArr = {1, 3, 4, 6, 6, 6, 8};
//        int[] sortedArr = {1, 3, 4, 6, 8, 8};
        int num = 8;
        int[] occurrenceIndices = findOccurrences(sortedArr, num);
        System.out.println(occurrenceIndices[0] + ", " + occurrenceIndices[1]);
    }

    private static int[] findOccurrences(int[] sortedArr, int num) {
        int[] ans = new int[]{-1, -1};
        int lowerBound = findLowerBound(sortedArr, num);
        int upperBound = findUpperBound(sortedArr, num);
//        if (sortedArr[lowerBound] == num) {
        System.out.println(lowerBound);
        System.out.println(upperBound);
        if (lowerBound != upperBound) {
            ans[0] = lowerBound;
            ans[1] = upperBound - 1;
        }
        return ans;
    }

    /**
     * min index where, arr[i] >= num
     */
    private static int findLowerBound(int[] sortedArr, int num) {
        int low = 0, candidateIndes = sortedArr.length, high = candidateIndes - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (sortedArr[mid] >= num) {
                candidateIndes = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return candidateIndes;
    }

    /**
     * min index where, arr[i] > num
     */
    private static int findUpperBound(int[] sortedArr, int num) {
        int low = 0, candidateIndex = sortedArr.length, high = candidateIndex - 1;
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
