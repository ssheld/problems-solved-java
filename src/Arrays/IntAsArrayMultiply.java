package Arrays;
import java.util.Arrays;


/**
 * Author: Stephen Sheldon 5/02/2019
 *
 * Problem: Write a program that takes two arrays representing integers, and returns an integer
 *          representing their product.
 *
 * Time Complexity: O(nm) where m is the number of partial products with at most n+1 digits
 *
 */

public class IntAsArrayMultiply {
    public static void main(String[] args) {
        int[] a = {1,9,3,7,0,7,7,2,1};
        int[] b = {-7,6,1,8,3,8,2,5,7,2,8,7};

        System.out.println("Doing array multiplication...");
        System.out.println("Your result is ");
        System.out.println(Arrays.toString(multiple(a,b)));

    }

    public static int[] multiple(int[] a, int[] b) {
        int sign;

        // Check for the sign
        if (a[0] * b[0] < 0) {
            sign = -1;
        }
        else {
            sign = 1;
        }

        // Set first digit to absolute value
        a[0] = Math.abs(a[0]);
        b[0] = Math.abs(b[0]);

        int[] result = new int[a.length + b.length];

        for (int i = a.length-1; i >= 0; i--) {
            for (int j = b.length-1; j >= 0; j--) {
                // The result is the current result digit plus a[i] * b[i]
                result[i+j+1] = result[i+j+1] + a[i] * b[j];
                // If the result is two digits then we need to bring the first
                // digit over to the preceding index
                result[i+j] = result[i+j] + result[i+j+1]/10;
                // Finally store the remainder of mod 10 in the current index that
                // we are calculating the digit for
                result[i+j+1] = result[i+j+1] % 10;
            }
        }

        // Now we need to remove all leading zeros
        int numZeros = 0;

        // Let's count the number of leading zeros
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                numZeros++;
            }
            else {
                break;
            }
        }

        int[] finalResult;

        // Copy into new array to remove zeros.
        // Note the Arrays.copyOfRange that the beginning index is inclusive and the
        // ending index is exclusive (hence why we use result.length)
        finalResult = Arrays.copyOfRange(result, numZeros, result.length);

        // Finally set the sign
        finalResult[0] *= sign;

        return finalResult;
    }
}
