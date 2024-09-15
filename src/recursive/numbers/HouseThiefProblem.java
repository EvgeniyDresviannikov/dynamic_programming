package recursive.numbers;

public class HouseThiefProblem {

    public static void main(String[] args) {
        System.out.println(houseThief(new int[]{1,2,3,4,5}));
    }

    public static int houseThief(int[] money) {

        if (money.length == 1) return money[0];
        if (money.length == 2) return Math.max(money[0], money[1]);

        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(money[i] + dp[i-2], dp[i-1]);
        }

        return dp[money.length-1];
    }
}
