package unbounded.knapsack;

public class RodCutting {


    public static void main(String[] args) {
        System.out.println(rodCutting(new int[]{1,2,3}, new int[]{3,7,8}, 3));
    }

    public static int rodCutting(int[] lengths, int[] prices, int n) {

        int[][] dp = new int[lengths.length][n+1];

        for (int i = 1; i < n+1; i++) {
            if (i % lengths[0] == 0) {
                dp[0][i] = (i / lengths[0]) * prices[0];
            }
        }

        for (int i = 1; i < lengths.length; i++) {
            for (int j = 1; j < n+1; j++) {
                if (j >= lengths[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], prices[i] + dp[i][j - lengths[i]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[lengths.length-1][n];
    }

}
