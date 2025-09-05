package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrZeroSum {
    
    public static int maxLength(int[] arr) {
        int n = arr.length;

        // prefixSum -> first index
        Map<Integer, Integer> firstSeen = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        // insert prefix sum 0 at index -1
        // to handle sum from start
        firstSeen.put(0, -1);

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // if prefix sum already seen
            if (firstSeen.containsKey(prefixSum)) {
                int prevIndex = firstSeen.get(prefixSum);
                int length = i - prevIndex;
                maxLen = Math.max(maxLen, length);
            } else {
                
                // Storing first occurrence of this prefix sum, because to get longest
                firstSeen.put(prefixSum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10};
        System.out.println(maxLength(arr));
    }

}
