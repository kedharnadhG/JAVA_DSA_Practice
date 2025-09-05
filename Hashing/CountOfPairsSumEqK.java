package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountOfPairsSumEqK {
   static int countOfPairsSumEqK(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
 
        for (int i = 0; i < arr.length; i++) {
            int complement = k - arr[i];
            if (map.containsKey(complement)) {
                count++;
            }
            map.put(arr[i], i);
        }
 
        return count;
    }
 
    public static void main(String[] args) {
        int[] b = {1, 2, 3, 4, 5};
        int k = 6;
        int count = countOfPairsSumEqK(b, k);
 
        System.out.println("Count of pairs with sum " + k + " is: " + count);
    }
}
