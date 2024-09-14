package unbounded.knapsack;

import java.util.HashMap;
import java.util.Map;

public class CoinChange2 {

    static int total;
    static Map<Map.Entry<Integer, Integer>, Integer> dp = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(countWays(new int[]{10,20}, 30));
    }

    public static long countWays(int[] coins, int amount) {

        total = amount;

        return backtrack(coins, 0, 0);

    }

    private static int backtrack(int[] coins, int index, int currentSum) {
        if (currentSum == total) return 1;
        if (index == coins.length) return 0;
        if (currentSum > total) return 0;
        if (dp.containsKey(Map.entry(index, currentSum))) return dp.get(Map.entry(index, currentSum));

        dp.put(Map.entry(index, currentSum), backtrack(coins, index, currentSum + coins[index]) +
                                             backtrack(coins, index + 1, currentSum));
        return dp.get(Map.entry(index, currentSum));
    }
}
