package longest.common.substring;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("dynamic", "programming"));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {

        // going to find longest common subsequence
        String[][] dp = new String[str1.length()+1][str2.length()+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = "";
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + str1.charAt(i-1);
                } else {
                    dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
                }

            }
        }
        String lcs = dp[str1.length()][str2.length()];

        int s = 0;
        int p1 = 0;
        int p2 = 0;
        StringBuilder res = new StringBuilder();
        while (s < lcs.length()) {
            while (str1.charAt(p1) != lcs.charAt(s)) {
                res.append(str1.charAt(p1));
                p1++;
            }

            while (str2.charAt(p2) != lcs.charAt(s)) {
                res.append(str2.charAt(p2));
                p2++;
            }

            res.append(lcs.charAt(s));
            p1++;
            p2++;
            s++;

        }

        return res + str1.substring(p1) + str2.substring(p2);

    }
}
