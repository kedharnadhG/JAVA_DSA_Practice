package DP;

public class CoinChangeProblem {

    public static int countWays(int[] coins, int n, int sum) {
        int table[] = new int[sum + 1];
        
        table[0] = 1;          // table[0] is 1 because there is one way to make the sum 0 (by choosing no coins)
        
        for(int i=0; i<n; i++) { //looping over the coins 
            for(int j=coins[i]; j<=sum; j++) { //looping over the sum from coins[i] to sum 
                table[j] += table[j-coins[i]];           // we add the number of ways to make the sum j by including the coin coins[i]
            }
        }
        return table[sum]; 
    }


    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 4;

        System.out.println("Total ways: "+countWays(coins, coins.length, sum));

    }
}





/*                    ⭐ COIN CHANGE (COUNT WAYS) ⭐
==============================================================================

        Goal:
            Count how many ways to make a given sum using unlimited coins.
            Order of coins does NOT matter (1+3 same as 3+1).

        DP definition:
            table[s] = number of ways to make sum s.

        Base case:
            table[0] = 1
            (One way to make sum 0: choose no coins)

        Transition:
            For each coin value 'c':
                For each sum j from c to totalSum:
                    table[j] += table[j - c]

        Meaning:
            If we want to make sum j using coin c,
            we add ways to make (j - c), 
            because after forming j-c we can append coin c.

        Why coin loop first?
            Ensures combinations, not permutations.
            Each coin is used in a non-decreasing order of denominations.

        Example (coins = {1,2,3}, sum = 4):
            number of ways = 4
                1+1+1+1
                1+1+2
                2+2
                1+3

        Time Complexity:
            O(n * sum)
        Space Complexity:
            O(sum)

        Key Insight:
            This is EXACTLY like unbounded knapsack counting:
                - unlimited usage of each coin
                - order doesn't matter
                - DP[j] += DP[j - coin]
        ==============================================================================
*/
