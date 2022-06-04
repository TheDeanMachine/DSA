package Algorithms.Arrays;

import java.util.Arrays;
import java.util.OptionalInt;

public class LinearSearchArray {

    public static Integer linearSearch(int[] arr, int item) {
        for (int current : arr) {
            if (current == item) {
                return item;
            }
        }
        return null;
    }

    public static int search2(int[] arr, int item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return item;
            }
        }
        return -1;
    }

    public static OptionalInt linearSearch2(int[] arr, int item) {
        return Arrays.stream(arr).filter(x -> x == item).findFirst();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println(linearSearch(arr, 1));
        System.out.println(linearSearch(arr, 8));

        System.out.println(search2(arr, 1));

        linearSearch2(arr, 1).ifPresent(System.out::println);
        linearSearch2(arr, 8).ifPresent(System.out::println);
    }
}
