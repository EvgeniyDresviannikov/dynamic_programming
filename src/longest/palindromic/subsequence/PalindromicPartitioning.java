package longest.palindromic.subsequence;

import java.util.Arrays;

public class PalindromicPartitioning {

    public static void main(String[] args) {
        System.out.println(minCuts("radar"));
    }

    public static int minCuts(String arr) {

        int[][] dp = new int[arr.length()][arr.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return backtracking(0, arr.length()-1, arr, dp);
    }

    private static int backtracking(int start, int end, String arr, int[][] dp) {
        if (start == end || isPalindrom(start, end, arr)) return 0;

        if (dp[start][end] != -1) return dp[start][end];

        int result = end - start + 1;

        for (int i = start; i < end; i++) {
            int totalCount = 1 + backtracking(start, i, arr, dp) + backtracking(i+1, end, arr, dp);
            result = Math.min(result, totalCount);
        }

        dp[start][end] = result;

        return result;
    }

    private static boolean isPalindrom(int start, int end, String arr) {
        while (start < end) {
            if (arr.charAt(start) == arr.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
