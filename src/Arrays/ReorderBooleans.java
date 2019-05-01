package Arrays;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Stephen Sheldon 5/01/2019
 *
 * Problem: Given an array A of n objects with boolean-valued keys, reorder the array
 *          so that all objects that have a false key appear first.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */

public class ReorderBooleans {

    public static void main(String[] args) {
        List<Boolean> list = new LinkedList<>();
        list.add(true);
        list.add(false);
        list.add(true);
        list.add(true);
        list.add(false);
        list.add(false);
        list.add(false);
        list.add(true);
        list.add(true);

        System.out.printf("List before partition is.. ");
        System.out.println(list);
        System.out.printf("List after partition is.. ");
        dutchFlagPartition(true, list);
        System.out.println(list);
    }


    public static void dutchFlagPartition(boolean pivot, List<Boolean> list) {
        int first = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != pivot) {
                Collections.swap(list, first, i);
                first++;
            }
        }
    }
}