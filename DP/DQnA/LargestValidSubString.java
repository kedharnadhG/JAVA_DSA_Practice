package DP.DQnA;

public class LargestValidSubString {

    public static String findLargestSubString(String str, int k) {
        int n = str.length();
        int[] dp = new int[n];

        dp[0] = 1;

        int maxLen = 1;
        int maxInd =0;

        for (int i = 1; i < n; i++) {

            if (Math.abs(str.charAt(i) - str.charAt(i - 1)) <= k) {
                dp[i] = dp[i - 1] + 1;
            }

            else {
                dp[i] = 1;
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxInd = i;
            }

        }

        int startInd = maxInd - maxLen + 1;

        return str.substring(startInd, maxInd + 1);    

    }
    

    public static void main(String[] args) {
        String str = "zebraa";

        int k = 1;

        System.out.println(findLargestSubString(str, k));
    }


}
