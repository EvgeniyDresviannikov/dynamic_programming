package unbounded.knapsack;

import java.util.Arrays;

public class MaximumRibbonCut {

    public static void main(String[] args) {
        System.out.println(countRibbonPieces(13, new int[]{5,3,8}));
    }

    public static int countRibbonPieces(int n, int[] sizes)
    {
        int [] dp = new int[n+1];

        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sizes.length; j++) {
                if (i - sizes[j] >= 0 && dp[i - sizes[j]] != -1) {
                    dp[i] = Math.max(dp[i], 1 + dp[i - sizes[j]]);
                }
            }
        }

        return dp[n];

    }
}
