package Arrays;

/**
 * Author: Stephen Sheldon 3/28/2019
 *
 * Problem: Write an efficient program to find contiguous subarray with the
 *          largest sum within an array.
 */

public class LargestSubarray {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("The Max contiguous sum subarray is " + maxSumSubarray(arr));
    }

    private static int maxSumSubarray(int[] arr) {
        // Store our current max
        int current_max = Integer.MIN_VALUE;
        // Store our potential current max
        int end_max = 0;

        // Loop through the entire array
        for (int i = 0; i < arr.length; i++) {
            end_max += arr[i];
            if (end_max > current_max)
                current_max = end_max;
            if (end_max < 0)
                end_max = 0;
        }
        return current_max;
    }
}
