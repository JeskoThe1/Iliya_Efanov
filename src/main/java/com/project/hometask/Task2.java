package com.project.hometask;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task2 {
    public static Character firstNonRepeatingLetter(String string) {
        if(string == null)
            return ' ';

        String lowerCaseString = string.toLowerCase();
        Map<Character, Integer> charCounts = new LinkedHashMap<>();

        for (int i = 0; i < lowerCaseString.length(); i++) {
            char c = lowerCaseString.charAt(i);
            int count = charCounts.containsKey(c) ? charCounts.get(c) : 0;
            charCounts.put(c, count + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (charCounts.get(lowerCaseString.charAt(i)) == 1) {
                return c;
            }
        }

        return ' ';
    }
}
