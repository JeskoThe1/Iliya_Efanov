package com.project.hometask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask7 {
    @Test
    public void testIPAddressConversion1() {
        long ip1 = 2149583361L;
        String expected1 = "128.32.10.1";
        String actual1 = Task7.uint32ToIp(ip1);
        assertEquals(expected1, actual1);

        long ip2 = 32L;
        String expected2 = "0.0.0.32";
        String actual2 = Task7.uint32ToIp(ip2);
        assertEquals(expected2, actual2);

        long ip3 = 0L;
        String expected3 = "0.0.0.0";
        String actual3 = Task7.uint32ToIp(ip3);
        assertEquals(expected3, actual3);
    }
}
