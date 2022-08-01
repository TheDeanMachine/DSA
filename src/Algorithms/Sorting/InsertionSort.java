package Algorithms.Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int minValue = array[i];
            int x = i - 1;

            // Compare minValue with each element on the left of it until an element smaller than it is found.
            // For descending order, change minValue<array[x] to minValue>array[x].
            while (x >= 0 && minValue < array[x]) {
                array[x + 1] = array[x]; // swap
                --x;
            }

            // Place minValue at after the element just smaller than it.
            array[x + 1] = minValue; // swap
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = { 9, 5, 1, 4, 3, 8, 11 };
        System.out.println(Arrays.toString(insertionSort(array)));
    }
}
