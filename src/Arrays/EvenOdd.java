package Arrays;

import java.util.Arrays;

/**
 * Author: Stephen Sheldon 4/30/2019
 *
 * Problem: Given an  array of unsorted positive integers, reorder it's
 *          entries so that the even entries appear first.
 */

public class EvenOdd {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 3, 4, 6, 9, 10, 32, 11, 12};

        System.out.printf("Before being sorted by odd/even.. ");
        System.out.println(Arrays.toString(nums));
        System.out.printf("After being sorted by odd/even.. ");
        evenOdd(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void evenOdd(int[] nums) {
        int nextEven = 0;
        int nextOdd = nums.length - 1;

        while (nextEven < nextOdd) {
            // If we've found an even then it's already in the right position
            if (nums[nextEven] % 2 == 0) {
                nextEven++;
            }
            // Otherwise we've found an odd, need to swap it and decrement nextOdd
            else {
                swap(nums, nextEven, nextOdd);
                nextOdd--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
