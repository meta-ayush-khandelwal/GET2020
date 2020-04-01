package com.metacube.Question03;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cricket {

    /**
     * @param numberOfBalls which Virat going to play
     * @param numberOfBowlers
     * @param ballsForEachBowler[]
     * 
     * @return arrangedOrderOfBowlers[] order of bowlers for each balls which virat going to play
     *         i.e. which ball will throw by which bowler
     * */
    public static int[] findOrderOfBowlers(int numberOfBalls, int numberOfBowlers,
            int ballsForEachBowler[]) throws Exception {

        int arrangedOrderOfBowlers[] = new int[numberOfBalls];

        if (numberOfBowlers != ballsForEachBowler.length) {
            throw new Exception("Bowls allocation per bowler is incorrect");
        }

        int sum = 0;
        for (int bowls : ballsForEachBowler) {
            sum += bowls;
        }

        if (sum < numberOfBalls) {
            throw new Exception(
                    "Number of Balls and sum of all allocated balls to bowler are not equal");
        }

        // Key is BowlerNumber Value balls associated with that bowler
        HashMap<Integer, Integer> bowlerData = new HashMap<Integer, Integer>();
        int key = 0;
        for (int i = 0; i < numberOfBowlers; i++) {
            bowlerData.put(++key, ballsForEachBowler[i]);
        }

        int i = 0;

        while (numberOfBalls != 0) {
            int maxBalls = Collections.max(bowlerData.values());
            for (Map.Entry<Integer, Integer> entry : bowlerData.entrySet()) {
                if (entry.getValue() == maxBalls) {
                    int bowlerNumber = entry.getKey();
                    arrangedOrderOfBowlers[i++] = bowlerNumber;
                    bowlerData.put(bowlerNumber, --maxBalls);
                    numberOfBalls--;
                    break;
                }
            }

        }
        return arrangedOrderOfBowlers;
    }

    public static void main(String args[]) {
        try {
            int[] order = Cricket.findOrderOfBowlers(12, 3, new int[] {4, 4, 4});
            for (int a : order) {
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
