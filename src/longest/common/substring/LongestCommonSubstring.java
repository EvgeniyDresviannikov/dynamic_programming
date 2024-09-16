package longest.common.substring;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println(lcsLength("educativeexp", "educativeedp"));
    }

    public static int lcsLength (String input1, String input2) {

        int[][] dp = new int[input1.length()][input2.length()];
        int res = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (input1.charAt(i) == input2.charAt(j)) {
                    if (i-1 > -1 && j-1 > -1) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;

    }


}
