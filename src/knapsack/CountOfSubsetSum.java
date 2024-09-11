package knapsack;

import java.util.Arrays;

public class CountOfSubsetSum {

    static int[] arr;

    public static void main(String[] args) {
        System.out.println(countSubsetSum(new int[]{1, 2, 7, 4, 5}, 9));
    }

    public static long countSubsetSum(int[] nums, int integer) {

        int lookupTable[][] = new int[nums.length][integer + 1];
        for (int[] row : lookupTable)
            Arrays.fill(row, -1);

        arr = nums;

        return backtrack(0, integer, lookupTable);
    }

    private static int backtrack(int index, int currentSum, int[][] lookupTable) {
        if (currentSum == 0) return 1;

        if (index == arr.length) return 0;

        if (lookupTable[index][currentSum] != -1) {
            System.out.println("found in cache");
            return lookupTable[index][currentSum];
        }

        int sum1 = 0;
        if (currentSum >= arr[index]) {
            sum1 = backtrack(index+1, currentSum-arr[index], lookupTable);
        }
        int sum2 = backtrack(index+1, currentSum, lookupTable);

        lookupTable[index][currentSum] = sum1 + sum2;

        return lookupTable[index][currentSum];
    }
}
