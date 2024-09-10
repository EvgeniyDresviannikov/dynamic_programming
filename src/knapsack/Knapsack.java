package knapsack;


public class Knapsack {

    public static void main(String[] args) {
        System.out.println(findKnapsack(6, new int[]{1,2,3,5}, new int[]{1,5,4,8}, 4));
    }

    public static int findKnapsack(int capacity, int[] weights, int[] values, int n){

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (j < weights[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j - weights[i-1]]);
                }

            }
        }

        return dp[n][capacity];
    }
}
