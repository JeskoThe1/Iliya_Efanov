package com.project.hometask;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestTask5 {

    @Test
    void testSortFriendList(){
        String expected1 = "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)";
        String param1 = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        assertEquals(expected1, Task5.sortFriendList(param1));

        String expected2 = "(CORWILL, FRED)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)";
        String param2 = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;";
        assertEquals(expected2, Task5.sortFriendList(param2));
    }
}
