package DataStructures.Extra;

import java.util.*;

public class TwoDimensionalList {

    public static void main(String[] args) {
        List<List<Integer>> twoDimList = new ArrayList<>(3);

        // initialize with a list
        for(int i=0; i < 3; i++) {
            twoDimList.add(new ArrayList());
        }

//        [0][1] // 1->2
//        [1][1] // 3->4
//        [2][1] // 5->6

        // use add() method to add-on to list
        twoDimList.get(0).add(1);
        twoDimList.get(0).add(2);

        twoDimList.get(1).add(3);
        twoDimList.get(1).add(4);

        twoDimList.get(2).add(5);
        twoDimList.get(2).add(6);


        for (int i = 0; i < twoDimList.size(); i++) {
            int innerListSize = twoDimList.get(i).size();

            for (int x = 0; x < innerListSize; x++) {
                Integer outerListIndex = i;
                Integer innerListIndex = x;
                Integer currentIndex = twoDimList.get(i).get(x);
                System.out.printf("Row [%d], Column [%d], is connected to value %d%n", outerListIndex, innerListIndex, currentIndex);
            }
        }




        List<Integer> tempPhoenix = Arrays.asList(100, 101, 102, 103, 104, 103, 106, 107, 108, 109, 110, 111);
        int count = 0;
        int numToCheck = tempPhoenix.get(3);

        for(int number : tempPhoenix ) {
            if ( number == numToCheck) {
                count++;
            }
        }

        System.out.println("Using for loop " + count);

        int occurrences = Collections.frequency(tempPhoenix, numToCheck);
        System.out.println("Using static Collections method " + occurrences);
    }
}

