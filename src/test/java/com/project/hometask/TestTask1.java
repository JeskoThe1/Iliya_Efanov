package com.project.hometask;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask1 {

    @Test
    void testGetIntegersFromList() {
        List<Object> list1 = List.of(1, 2, 'a', 'b');
        List<Integer> expected1 = List.of(1, 2);
        List<Integer> result1 = Task1.getIntegers(list1);
        assertEquals(expected1, result1);

        List<Object> list2 = List.of(1, 2, 'a', 'b', 0, 15);
        List<Integer> expected2 = List.of(1, 2, 0, 15);
        List<Integer> result2 = Task1.getIntegers(list2);
        assertEquals(expected2, result2);

        List<Object> list3 = List.of(1, 2, 'a', 'b', "aaasf", '1', "123", 231);
        List<Integer> expected3 = List.of(1, 2, 231);
        List<Integer> result3 = Task1.getIntegers(list3);
        assertEquals(expected3, result3);
    }

}
