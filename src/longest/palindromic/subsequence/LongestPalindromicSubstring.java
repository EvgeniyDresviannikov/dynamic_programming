package longest.palindromic.subsequence;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(findLpsLength("dadxracecarpmadam"));
    }

    public static int findLpsLength(String s){
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, s.length()-1, s, dp);
    }

    private static int dfs(int left, int right, String origin, int[][] dp) {
        if (left == right) return 1;

        if (dp[left][right] != -1) return dp[left][right];

        if (origin.charAt(left) == origin.charAt(right)) {

            int len = right - left + 1;
            if (len == 2) return 2;

            if (len == 2 + dfs(left+1, right-1, origin, dp)) {
                dp[left][right] = len;
                return len;
            }
        }

        dp[left][right] = Math.max(dfs(left+1, right, origin, dp), dfs(left, right-1, origin, dp));
        return dp[left][right];

    }


}
