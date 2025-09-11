package DP.DQnA;

public class FrogJump {

    public static int minJumps(int[] b) {

        int n = b.length-1;  // since b[0] is unused
        // 1. create a dp[n]

        int[] dp = new int[n + 1];

        dp[1] = 0;
        dp[2] = Math.abs(b[1] - b[2]);

        int i = 3;
        while (i <= n) {

            dp[i] = Math.min(dp[i - 1] + Math.abs(b[i - 1] - b[i]), dp[i - 2] + Math.abs(b[i - 2] - b[i]));

            i++;
        }

        return dp[n];

    }
    
    public static void main(String[] args) {

        int[] stones = new int[7];

        stones[1] = 30;
        stones[2] = 10;
        stones[3] = 60;
        stones[4] = 10;
        stones[5] = 60;
        stones[6] = 50;


        System.out.println("Minimum number of jumps required to reach the last stone: " + minJumps(stones));
        
    }

}
