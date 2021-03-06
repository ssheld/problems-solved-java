package BitManipulation;

import java.util.Scanner;

/**
 * Author: Stephen Sheldon 3/15/2019
 *
 * Problem: Write a problem to compute the parity of a very large number of 64-bit words
 */

public class FindParity {

    public static void main(String[] args) {
        long num;
        short numParity;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a large integer to find the parity of.");
        num = scan.nextLong();
        numParity = bruteForceParity(num);
        System.out.printf("Using brute-force the parity of %d is %d%n", num, numParity);

        numParity = eraseBitParity(num);

        System.out.println("By erasing the lowest bit and dropping runtime to O(k) where k is the number of bits set to 1.");
        System.out.println("Our result is " + numParity);

        numParity = xorParity(num);

        System.out.println("By taking advantage of associative property of XOR we can get a runtime of O(logn) where n is the size of the word");
        System.out.println("And our result is " + numParity);
    }

    // Brute-force test value of each bit iteratively keeping track of the
    // number of 1's seen thus far. Only need to check for odd or even hence
    // the XOR operator.
    // Time Complexity: O(n) where n is the size of the word.
    private static short bruteForceParity(long x) {
        short numParity = 0;
        while (x != 0) {
            numParity ^= (x & 1);
            x >>>= 1;
        }
        return numParity;
    }

    // This method of checking parity erases the lowest bit in a word
    // in a single operation.
    private static short eraseBitParity(long x) {
        short numParity = 0;
        while (x != 0) {
            numParity ^= 1;
            x &= (x - 1); // Drops the lowest set bit of x
        }
        return numParity;
    }

    // Exploits properties of of XOR to process multiple bits at a time.
    // O(logn) time complexity where n is size of the word.
    private static short xorParity(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1);
    }
}
