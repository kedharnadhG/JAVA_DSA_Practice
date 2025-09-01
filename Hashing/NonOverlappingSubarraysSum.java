package Hashing;

public class NonOverlappingSubarraysSum {


    public static int[] calculatePrefixMaxSum(int[] nums) {
        int n = nums.length - 1;
        int[] prefixMaxSum = new int[n + 1];
        int currentMax = nums[1];
        prefixMaxSum[1] = nums[1];
 
        for (int i = 2; i <= n; i++) {
            currentMax = Math.max(0, Math.max(nums[i], currentMax + nums[i]));
            prefixMaxSum[i] = currentMax;
        }
 
        return prefixMaxSum;
    }
 
    public static int[] calculateSuffixMaxSum(int[] nums) {
        int n = nums.length - 1;
        int[] suffixMaxSum = new int[n + 1];
        int currentMax = nums[n];
        suffixMaxSum[n] = nums[n];
 
        for (int i = n - 1; i >= 1; i--) {
            currentMax = Math.max(0, Math.max(nums[i], currentMax + nums[i]));
            suffixMaxSum[i] = currentMax;
        }
 
        return suffixMaxSum;
    }


    public static int maxTwoNonOverlappingSubarraysSum(int[] nums) {
        int n = nums.length - 1;
        if (n == 0) return 0;
 
        int[] prefixMaxSum = calculatePrefixMaxSum(nums);
        int[] suffixMaxSum = calculateSuffixMaxSum(nums);
 
        int[] maxPrefixSum = new int[n + 2];

        maxPrefixSum[1] = prefixMaxSum[1];

        for (int i = 2; i <= n; i++) {
            maxPrefixSum[i] = Math.max(maxPrefixSum[i - 1], prefixMaxSum[i]);
        }
 
        int[] maxSuffixSum = new int[n + 2];

        maxSuffixSum[n] = suffixMaxSum[n];

        for (int i = n - 1; i >= 1; i--) {
            maxSuffixSum[i] = Math.max(maxSuffixSum[i + 1], suffixMaxSum[i]);
        }
 
        int maxSum = 0;
        for (int i = 0; i <= n; i++) {
            maxSum = Math.max(maxSum, maxPrefixSum[i] + maxSuffixSum[i + 1]);
        }
 
        return maxSum;
    }

    
    public static void main(String[] args) {
        int n = 7;
        int[] nums = new int[n + 1]; // index 0 unused

        // Fill from index 1
        nums[1] = 1;
        nums[2] = 5;
        nums[3] = -3;
        nums[4] = 4;
        nums[5] = -9;
        nums[6] = 9;
        nums[7] = 2;


        System.out.println("Maximum sum of two non-overlapping subarrays: " + maxTwoNonOverlappingSubarraysSum(nums));
    }
}
