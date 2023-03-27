package com.project.hometask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Task4 {

    public static int countPairsSumIterative(int[] numbers, int target){
        if (numbers == null || numbers.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long countPairsSumStream(int[] numbers, int target){
        return IntStream.range(0, numbers.length)
                .flatMap(i -> IntStream.range(i+1, numbers.length)
                        .filter(j -> numbers[i] + numbers[j] == target))
                .count();
    }
}
