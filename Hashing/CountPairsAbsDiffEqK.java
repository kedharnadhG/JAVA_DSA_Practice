package Hashing;

import java.util.HashMap;

public class CountPairsAbsDiffEqK {
    
    public static int countPairsAbsDiffEqK(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
 
        for (int i = 0; i < arr.length; i++) {
            if (freq.containsKey(arr[i] - k)) {
                count += freq.get(arr[i] - k);
            }
            if (k != 0 && freq.containsKey(arr[i] + k)) { // to avoid double counting when k = 0
                count += freq.get(arr[i] + k);
            }
 
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
 
        return count;
    }
 
    public static void main(String[] args) {
        int[] b = {1, 5, 3, 4, 2};
        int k = 2;
        System.out.println(countPairsAbsDiffEqK(b, k)); // Output should be the number of pairs with difference k
    }


}
