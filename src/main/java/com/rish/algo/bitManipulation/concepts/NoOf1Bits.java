package com.rish.algo.bitManipulation.concepts;

public class NoOf1Bits {
    public static void main(String[] args) {
        int num = 69;
        System.out.println(num);
        /*Stack<String> stack = new Stack<>();
        while (num != 0) {
            stack.add((num & 1) + "");
            num = num >> 1;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }*/

        int count1Bits = 0;
        while (num != 0) {
            if ((num & (num - 1)) != 0) {
                count1Bits++;
            }
            num = num >> 1;
        }
        System.out.println(count1Bits);
    }
}
