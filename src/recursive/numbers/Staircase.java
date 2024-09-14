package recursive.numbers;

public class Staircase {

    public static void main(String[] args) {
        System.out.println(countWays(3));
    }

    public static long countWays(int n) {
        if (n <= 2) return n == 0 ? 1 : n;

        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }
}
