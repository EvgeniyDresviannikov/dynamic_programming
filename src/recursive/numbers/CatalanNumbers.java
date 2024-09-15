package recursive.numbers;

public class CatalanNumbers {

    public static void main(String[] args) {
        System.out.println(catalan(6));
    }

    public static long catalan (int n) {

        if (n == 0 || n == 1) return 1;

        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n+1; i++) {
            long res = 0;
            for (int j = 0; j < i; j++) {
                res += dp[j] * dp[i - j - 1];
            }
            dp[i] = res;

        }

        return dp[n];
    }
}
