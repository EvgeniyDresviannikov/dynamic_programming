package knapsack;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    Map<Map.Entry<Integer, Integer>, Integer> dp = new HashMap<>();
    int[] numArr;
    int targetSum;

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        numArr = nums;
        targetSum = target;

        return backtrack(0, 0);
    }

    private int backtrack(int index, int total) {
        if (index == numArr.length) {
            return total == targetSum ? 1 : 0;
        }

        if (dp.containsKey(Map.entry(index ,total))) {
            return dp.get(Map.entry(index ,total));
        }

        dp.put(Map.entry(index ,total),
                backtrack(index + 1, total + numArr[index]) +
                        backtrack(index + 1, total - numArr[index]));

        return dp.get(Map.entry(index ,total));
    }
}
