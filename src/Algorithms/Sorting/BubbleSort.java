package Algorithms.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static Integer[] bubbleSort(Integer[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int x = 0; x < array.length - 1; x++) {
                if (array[x] > array[x + 1]) {
                    temp = array[x];
                    array[x] = array[x + 1]; // swap values
                    array[x + 1] = temp; // swap values
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] array = {8, 1, 56, 4, 7, 1, 87, 0};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }
}
