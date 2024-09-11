package knapsack;

import java.util.Arrays;

public class PartitionArrayInto2ArraysToMinimizeSumDiff {

    static int minimumDiff = Integer.MAX_VALUE;
    static int totalSum;

    public static void main(String[] args) {
        System.out.println(minimumPartitionArraySumDifference(new int[]{5, 4, 4, 7, 2, 9 }));
    }

    public static int minimumPartitionArraySumDifference(int[] arr) {
        totalSum = Arrays.stream(arr).sum();
        int[][] dp = new int[arr.length][totalSum];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        backtrack(0, 0, arr, dp);

        return minimumDiff;
    }

    private static void backtrack(int index, int currentSum, int[] arr, int[][] dp) {
        if (index == arr.length) return;

        if (dp[index][currentSum] != -1) {
            minimumDiff = Math.min(minimumDiff, dp[index][currentSum]);
            return;
        }

        dp[index][currentSum] = Math.abs(currentSum - (totalSum - currentSum));

        minimumDiff = Math.min(minimumDiff, Math.abs(currentSum - (totalSum - currentSum)));

        backtrack(index+1, currentSum+arr[index], arr, dp);
        backtrack(index+1, currentSum, arr, dp);
    }
}
