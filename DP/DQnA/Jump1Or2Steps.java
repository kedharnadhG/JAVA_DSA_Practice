package DP.DQnA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Jump1Or2Steps {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, -10, -10, 2, 2, 2, 2, 1, 8 };
        int n = arr.length;

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[1] + dp[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 1]) + arr[i];
        }
        System.out.println("Max Profit To reach n by jumping 1 or 2 steps: " + dp[n - 1]);


        // if we can jump 1, 2 or 3 steps
        int[] dp2 = new int[n];
        dp2[0] = arr[0];
        dp2[1] = arr[1] + dp2[0];
        dp2[2] = arr[2] + Math.max(dp2[0], dp2[1]);
        for (int i = 3; i < n; i++) {
           dp2[i] = Math.max(dp2[i - 1], Math.max(dp2[i - 2], dp2[i - 3])) + arr[i];
        }
        System.out.println("Max Profit To reach n by jumping 1 or 2 or 3 steps: " + dp[n - 1]);
      

        // HW: we can jump 1, 2, 3 , but some cells are blocked
        Set<Integer> blocked = new HashSet<>();
        blocked.add(3);
        blocked.add(5);

        int dp3[] = new int[n];
        Arrays.fill(dp3, Integer.MIN_VALUE);

        // starting is never blocked, so 
        dp3[0] = arr[0];
        dp3[1] = blocked.contains(1) ? Integer.MIN_VALUE : arr[1] + dp3[0];
        dp3[2] = blocked.contains(2) ? Integer.MIN_VALUE : arr[2] + Math.max(dp3[0], dp3[1]);
        for (int i = 3; i < n; i++) {
            if (blocked.contains(i)) {
                dp3[i] = Integer.MIN_VALUE;
            } else {
                int bestPrev = Math.max(dp3[i - 1], Math.max(dp3[i - 2], dp3[i - 3]));
                if (bestPrev == Integer.MIN_VALUE) {
                    dp3[i] = Integer.MIN_VALUE; // No valid way to reach this cell
                } else {
                    dp3[i] = bestPrev + arr[i];
                }
            }
        }
        System.out.println("Max Profit To reach n by jumping 1 or 2 or 3 steps but some cells are blocked: " + dp3[n - 1]);



    }
}
