package unbounded.knapsack;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        System.out.println(unboundedKnapsack(new int[]{1,2,3,5}, new int[]{1,5,4,8}, 4,6));
    }

    public static int unboundedKnapsack(int[] weights, int[] values, int n, int capacity){
        int[][] dp = new int[n][capacity+1];

        for (int i = 1; i < capacity+1; i++) {
            if (i < weights[0]) continue;

            dp[0][i] = values[0] * (i / weights[0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < capacity+1; j++) {
                if (j >= weights[i]) {
                    dp[i][j] = Math.max(values[i] + dp[i-1][j - weights[i]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][capacity];
    }
}
