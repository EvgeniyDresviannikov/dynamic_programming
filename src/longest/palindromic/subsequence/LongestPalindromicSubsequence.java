package longest.palindromic.subsequence;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubsequence("cddpd"));
    }

    public static int longestPalindromicSubsequence(String s) {

        int[][] dp = new int[s.length()+1][s.length()+1];

        Arrays.fill(dp[0], 0);

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        String reversed = new StringBuilder(s).reverse().toString();

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i-1) == reversed.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s.length()][s.length()];

    }


}
