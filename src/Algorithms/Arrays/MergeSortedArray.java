package Algorithms.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {

  /**
   * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
   * and two integers m and n, representing the number of elements in nums1 and nums2 respectively
   * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
   *
   * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
   * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
   * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
   */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i < n; ++i) {
      nums1[m + i] = nums2[i];
    }
    Arrays.sort(nums1);
    System.out.println(Arrays.toString(nums1));
  }

  // create new array and return it sorted
  public static int[] margeTwoSortedArray(int[] array1, int[] array2) {
    int[] mergedArray = new int[array1.length + array2.length];

    System.arraycopy(array1, 0, mergedArray, 0, array1.length);
    System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);
    Arrays.sort(mergedArray);

    return mergedArray;
  }


  public static void main(String[] args) {
    merge(new int []{1,2,3,0,0,0}, 3, new int[] {2,5,6},3);

    int[] arr = margeTwoSortedArray(new int[]{1,1,8,9,10}, new int[]{1,2,8,9,11,15,16});
    System.out.println(Arrays.toString(arr));
  }
}
