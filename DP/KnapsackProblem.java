package DP;

import java.util.Arrays;

// following is a knapsack problem using bottom-up approach (Recursion) i.e dynamic programming (Tabulation)

public class KnapsackProblem {

    // c->capacity , n->number of items, wt->weight of each item, profit->profit of each item

    public static int knapsack(int c, int[] wt, int[] profit, int n){

        int[][] result = new int[c+1][n+1];

        for(int row[] : result){
            Arrays.fill(row, -1);
        }

        return knapsackHelper(c, wt, profit, n, result);

    }

    public static int knapsackHelper(int c, int[] wt, int[] profit, int n, int[][] result){

        //base case
        if(n==0 || c==0){
            return 0;
        }

        if(result[c][n] != -1){
            return result[c][n];
        }

        if(wt[n-1] >c){
            //exclude the current item
            result[c][n] = knapsackHelper(c, wt, profit, n-1, result);
            return result[c][n];
        }
        else{
            //include the current item
            int exclude = knapsackHelper(c, wt, profit, n-1, result);

            int include = profit[n-1] + knapsackHelper(c-wt[n-1], wt, profit, n-1, result);

            result[c][n] = Math.max(exclude, include);

            return result[c][n];
        }



    }


    public static void main(String[] args) {
        int[] profit = {10, 12, 28};
        int [] wt = {1, 2, 4};
        int capacity = 6;

        System.out.println("The maximum profit is: "+knapsack(capacity, wt, profit, profit.length));
    }
}
