package knapsack;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfRefuelingStops {

    public static void main(String[] args) {
        System.out.println(minRefuelStops(15, 2, new int[][]{ {1,2}, {2,8}, {4, 10}, {6, 7}, {7, 2}, {8, 1} }));
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int distance = startFuel;
        Queue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int counter = 0;
        int i = 0;

        while (distance < target) {
            while (i < stations.length && stations[i][0] <= distance) {
                maxHeap.add(stations[i]);
                i++;
            }

            if (maxHeap.isEmpty()) return -1;

            int[] optimalStation = maxHeap.remove();
            distance += optimalStation[1];
            counter++;
        }

        return counter;

    }
}
