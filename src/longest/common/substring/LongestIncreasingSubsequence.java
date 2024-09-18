package longest.common.substring;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lisLength(new int[]{6, 9, 8, 2, 3, 5, 1, 4, 7}));
    }

    public static int lisLength(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, -1, nums, dp);
    }

    private static int dfs(int cur, int prev, int[] nums, int[][] dp) {
        if (cur == nums.length) return 0;

        if (prev != -1 && dp[cur][prev] != -1) return dp[cur][prev];
        // skip current item
        int len = dfs(cur+1, prev, nums, dp);

        // take current
        if (prev < 0 || nums[prev] < nums[cur]) {
            len = Math.max(len, 1 + dfs(cur+1, cur, nums, dp));
        }

        if (prev != -1) dp[cur][prev] = len;

        return len;
    }
}
