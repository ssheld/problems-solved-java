package MathAndLogic;

import java.util.Scanner;

/**
 * Author: Stephen Sheldon 4/4/2019
 *
 * Dynamic Programming implementation of Fibonacci. Every time we compute
 * F(i) we cache the result to use it later.
 *
 * This brings the runtime down the O(n) versus straight recursion version of O(2^n)
 */

public class DynamicFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        System.out.println("Please enter a number you would like me to find the corresponding Fibonacci number for");
        num = scan.nextInt();
        System.out.println("The result is: ");
        System.out.printf("%d", findFib(num));
    }

    private static int findFib(int num) {
        return findFib(num, new int[num+1]);
    }

    private static int findFib(int i, int[] cache) {
        // Base case
        if (i == 0 || i == 1) {
            return i;
        }

        // If our cache here is zero then we haven't called F(i)
        if (cache[i] == 0) {
            cache[i] = findFib(i-1, cache) + findFib(i-2, cache);
        }
        return cache[i];
    }
}