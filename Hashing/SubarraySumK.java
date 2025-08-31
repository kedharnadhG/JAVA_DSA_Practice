package Hashing;

import java.util.HashMap;
import java.util.Map;

class SubarraySumK {

    public static void findSubarrays(int[] nums, int k) {
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        Map<Integer, Integer> lastOccurrence = new HashMap<>();

        int prefixSum = 0;
        int maxLen = 0, minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Case 1: Subarray from start
            if (prefixSum == k) {
                maxLen = Math.max(maxLen, i + 1);
                minLen = Math.min(minLen, i + 1);
            }

            // Largest check using firstOccurrence
            if (firstOccurrence.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - firstOccurrence.get(prefixSum - k));
            }

            // Smallest check using lastOccurrence
            if (lastOccurrence.containsKey(prefixSum - k)) {
                minLen = Math.min(minLen, i - lastOccurrence.get(prefixSum - k));
            }

            // Store in firstOccurrence (only once)
            firstOccurrence.putIfAbsent(prefixSum, i);

            // Always overwrite in lastOccurrence
            lastOccurrence.put(prefixSum, i);
        }

        System.out.println("Largest Subarray Length = " + maxLen);
        System.out.println("Smallest Subarray Length = " + (minLen == Integer.MAX_VALUE ? -1 : minLen));
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, -2, 2 };
        int k = 4;
        findSubarrays(nums, k);
        // Output:
        // Largest Subarray Length = 4
        // Smallest Subarray Length = 1
    }
    
}