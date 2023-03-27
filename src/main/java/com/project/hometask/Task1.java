package com.project.hometask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static List<Integer> getIntegers(List<?> list){
        List<Integer> listIntegers = new ArrayList<Integer>();
        if(list == null)
            return Collections.emptyList();
        else{
            for(Object elem : list){
                if(elem instanceof Number)
                    listIntegers.add((Integer) elem);
            }
        }
        return listIntegers;
    }
}
