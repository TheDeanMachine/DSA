package Algorithms.Sorting;

// The algorithm maintains three pointers, one for each of the two arrays
// and one for maintaining the current index of the final sorted array.
public class MergeSort {
    void merge(int[] arr, int startIndex, int middleIndex, int endIndex) {
        // Maintain current index of sub-arrays and main array
        int x = 0;
        int y = 0;
        int currentIndex = startIndex;

        // Create array sizes based on array passed in
        int leftArraySize = middleIndex - startIndex + 1;
        int rightArraySize = endIndex - middleIndex;

        // Create left and right arrays based on those sizes
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        // copy the elements from the main array into the sub-arrays
        System.arraycopy(arr, startIndex, leftArray, 0, leftArraySize);
        System.arraycopy(arr, middleIndex + 1, rightArray, 0, rightArraySize);


        // Until we reach the END of either leftArray or rightArray, pick the largest among
        // elements of leftArray and rightArray and place them in the correct position at A[startIndex..endIndex]
        while (x < leftArraySize && y < rightArraySize) { // Have we reached the end of the arrays?
            if (leftArray[x] <= rightArray[y]) {   // Compare current elements of both arrays
                arr[currentIndex] = leftArray[x];  // Copy smaller element into sorted array
                x++;                               // Move pointer of element containing smaller element
            } else {
                arr[currentIndex] = rightArray[y]; // Copy smaller element into sorted array
                y++;                               // Move pointer of element containing smaller element
            }
            currentIndex++;
        }

        // When we run out of elements in either leftArray or rightArray,
        // copy the remaining elements into the main array
        while (x < leftArraySize) {
            arr[currentIndex] = leftArray[x];
            x++;
            currentIndex++;
        }

        while (y < rightArraySize) {
            arr[currentIndex] = rightArray[y];
            y++;
            currentIndex++;
        }
    }

    // Divide the array into two subarrays, sort them and merge them
    void mergeSort(int[] arr, int start, int end) {
        if (start < end) {

            // middlePoint is the point where the array is divided into two subarrays
            int middlePoint = (start + end) / 2;

            mergeSort(arr, start, middlePoint);
            mergeSort(arr, middlePoint + 1, end);

            // Merge the sorted subarrays
            merge(arr, start, middlePoint, end);
        }
    }

    // Print the array
    static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
    }

    // Driver program
    public static void main(String[] args) {
        int[] arr = { 6, 5, 12, 10, 9, 1 };

        MergeSort sort = new MergeSort();
        sort.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}