package Arrays;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Stephen Sheldon 4/30/2019
 *
 * Problem: Write a program that takes an array A and an index i into A, and
 *          rearranges the elements such that all elements less than A[i] (the "pivot")
 *          appear first, followed by elements equal to the pivot, followed by elements
 *          greater than the pivot.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */

public class DutchNationalFlag {

    public enum Color {
        RED, WHITE, BLUE
    }

    public static void main(String[] args) {
        List<Color> list = new LinkedList<>();
        list.add(Color.RED);
        list.add(Color.BLUE);
        list.add(Color.BLUE);
        list.add(Color.BLUE);
        list.add(Color.RED);
        list.add(Color.WHITE);
        list.add(Color.WHITE);
        list.add(Color.RED);
        list.add(Color.BLUE);

        System.out.printf("Our flag before sorting is.. ");
        System.out.println(list);
        System.out.printf("Our flag after sorting is.. ");
        dutchFlagPartition(list);

        System.out.println(list);



    }

    public static void dutchFlagPartition(List<Color> list) {

        // Below code pivots on the middle of the list (the ordinal of whatever color is at middle position)
        //        int mid = list.size()/2;
        //        int pivot = list.get(mid).ordinal();

        // Let's instead pivot on white to make it resemble the dutch flag
        int pivot = 1;
        int smaller = 0;
        // Group all elements smaller than pivot
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ordinal() < pivot) {
                Collections.swap(list, smaller, i);
                smaller++;

            }
        }

        int larger = list.size()-1;
        // Group elements larger than pivot
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).ordinal() > pivot) {
                Collections.swap(list, larger, i);
                larger--;
            }
        }

    }
}
