package com.rish.algo.dp.fibonacci;

import java.util.HashSet;
import java.util.Set;

public class ClimbingStairs_BacktrackingWay {
    public static void main(String[] args) {
        int totalSteps = 3;
        Set<String> answer = new HashSet<>();
        findWays(totalSteps, answer, new StringBuilder());
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }

    private static void findWays(int totalStepsLeft, Set<String> answerSet, StringBuilder answerBuilder) {
        if (totalStepsLeft == 0) {
            answerSet.add(answerBuilder.toString());
            return;
        }
        if (totalStepsLeft >= 1) {
            answerBuilder.append(1);
            findWays(totalStepsLeft - 1, answerSet, answerBuilder);
            answerBuilder.deleteCharAt(answerBuilder.toString().length() - 1);
        }
        if (totalStepsLeft >= 2) {
            answerBuilder.append(2);
            findWays(totalStepsLeft - 2, answerSet, answerBuilder);
            answerBuilder.deleteCharAt(answerBuilder.toString().length() - 1);
        }
    }
}
