package recursive.numbers;

public class Fib {

    public static void main(String[] args) {
        System.out.println(getFibonacci(5));
    }

    static long getFibonacci(int n) {
        if (n == 0) return 0;
        if(n == 1) return 1;
        long[] dp = new long[n+1];
        dp[0] = 0L;
        dp[1] = 1L;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }
}
