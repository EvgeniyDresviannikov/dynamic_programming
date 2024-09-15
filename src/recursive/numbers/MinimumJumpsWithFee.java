package recursive.numbers;

import java.util.Arrays;

public class MinimumJumpsWithFee {

    public static void main(String[] args) {
        System.out.println(minFee(new int[]{5,4,3}, 3));
    }

    public static int minFee(int[] fee, int n) {
        if (n == 0) return 0;
        if (n < 4) return Arrays.stream(fee).min().getAsInt();

        int[] dp = new int[n];

        for (int i = n-1; i > n - 4; i--) {
            dp[i] = fee[i];
        }

        for (int i = n - 4; i > -1; i--) {
            int currentFee = fee[i];
            int minFee = Integer.MAX_VALUE;
            for (int j = 1; j < 4; j++) {
                minFee = Math.min(minFee, currentFee + dp[i + j]);
            }
            dp[i] = minFee;
        }

        return dp[0];
    }
}
