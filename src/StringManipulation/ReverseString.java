package StringManipulation;

import java.util.Scanner;

/**
 * Author: Stephen Sheldon 3/16/2019
 *
 * Problem: Take a string from the user and print out the reversed string, using lambda expressions
 */

interface StringRev {
    String rev(String n);
}

public class ReverseString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a string that you would like me to reverse.");

        String userString = scan.nextLine();
        StringRev reversedString = (str) -> {
            String result = "";

            for (int i = userString.length()-1; i >= 0; i--)
                result += userString.charAt(i);
            return result;
        };

        System.out.println("The reverse string is " + reversedString.rev(userString));

    }
}
