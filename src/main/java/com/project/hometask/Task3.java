package com.project.hometask;

public class Task3 {
    public static int digitalRoot(int number){
        int sum = 0;
        while(number > 0){
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum < 10 ? sum : digitalRoot(sum);
    }
}
