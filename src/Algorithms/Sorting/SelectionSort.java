package Algorithms.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static Integer[] selectionSort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int tempValue;

            // Searching min value and it's index
            for (int x = i + 1; x < array.length; x++) {
                if (array[minIndex] > array[x]) {
                    minIndex = x; // lowest value found so far
                }
            }

            // Swapping the min value found
            tempValue = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tempValue;
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] array = {5, 1, 85, 4, 7, 9, 0, 3, 1};
        System.out.println(Arrays.toString(selectionSort(array)));
    }
}
