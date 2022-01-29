package day04;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class PairFinder {
    public int findPairs(int[] arr){
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i: arr){
            if (!numbers.containsKey(i)){
                numbers.put(i, 1);
            } else {
                numbers.put(i, numbers.get(i)+1);
            }
        }
        int numberOfPairs = 0;
        for (int j: numbers.values()){
            numberOfPairs += j/2 ;
        }
        return numberOfPairs;
    }

    public static void main(String[] args) {
        PairFinder pairFinder = new PairFinder();
        System.out.println(pairFinder.findPairs(new int[]{7, 1, 5, 7, 3, 3, 5, 7, 6, 7}));
    }
}
