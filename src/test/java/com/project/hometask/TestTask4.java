package com.project.hometask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask4 {

    @Test
    void testCountPairsSumIteratively() {
        int[] arr1 = {1, 3, 6, 2, 2, 0, 4, 5};
        int target1 = 5;
        assertEquals(4, Task4.countPairsSumIterative(arr1, target1));

        int[] arr2 = {1, 3, 6, 2, 2, 0, 4, 5};
        int target2 = 2;
        assertEquals(2, Task4.countPairsSumIterative(arr2, target2));

        int[] arr3 = {1, 3, 6, 2, 2, 0, 4, 5};
        int target3 = 11;
        assertEquals(1, Task4.countPairsSumIterative(arr3, target3));
    }

    @Test
    void testCountSumPairsStream() {
        int[] arr1 = {1, 3, 6, 2, 2, 0, 4, 5};
        int target1 = 5;
        assertEquals(4, Task4.countPairsSumIterative(arr1, target1));

        int[] arr2 = {1, 3, 6, 2, 2, 0, 4, 5};
        int target2 = 2;
        assertEquals(2, Task4.countPairsSumIterative(arr2, target2));

        int[] arr3 = {1, 3, 6, 2, 2, 0, 4, 5};
        int target3 = 11;
        assertEquals(1, Task4.countPairsSumIterative(arr3, target3));
    }
}
