package recursive.numbers;

import java.util.Arrays;

public class NumberFactors {

    static long[] dp;

    public static void main(String[] args) {
        System.out.println(countWays(5));
    }

    public static long countWays (int n) {
        dp = new long[n+1];
        Arrays.fill(dp, -1L);
        return backtrack(n);
    }

    private static long backtrack(int rest) {
        if (rest == 0) return 1;
        if (rest < 0) return 0;
        if (dp[rest] != -1L) {
            return dp[rest];
        }

        dp[rest] = backtrack(rest - 1) + backtrack(rest - 3) + backtrack(rest - 4);

        return dp[rest];
    }
}
