package com.project.hometask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task5 {
    public static String sortFriendList(String friendsString){
        String[] friends = friendsString.toUpperCase().split(";");

        List<String> formattedFriends = new ArrayList<>();

        for (String friend : friends) {
            String[] name = friend.split(":");
            String firstName = name[0];
            String lastName = name[1];

            formattedFriends.add("(" + lastName + ", " + firstName + ")");
        }
        Collections.sort(formattedFriends);

        return String.join("", formattedFriends);
    }

    public static void main(String[] args){
        String param2 = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;";
        System.out.println(Task5.sortFriendList(param2));
    }
}
