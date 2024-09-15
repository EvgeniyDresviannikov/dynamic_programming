package recursive.numbers;


public class CountWaysToScoreInGame {

    public static void main(String[] args) {
        System.out.println(scoringOptions(5));
    }

    public static long scoringOptions (int n) {
        if (n == 0 || n == 1) return 1;

        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            if (i - 4 > -1) {
                dp[i] = dp[i - 1] + dp[i-2] + dp[i-4];
            } else {
                dp[i] = dp[i - 1] + dp[i-2];
            }
        }

        return dp[n];
    }


}
