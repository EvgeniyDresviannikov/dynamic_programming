package unbounded.knapsack;


import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2,3,4,6,8}, 23));
    }

    public static int coinChange(int [] coins, int amount) {

        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }


}
