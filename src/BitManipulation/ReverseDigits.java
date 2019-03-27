package BitManipulation;

/**
 * Author: Stephen Sheldon 3/27/2019
 *
 * Given a 32-bit signed integer, reverse digits of the integer
 *
 * Example:
 * Input: 123
 * Output: 321
 *
 * Input: -123
 * Output: -321
 *
 * Input: 120
 * Output: 21
 *
 * Assume that the function returns 0 when the reverse integer overflows.
 *
 *
 * Brute force approach: Convert to a string then swap the characters.
 *
 */

public class ReverseDigits {

    public static void main(String[] args) {

        int x = 123;
        int y = -123;
        int z = 120;

        System.out.println("Brute force approach is..");
        System.out.println(reverseBrute(x));
        System.out.println(reverseBrute(y));
        System.out.println(reverseBrute(z));

        System.out.println("Smart approach using bit manipulation is...");
        System.out.println(reverse(x));
        System.out.println(reverse(y));
        System.out.println(reverse(z));

    }

    public static int reverseBrute(int x) {
        // Convert to a char array
        boolean isNeg = false;
        int result;
        String s = "";

        if (x < 0 ) {
            isNeg = true;
            x = (-1 * x);
        }

        char [] charArr = String.valueOf(x).toCharArray();

        for (int i = charArr.length-1; i >= 0; i--) {
            s = s + charArr[i];
        }

        result = Integer.parseInt(new String(s));

        if (isNeg)
            result *= -1;

        return result;
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            result = result * 10 + (x % 10);
            x = x/10;
        }
        return result;
    }
}
