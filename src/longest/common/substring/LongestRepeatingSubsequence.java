package longest.common.substring;

public class LongestRepeatingSubsequence {

    public static void main(String[] args) {
        System.out.println(findLRS("abbaba"));
    }

    static int findLRS(String str) {
        int[][] dp = new int[str.length()+1][str.length()+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str.charAt(i-1) == str.charAt(j-1) && i != j) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[str.length()][str.length()];
    }
}
