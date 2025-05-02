package DP;

import java.util.*;

public class LongestCommonSubsequenceProblem {

    public static int lcs(String X, String Y, int i, int j, int[][] result){
        
        //base case
        if(i==0 || j==0){
            return 0;
        }

        //if the value is already evaluated
        if(result[i][j] != -1){
            return result[i][j];
        }

        //if the characters are same, we get the result by 1 + lcs(X, Y, i-1, j-1)
        if(X.charAt(i-1) == Y.charAt(j-1)){
            result[i][j] = 1 + lcs(X, Y, i-1, j-1, result);
        }

        //if the characters are not same, we get the result by max(lcs(X, Y, i-1, j), lcs(X, Y, i, j-1))
        else{
            result[i][j] = Math.max(lcs(X, Y, i-1, j, result), lcs(X, Y, i, j-1, result));
        }

        return result[i][j];

    }
    

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        int m = X.length();
        int n = Y.length();

        int result[][] = new int[m+1][n+1];

        for(int[] row: result){
            Arrays.fill(row, -1); //initializing with -1, bcz we get to know whether the value is evaluated or not
        }

        System.out.println("Length of Longest Common Subsequence is: "+ lcs(X, Y, m, n, result));

    }
}
