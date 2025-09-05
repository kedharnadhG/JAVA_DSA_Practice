package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountOfPairsDiffEqK {


    public static int countOfPairsDiffEqK(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i] + k;
            if (freqMap.containsKey(target)) {
                count += freqMap.get(target);
            }
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
 
    public static void main(String[] args) {
        int[] b = {1, 5, 3, 4, 2};
        int k = 2;
        System.out.println("Count of pairs: " + countOfPairsDiffEqK(b, k));
    }


}