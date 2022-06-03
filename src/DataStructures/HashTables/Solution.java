package DataStructures.HashTables;

import java.util.*;

public class Solution {

    public static List<Integer> findMissingElements(int[] first, int[] second) {
        List<Integer> missingElements = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int x : second) {
            hashSet.add(x);
        }

        for (int x : first) {
            if (!hashSet.contains(x)) {
                missingElements.add(x);
            }
        }
        return missingElements;
    }

    public static void displayFreqOfEachElement(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int x : arr) {
            if (!freqMap.containsKey(x)){
                freqMap.put(x, 1);
            } else {
                freqMap.put(x, freqMap.get(x) + 1);
            }
        }

        freqMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public static Object getFirstRecurringObject(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>();
        for (Object obj : inputArray) {
            if(map.contains(obj)) {
                return obj;
            } else {
                map.add(obj);
            }
        }
        return null;
    }

    public static Object getFirstRecurringObject2(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>(Arrays.asList(inputArray)); //Filling the hash table before checking if the item exist
        for (Object obj : inputArray) {
            if (map.contains(obj)) {
                return obj;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        findMissingElements(new int[] {1, 2, 3, 4}, new int[]{1, 3}).forEach(System.out::println);
        System.out.println();

        findMissingElements(new int[] {8, 0, 1, 7, 3}, new int[]{5, 7, 8, 0, 2}).forEach(System.out::println);
        System.out.println();

        displayFreqOfEachElement(new int[] {4, 1, 3, 4, 5, 8, 3, 4, 4, 4, 4, 6, 5});
        System.out.println();

        Object[] arr = {1,5,8,5,1,8,8,7,4,4,10};
        System.out.println(getFirstRecurringObject(arr));
        System.out.println(getFirstRecurringObject2(arr));
    }
}
