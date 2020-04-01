package com.metacube.Question03;

import static org.junit.Assert.*;
import org.junit.Test;

public class CricketTest {
    @Test
    public void testfindOrderOfBowlers() throws Exception {

        assertArrayEquals(new int[] {1, 1, 2, 1, 2},
                Cricket.findOrderOfBowlers(5, 2, new int[] {3, 2}));
        assertArrayEquals(new int[] {2, 2, 1, 2, 3},
                Cricket.findOrderOfBowlers(5, 3, new int[] {1, 3, 1}));
        assertArrayEquals(new int[] {2, 2, 1, 2, 1, 2, 3},
                Cricket.findOrderOfBowlers(7, 3, new int[] {2, 4, 1}));
        assertArrayEquals(new int[] {1, 3, 1, 2, 3, 1, 2, 3, 4},
                Cricket.findOrderOfBowlers(9, 4, new int[] {3, 2, 3, 1}));
        assertArrayEquals(new int[] {2, 2, 3, 7, 1, 2, 3, 4, 5, 6, 7},
                Cricket.findOrderOfBowlers(11, 7, new int[] {1, 3, 2, 1, 1, 1, 2}));
        assertArrayEquals(new int[] {2, 1, 2, 1, 2},
                Cricket.findOrderOfBowlers(5, 2, new int[] {2, 3}));
        assertArrayEquals(new int[] {1, 1, 3, 1, 3, 1, 2, 3},
                Cricket.findOrderOfBowlers(8, 3, new int[] {4, 1, 3}));


    }


    @Test(expected = Exception.class)
    public void testfindOrderOfBowlersNegative() throws Exception {
        assertArrayEquals(new int[] {2, 3, 4, 1},
                Cricket.findOrderOfBowlers(13, 4, new int[] {1, 6, 3}));
        assertArrayEquals(new int[] {2, 1, 3},
                Cricket.findOrderOfBowlers(5, 2, new int[] {1, 3, 1}));
        assertArrayEquals(new int[] {2, 1, 3},
                Cricket.findOrderOfBowlers(50, 3, new int[] {2, 4, 1}));
        assertArrayEquals(new int[] {1, 3, 2, 4},
                Cricket.findOrderOfBowlers(90, 4, new int[] {2, 3, 1}));
        assertArrayEquals(new int[] {2, 3, 7, 1, 4, 5, 6},
                Cricket.findOrderOfBowlers(10, 7, new int[] {1, 3, 2, 1, 1, 1, 2}));
        assertArrayEquals(new int[] {2, 1}, Cricket.findOrderOfBowlers(5, 2, new int[] {}));
        assertArrayEquals(new int[] {4, 2, 3, 1},
                Cricket.findOrderOfBowlers(2, 4, new int[] {1, 8, 5, 9}));
        assertArrayEquals(new int[] {1, 4, 2, 3},
                Cricket.findOrderOfBowlers(21, 8, new int[] {10, 3, 2, 6}));

    }
}
