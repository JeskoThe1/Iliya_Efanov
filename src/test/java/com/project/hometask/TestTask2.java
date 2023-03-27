package com.project.hometask;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {

    @Test
    void testFirstNonRepeatingLetter(){
        assertEquals('t', Task2.firstNonRepeatingLetter("stress"));
        assertEquals('T', Task2.firstNonRepeatingLetter("sTreSS"));
        assertEquals(' ', Task2.firstNonRepeatingLetter("   "));
        assertEquals(' ', Task2.firstNonRepeatingLetter(""));
        assertEquals(' ', Task2.firstNonRepeatingLetter("aabbccddeeff"));
        assertEquals('h', Task2.firstNonRepeatingLetter("humiliation"));
    }
}
