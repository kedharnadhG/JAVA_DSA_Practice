package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubArraySumK {


    
    public static int[] lengthOfSubArraySumK(int[] arr, int k) {
        Map<Integer, Integer> firstOcc = new HashMap<>();
        Map<Integer, Integer> lastOcc = new HashMap<>();

        int prefixSum = 0;
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            if (prefixSum == k) {
                maxLength = Math.max(maxLength, i + 1);
                minLength = Math.min(minLength, i + 1);
            }

            int x = prefixSum - k;

            if (firstOcc.containsKey(x)) {
                maxLength = Math.max(maxLength, i - firstOcc.get(x));
            }

            if (lastOcc.containsKey(x)) {
                minLength = Math.min(minLength, i - lastOcc.get(x));
            }

            firstOcc.putIfAbsent(prefixSum, i);
            lastOcc.put(prefixSum, i);

        }

        return new int[] { maxLength, minLength };
    }
    
    // using sliding window approach to get the count of largest and smallest subarray with sum k
    public static int countSubArraySumKUsingSlidingWindow(int[] arr, int len, int k) {
        int count = 0;
        int sum = 0;
        
        //first window
        for(int i=0; i<len; i++) {
            sum+=arr[i];
        }
        
        if(sum==k) count++;
        
        //remaining windows
        for (int i = len; i < arr.length; i++) {
            sum = sum - arr[i - len] + arr[i];   // adding new element and subtracting old element(  )
            if (sum == k) {
                count++;
            }
        }
        
        return count;
    }

    

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3, 3, 2, 8 };
        
        int k = 8;

        int[] ans = lengthOfSubArraySumK(arr, k);
        int maxLen = ans[0];
        int minLen = ans[1];

        int maxLenCount = countSubArraySumKUsingSlidingWindow(arr, maxLen, k);
        int minLenCount = countSubArraySumKUsingSlidingWindow(arr, minLen, k);

        System.out.println("Number of Largest subarrays with sum 8 is: " + maxLenCount);
        System.out.println("Number of Smallest subarrays with sum 8 is: " + minLenCount);






        /*
     
        public static int[] countSubArraySumK(int[] arr, int k) {
        Map<Integer, Integer> firstOcc = new HashMap<>();
        Map<Integer, Integer> lastOcc = new HashMap<>();

        int prefixSum = 0;
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        int maxCount = 0;
        int minCount = 0;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            if (prefixSum == k) {
                int currlength = i + 1;

                if (currlength > maxLength) {
                    maxLength = currlength;
                    maxCount = 1;
                } else if (currlength == maxLength) {
                    maxCount++;
                }

                if (currlength < minLength) {
                    minLength = currlength;
                    minCount = 1;
                } else if (currlength == minLength) {
                    minCount++;
                }
            }

            int x = prefixSum - k;

            if (firstOcc.containsKey(x)) {
                int currlength = i - firstOcc.get(x);

                if (currlength > maxLength) {
                    maxLength = currlength;
                    maxCount = 1;
                } else if (currlength == maxLength) {
                    maxCount++;
                }

            }

            if (lastOcc.containsKey(x)) {
                int currlength = i - lastOcc.get(x);

                if (currlength < minLength) {
                    minLength = currlength;
                    minCount = 1;
                } else if (currlength == minLength) {
                    minCount++;
                }
            }

            firstOcc.putIfAbsent(prefixSum, i);
            lastOcc.put(prefixSum, i);

        }

        return new int[]{maxCount, minCount};
    }


     */
    

        // int[] ans = countSubArraySumK(arr, k);

        // System.out.println("Number of Largest subarrays with sum k is: " + ans[0]);
        // System.out.println("Number of Smallest subarrays with sum k is: " + ans[1]);
    }
}




/*Count of No.Of Subarrays with sum k
Given an array of integers and an integer k, you need to find the count of subarrays with sum equal to k.

            import java.util.HashMap;
            import java.util.Map;
            class GfG {
                static int cntSubarrays(int[] arr, int k) {

                    // HashMap to store prefix sums frequencies
                    Map<Integer, Integer> prefixSums = new HashMap<>();
                    int res = 0;
                    int currSum = 0;

                    for (int i = 0; i < arr.length; i++) {
                        // Add current element to sum so far.
                        currSum += arr[i];

                        // If currSum is equal to desired sum
                        // then a new subarray is found.
                        if (currSum == k)
                            res++;

                        // Check if the difference exists in the prefixSums map.
                        if (prefixSums.containsKey(currSum - k))
                            res += prefixSums.get(currSum - k);

                        // Add currSum to the set of prefix sums.
                        prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
                    }

                    return res;
                }

                public static void main(String[] args) {
                    int[] arr = {10, 2, -2, -20, 10};
                    int k = -10;
                    System.out.println(cntSubarrays(arr, k));
                }
            }


*/