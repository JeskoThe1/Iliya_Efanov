package com.project.hometask;

import java.util.Arrays;

public class Task6 {
    public static int getNextBiggerNumber(int number) {

        String numberString = Integer.toString(number);

        char[] digits = numberString.toCharArray();

        int pivotIndex = -1;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < digits[i+1]) {
                pivotIndex = i;
                break;
            }
        }

        if (pivotIndex == -1) {
            return -1;
        }

        int smallestGreaterIndex = pivotIndex + 1;
        for (int i = pivotIndex + 2; i < digits.length; i++) {
            if (digits[i] > digits[pivotIndex] && digits[i] < digits[smallestGreaterIndex]) {
                smallestGreaterIndex = i;
            }
        }

        char temp = digits[pivotIndex];
        digits[pivotIndex] = digits[smallestGreaterIndex];
        digits[smallestGreaterIndex] = temp;

        Arrays.sort(digits, pivotIndex + 1, digits.length);

        int nextBiggerNumber = Integer.parseInt(new String(digits));
        return (nextBiggerNumber > number) ? nextBiggerNumber : -1;
    }
}
