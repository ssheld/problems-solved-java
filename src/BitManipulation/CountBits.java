package BitManipulation;

import java.util.Scanner;

/**
 * Author: Stephen Sheldon 3/15/2019
 *
 * Problem: Write a program that counts the number of set bits inside
 *          a non-negative integer.
 *
 * Time Complexity: O(n) - Have to loop through all bits in integer
 */

public class CountBits {

    public static void main(String[] args) {
        int num, numBits;
        Scanner scan = new Scanner(System.in);
        System.out.printf("Please enter a non-negative integer and I will count the number of set bits%n");
        num = scan.nextInt();
        numBits = count(num);
        System.out.printf("Number of set bits inside %d is %d%n", num, numBits);

    }

    private static int count(int x) {
        short numBits = 0;

        // Keep shifting out the bits until the integer is zero
        while (x != 0) {
            // Perform & on LSB and add to sum
            numBits += (x & 1);
            // Shift right by one
            x >>>= 1;
        }
        return numBits;
    }
}



