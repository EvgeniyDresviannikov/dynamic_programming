package longest.common.substring;

import java.util.Arrays;

public class DistinctSubsequence {

    public static void main(String[] args) {
        System.out.println(numberOfSubsequences("rabbbit", "rabbit"));
    }

    public static long numberOfSubsequences(String s, String t) {

        long[][] dp = new long[s.length()][t.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1L);
        }

        return dfs(0, 0, s, t, dp);
    }

    private static long dfs(int i, int j, String str1, String str2, long[][] dp) {
        if (j == str2.length()) return 1;

        if (i == str1.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        long count = 0;
        if (str1.charAt(i) == str2.charAt(j)) {
            count = dfs(i+1, j+1, str1, str2, dp) + dfs(i+1, j, str1, str2, dp);
        } else {
            count = dfs(i+1, j, str1, str2, dp);
        }

        dp[i][j] = count;

        return count;

    }
}
