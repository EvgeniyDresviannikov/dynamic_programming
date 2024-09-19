package longest.common.substring;

import java.util.Arrays;

public class LongestBitonicSubsequence {

    public static void main(String[] args) {
        System.out.println(lbsLength(new int[]{6, 5, 3, 7, 10, 1, 2}));
    }

    public static int lbsLength(int[] arr) {

        int[] dpIncreasing = new int[arr.length];
        int[] dpDecreasing = new int[arr.length];

        Arrays.fill(dpIncreasing, 1);
        Arrays.fill(dpDecreasing, 1);

        // filling dpIncreasing
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i-1; j > -1; j--) {
                if (arr[i] > arr[j]) {
                    dpIncreasing[i] = Math.max(dpIncreasing[i], 1 + dpIncreasing[j]);
                }
            }
        }


        // filling dpDecreasing
        for (int i = arr.length-1; i > -1 ; i--) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    dpDecreasing[i] = Math.max(dpDecreasing[i], 1 + dpDecreasing[j]);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < dpDecreasing.length; i++) {
            res = Math.max(res, dpIncreasing[i] + dpDecreasing[i] - 1);
        }

        return res;
    }
}
