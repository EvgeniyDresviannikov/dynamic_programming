package longest.common.substring;


public class LongestAlternatingSubsequence {

    public static void main(String[] args) {
        System.out.println(LAS(new int[]{4, 1, 5, 6, 3, 2, 1}));
    }

    public static Integer LAS(int[] nums) {

        int[][][] dp = new int[nums.length][nums.length][2];

        return 1 + Math.max(dfs(0, 1, true, nums, dp),
                            dfs(0, 1, false, nums, dp)
                    );
    }

    private static int dfs(int prev, int current, boolean isAsc, int[] nums, int[][][] dp) {

        if (current == nums.length) return 0;

        if (dp[prev][current][isAsc ? 1 : 0] != 0) {
            return dp[prev][current][isAsc ? 1 : 0];
        }

        int count = 0;
        if (isAsc && nums[current] > nums[prev] || !isAsc && nums[current] < nums[prev]) {
            count = 1 + dfs(current, current + 1, !isAsc, nums, dp);
        }

        int count2 = dfs(prev, current+1, isAsc, nums, dp);

        dp[prev][current][isAsc ? 1 : 0] = Math.max(count, count2);

        return dp[prev][current][isAsc ? 1 : 0];

    }
}
