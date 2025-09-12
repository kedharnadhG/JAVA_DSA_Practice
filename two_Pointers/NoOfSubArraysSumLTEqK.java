package two_Pointers;

public class NoOfSubArraysSumLTEqK {

    /* Brute force
    
        TC : O(n^2)
        SC : O(1)
     
        public static int countSubArrays(int[] b, int k) {
            int n = b.length;
            int count = 0;
    
            for(int i = 0;i<n;i++)
            {
                int sum = 0;
                for (int j = i; j < n; j++) {
                    sum += b[j];
                    if (sum <= k) {
                        count++;
                    }
                }
    
            }
    
            return count;
        }
    
     */
    
    /*  Optimal    TC: O(2N) = O(N)   ( amortized TC )
        SC : O(1)
     
    */

    public static int countSubArrays(int[] b, int k) {
        int n = b.length;

        int count = 0;
        int sum = 0;

        for (int i = 0, j = 0; j < n; j++) {
            sum += b[j];

            // if (sum > k) {
                while (sum > k) {
                    sum -= b[i++];
                }
            // }

            count += (j - i + 1);
        }
        
        return count;
    }


    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 1, 1 };
        int k = 4;
        System.out.println( "The number of subarrays with sum less than or equal to k is: " +countSubArrays(arr, k));
    }



}
