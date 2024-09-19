package longest.common.substring;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(msisLength(new int[]{5,5,5,5,5,5}));
    }

    public static int msisLength(int [] nums) {

        int[] dp = new int[nums.length];
        dp[dp.length-1] = nums[dp.length-1];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }

        for (int i = dp.length-1; i > -1; i--) {
            for (int j = i+1; j < dp.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
