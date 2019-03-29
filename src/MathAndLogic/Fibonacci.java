package MathAndLogic;

import java.util.Scanner;

/**
 * Author: Stephen Sheldon 3/28/2019
 */

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        System.out.println("Please enter a number you would like me to find the corresponding Fibonacci number for");
        num = scan.nextInt();
        System.out.println("The result is: ");
        System.out.printf("%d", findFib(num));
    }

    private static int findFib(int num) {
        if (num <= 1) {
            return num;
        }

        return (findFib(num-1) + findFib(num-2));
    }
}
