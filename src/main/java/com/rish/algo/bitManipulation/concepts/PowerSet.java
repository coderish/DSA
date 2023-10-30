package com.rish.algo.bitManipulation.concepts;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp;
        for (int i = 0; i < (1 << nums.length); i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((1 << j) & i) != 0) {
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        System.out.println(ans);
    }
}
