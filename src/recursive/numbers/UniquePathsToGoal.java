package recursive.numbers;

import java.util.Arrays;

public class UniquePathsToGoal {

    public static void main(String[] args) {
        System.out.println(findUniquePath(new int[][]{
                {1}
        }));
    }

    public static int findUniquePath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0,0, matrix, dp);
    }

    private static int dfs(int i, int j, int[][] matrix, int[][] dp) {
        if (i == matrix.length - 1 && j == matrix[0].length-1 && matrix[i][j] == 0) return 1;
        if (i > matrix.length - 1 || i > matrix[0].length-1) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int res1 = 0;
        if (i+1 < matrix.length && matrix[i+1][j] == 0) {
            res1 = dfs(i+1, j, matrix, dp);
        }

        int res2 = 0;
        if (j+1 < matrix[0].length && matrix[i][j+1] == 0) {
            res2 = dfs(i, j+1, matrix, dp);
        }

        dp[i][j] = res1 + res2;

        return dp[i][j];

    }
}
