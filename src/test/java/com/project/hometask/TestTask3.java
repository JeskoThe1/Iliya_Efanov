package com.project.hometask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask3 {

    @Test
    void testDigitalRoot(){
        assertEquals(6, Task3.digitalRoot(132189));
        assertEquals(7, Task3.digitalRoot(16));
        assertEquals(6, Task3.digitalRoot(942));
        assertEquals(2, Task3.digitalRoot(493193));
    }
}
