package longest.common.substring;

import java.util.Arrays;

public class InterleavingStrings {

    static String str1;
    static String str2;
    static String str3;

    public static void main(String[] args) {
        System.out.println(isInterleaving("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterleaving(String s1, String s2, String s3) {
        str1 = s1;
        str2 = s2;
        str3 = s3;

        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(0,0,0, dp);

    }

    private static boolean dfs(int i, int j, int k, int[][][] dp) {
        if (i == str1.length() && j == str2.length() && k == str3.length()) return true;

        if (i == str1.length() && j == str2.length()) return false;
        if (k == str3.length()) return false;

        if (dp[i][j][k] == 0) return false;

        if (i < str1.length() && str1.charAt(i) == str3.charAt(k)) {
            if (dfs(i+1, j, k+1, dp)) return true;
        }

        if (j < str2.length() && str2.charAt(j) == str3.charAt(k)) {
            if (dfs(i, j+1, k+1, dp)) return true;
        }

        dp[i][j][k] = 0;

        return false;
    }
}
