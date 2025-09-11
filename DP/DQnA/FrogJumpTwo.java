package DP.DQnA;

public class FrogJumpTwo {

    public static int minJumps(int[] b, int k) {

        int n = b.length - 1; // since b[0] is unused
        // 1. create a dp[n]

        int[] dp = new int[n + 1];

        dp[1] = 0;
        dp[2] = Math.abs(b[1] - b[2]);

        int i = 3;
        while (i <= n) {

            long answer = Long.MAX_VALUE;

            for (int j = 1; j <= k; j++) {

                if (i - j >= 1) {
                    answer = Math.min(answer, dp[i - j] + Math.abs(b[i - j] - b[i]));
                }

            }

            dp[i] = (int) answer;

            i++;

        }
        
        return dp[n];

    }
    

    public static void main(String[] args) {
        int[] stones = new int[11];

        stones[1] = 40;
        stones[2] = 10;
        stones[3] = 20;
        stones[4] = 70;
        stones[5] = 80;
        stones[6] = 10;
        stones[7] = 20;
        stones[8] = 70;
        stones[9] = 80;
        stones[10] = 60;

        int k = 4;
        int ans = minJumps(stones, k);
        System.out.println("Minimum number of jumps required to reach the last stone: " + ans);
    }
}
