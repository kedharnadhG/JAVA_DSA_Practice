package Hashing;

import java.util.HashMap;
import java.util.Map;

class SubarraySumK {


    /*
    
            public static void findSubarrayStats(int[] arr, int k) {
                Map<Integer, Integer> firstOcc = new HashMap<>();
                Map<Integer, Integer> lastOcc = new HashMap<>();

                firstOcc.put(0, 0);
                lastOcc.put(0, 0);

                int prefixSum = 0;
                int maxLength = 0, maxCount = 0;
                int minLength = Integer.MAX_VALUE, minCount = 0;

                for (int j = 1; j <= arr.length; j++) {
                    prefixSum += arr[j - 1];
                    int x = prefixSum - k;

                    // Largest using firstOcc
                    if (firstOcc.containsKey(x)) {
                        int i = firstOcc.get(x) + 1;
                        int curLength = j - i + 1;

                        if (curLength > maxLength) {
                            maxLength = curLength;
                            maxCount = 1;
                        } else if (curLength == maxLength) {
                            maxCount++;
                        }
                    }

                    // Smallest using lastOcc
                    if (lastOcc.containsKey(x)) {
                        int i = lastOcc.get(x) + 1;
                        int curLength = j - i + 1;

                        if (curLength < minLength) {
                            minLength = curLength;
                            minCount = 1;
                        } else if (curLength == minLength) {
                            minCount++;
                        }
                    }

                    // Update maps
                    firstOcc.putIfAbsent(prefixSum, j);
                    lastOcc.put(prefixSum, j);
                }

                System.out.println("Max Length: " + maxLength + " Count: " + maxCount);
                System.out.println("Min Length: " + (minLength == Integer.MAX_VALUE ? -1 : minLength) + " Count: " + minCount);
            }
     
     */


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