package DataStructures.Extra;

import java.util.*;

public class SortTheSummary {

    public static List<List<Integer>> groupSort(List<Integer> arr) {
        // This kind of map is keeping the order of the keys by their natural order.
        // in this case natural order is integer natural order

        Map<Integer, Integer> map = new TreeMap<>();
        // Run over the input arr and add to the map only if the key isn't their already.
        //else, increase the value at map[key] by one
        for (Integer currInt : arr) {
            if (map.containsKey(currInt)) {
                int currValue = map.get(currInt);
                map.replace(currInt, currValue + 1);
            } else
                map.put(currInt, 1);
        }

        // The next 7 lines is for sorting the map by VALUE
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator() {
            @SuppressWarnings("unchecked")
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry<Integer, Integer>) (o2)).getValue()).compareTo(((Map.Entry<Integer, Integer>)(o1)).getValue());
            }
        });

        // Now after the map is sorted, create 2-dimesional ArrayList and insert pairs of key and values into it
        List<List<Integer>> ans = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> curr : list) {
            List<Integer> integerList = new ArrayList<>(2);
            integerList.add(curr.getValue());
            integerList.add(curr.getKey());
            ans.add(integerList);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> tempPhoenix = Arrays.asList(100, 101, 102, 103, 104, 103, 106, 107, 108, 109, 106, 110, 106, 100, 103);
        groupSort(tempPhoenix).forEach(System.out::println);
    }
}
