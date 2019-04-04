package BitManipulation;

import java.util.Scanner;

/**
 * Author: Stephen Sheldon 3/15/2019
 *
 * Problem: Given a 64 bit integer and two indices, swap these two bit indices in the integer
 */

public class SwapBits {


    public static void main(String[] args) {
        int i, j;
        long num;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an non-negative integer in which we will select two bits to be reversed");
        num = scan.nextLong();

        System.out.println("please enter the bit positions you wish to swap");
        i = scan.nextInt();
        j = scan.nextInt();

        System.out.printf("Swapping position %d with %d in number %d%n%n", i, j, num);

        num = swap(num,i,j);

        System.out.println("The result is " + num);
    }

    public static long swap(long x, int i, int j) {
        // First, let's check if the bits at indices i and j are the same.
        // If they are then we don't need to swap them. Extract the bits at
        // these positions and check if they're equal
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            // Bits are not the same, so let's flip them
            // because that's the same as swapping
            long bitMask = (1L << i) | (1L << j);

            // XOR with the bitmask to flip the bits in x
            x ^= bitMask;
        }
        return x;
    }
}
