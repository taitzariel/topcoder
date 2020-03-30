package org.taitz;

import java.util.Arrays;

/**
 * Created by taitz.
 */
public class LeastChanges {

    private static final int MAX = 2000;

    public int[] increasingLeastChanges(int[] a) {
        int[][] cost = calcCost(a);
        return cheapestPath(cost);
    }

    private int[][] calcCost(int[] a) {
        int[][] cost = new int[a.length + 1][MAX];
        for (int p = a.length - 1; p >= 0; p--) {
            int minCost = MAX;
            for (int h = MAX; h >= 1; h--) {
                if (cost[p + 1][h - 1] < minCost) {
                    minCost = cost[p + 1][h - 1];
                }
                cost[p][h - 1] = minCost + 1;
            }
            cost[p][a[p] - 1]--;
        }
        return cost;
    }

    private int[] cheapestPath(int[][] cost) {
        int[] path = new int[cost.length - 1];
        int height = 1;
        for (int p = 0; p < path.length; p++) {
            int minCost = cost.length;
            for (int h = height; h <= MAX; h++) {
                if (cost[p][h - 1] < minCost) {
                    height = h;
                    minCost = cost[p][h - 1];
                }
            }
            path[p] = height;
        }
        return path;
    }

}
