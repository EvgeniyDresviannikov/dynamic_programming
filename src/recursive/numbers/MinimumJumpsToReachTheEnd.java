package recursive.numbers;

public class MinimumJumpsToReachTheEnd {

    public static void main(String[] args) {
        System.out.println(findMinJumps(new int[]{1,0}));
    }

    public static long findMinJumps(int[] nums) {

        int[] dp = new int[nums.length];

        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] == 0) {
                dp[i] = 0;
                continue;
            }
            if (i + nums[i] >= nums.length-1) {
                dp[i] = 1;
                continue;
            }

            int minJumps = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i]; j++) {
                if (dp[i + j] != 0) {
                    minJumps = Math.min(minJumps, dp[i + j]);
                }
                dp[i] = minJumps == Integer.MAX_VALUE ? 0 : 1 + minJumps;
            }
        }

        return dp[0];
    }
}
