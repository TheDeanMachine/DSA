package Algorithms.Sorting;

// The algorithm maintains three pointers, one for each of the two arrays
// and one for maintaining the current index of the final sorted array.
public class MergeSort {
    void merge(int[] arr, int startIndex, int middleIndex, int endIndex) {

        // Create leftArray ← A[startIndex..middleIndex] and rightArray ← A[middleIndex+1..endIndex]
        int leftArraySize = middleIndex - startIndex + 1;
        int rightArraySize = endIndex - middleIndex;

        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; i++)
            leftArray[i] = arr[startIndex + i];

        for (int j = 0; j < rightArraySize; j++)
            rightArray[j] = arr[middleIndex + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i = 0;
        int j = 0;
        int k = startIndex;

        // Until we reach the END of either leftArray or rightArray, pick larger among
        // elements leftArray and rightArray and place them in the correct position at A[startIndex..endIndex]
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either leftArray or rightArray,
        // pick up the remaining elements and put in A[startIndex..endIndex]
        while (i < leftArraySize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArraySize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Divide the array into two subarrays, sort them and merge them
    void mergeSort(int arr[], int l, int r) {
        if (l < r) {

            // middlePoint is the point where the array is divided into two subarrays
            int middlePoint = (l + r) / 2;

            mergeSort(arr, l, middlePoint);
            mergeSort(arr, middlePoint + 1, r);

            // Merge the sorted subarrays
            merge(arr, l, middlePoint, r);
        }
    }

    // Print the array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = { 6, 5, 12, 10, 9, 1 };

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}