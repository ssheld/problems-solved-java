package Arrays;
import java.util.Arrays;

/**
 * Author: Stephen Sheldon 5/02/2019
 *
 * Problem: Write a program which takes as input an array of digits encoding a nonnegative
 *          decimal integer D and updates the array to represent the integer D+1
 *
 * Time Complexity: O(n) where n is the length of the array num
 */

public class IntAsArrayIncrement {

    public static void main(String[] args) {
        int[] num = {1,2,9};

        System.out.println("Current array is " + Arrays.toString(num));

        num = incrementArr(num);

        System.out.println("After adding 1 we have " + Arrays.toString(num));

    }

    public static int[] incrementArr(int[] num) {
        int carry = 1;
        int[] result = new int[num.length+1];

        for (int i = num.length; i > 0; i--) {
            result[i] = (num[i-1] + carry) % 10;
            carry = (num[i-1] + carry) / 10;
        }

        // Check if we have a carry
        if (carry != 0) {
            // If so add it to index 0
            result[0] = carry;
        }
        else {
            // If not remove the leading zero in our result to be returned
            return Arrays.copyOfRange(result, 1, result.length);

        }
        return result;
    }

}
