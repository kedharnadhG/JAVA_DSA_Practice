package two_Pointers;

/* Problem Statement:

    Given a sorted array of size N; find the number of quadruplets (i,j,k,l) such that -> a[i] + a[j] > k1 && a[k] + a[l] > k2  

    -> Will i < j < k < l -> Yes; 
*/

public class NoOfQuadruplets {
    
    /*Brute Force  -> TC : O(n^4)
     
     */

     
    /*Optimised1  -> TC : O(n^2)
    */
    public static long countQuadruplets(long[] b, int k1, int k2) {
        int n = b.length;

        long c = 0;

        for (int j = 1; j < n - 2; j++) {
            int i = j - 1;

            long c1 = 0, c2 = 0;

            while (i >= 0 && b[i] + b[j] > k1) {
                c1 += 1;
                i -= 1;
            }

            int k = j + 1;
            int l = n - 1;

            while (k < l) {
                if (b[k] + b[l] > k2) {
                    c2 += Math.abs(l - k);
                    l -= 1;
                } else {
                    k += 1;
                }
            }

            c += c1 * c2;

        }

        return c;

    }
    
    
    /* Optimal2 :-> using binary search, by fixing "j", get i-count using a formula on left-side
      
                get the (k,l) pairs  [j+1 .... n] :->  using a suffix-array ( see notes for reference)
     */

    
    public static void main(String[] args) {
        
        long[] arr = { 1, 1, 1, 1, 2, 2 };
        int k1 = 1, k2 = 3;

        System.out.println("The number of quadruplets is: " +countQuadruplets(arr, k1, k2));
    }

}
