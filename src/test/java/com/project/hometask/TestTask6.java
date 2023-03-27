package com.project.hometask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask6 {
    @Test
    public void testGetNextBiggerNumber() {
        // Test cases where the next bigger number can be formed
        assertEquals(21, Task6.getNextBiggerNumber(12));
        assertEquals(531, Task6.getNextBiggerNumber(513));
        assertEquals(2071, Task6.getNextBiggerNumber(2017));
        assertEquals(5314, Task6.getNextBiggerNumber(5143));
        assertEquals(13759, Task6.getNextBiggerNumber(13597));
        assertEquals(192837465, Task6.getNextBiggerNumber(192837456));
        assertEquals(-1, Task6.getNextBiggerNumber(987654321));
        assertEquals(-1, Task6.getNextBiggerNumber(5));
    }
}
