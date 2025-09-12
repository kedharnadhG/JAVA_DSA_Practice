package two_Pointers;

import java.util.Arrays;

public class NoOfPairsDiffLTEqK {


    /* Brute Force  :-> O(n^2)
    
        long count = 0;
        Arrays.sort(b);
    
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long d = b[j] - b[i];
                if (d <= k) {
                    count++;
                }
            }
        }
     
     */
    
    public static int countPairs(long[] b, int k) {
        int n = b.length;

        int count = 0;

        Arrays.sort(b);

        for (int i = 0, j = 0; j < n; j++) {
            while ( i < j && b[j] - b[i] > k) {
                i++;
            }
            count += (j - i);
        }

        return count;
     }
    

    public static void main(String[] args) {
        long[] arr = { 1, 3, 2 };
        int k = 2;

        System.out.println("The number of pairs with difference less than or equal to k is: " +countPairs(arr, k));
    }

}
