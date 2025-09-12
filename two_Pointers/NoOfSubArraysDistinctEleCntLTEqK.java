package two_Pointers;

import java.util.HashMap;

public class NoOfSubArraysDistinctEleCntLTEqK {

    /* Brute force
     
        public static int countSubArrays(long[] b, int k) {
            int n = b.length;
            long count = 0;
            // trying all possible subarrays
            for (int i = 0; i < n; i++) {
                HashMap<Long, Long> g = new HashMap<>();
                for (int j = i; j < n; j++) {
                    g.put(b[j], g.getOrDefault(b[j], 0L) + 1);
                    if (g.size() <= k) {
                        count++;
                    }
                }
            }
            
            return (int) count;
        
        }
    
     */
    
     
    /* Optimal
     
    */

    public static int countSubArrays(long[] b, int k) {
        int n = b.length;
        
        int count = 0;
        HashMap<Long, Long> g = new HashMap<>();
        for(int i = 0, j = 0;j<n;j++)
        {

            g.put(b[j], g.getOrDefault(b[j], 0L) + 1);
            while (g.size() > k) {
                g.put(b[i], g.get(b[i]) - 1);
                if (g.get(b[i]) == 0) {
                    g.remove(b[i]);
                }
                i++;
            }

            count += (j - i + 1);

        }
        
        return count;
    }


    public static void main(String[] args) {
        long[] arr = { 1, 2, 3, 5, 8, 8, 8, 8, 2, 1, 1, 1, 1, 1, 1 };
        int k = 4;

        System.out.println("The number of subarrays with distinct elements less than or equal to k is: " +countSubArrays(arr, k));
    }

}
