package knapsack;

public class SubsetSum {

    static int[] nums;
    static int totalSum;

    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{3,4, 5, 2}, 9));
    }

    public static boolean subsetSum (int [] arr, int total) {
        nums = arr;
        totalSum = total;

        return backtrack(0, 0);
    }

    private static boolean backtrack(int index, int total) {
        if (index == nums.length) return total == totalSum;

        if (total > totalSum) return false;

        return backtrack(index+1, total+nums[index]) || backtrack(index+1, total);

    }
}
