import java.util.HashMap;

public class longestSubArrWith0Sum {


    // Brute Force :  O(n^2)
    static int solve(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
   
    // Optimal : O(n) (using hashmap + prefixSum)
    public static int solveOpt(int[] a, int n) {
        int sum = 0;
        int maxi = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // handles the 'sum == 0' case implicitly   (Suppose sum = 0 at index i ==> i - map.get(0) = i - (-1) = i + 1 ✅)
        for (int i = 0; i < n; i++) {
            
            /*
             
                sum += a[i];

                if (sum == 0) {
                    maxi = i + 1;
                } else {
                    if (map.containsKey(sum)) {
                        maxi = Math.max(maxi, i - map.get(sum));
                    } else {
                        map.put(sum, i);
                    }
                }

             */

            sum += a[i];
            if (map.containsKey(sum)) {
                maxi = Math.max(maxi, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxi;
    }


    public static void main(String args[]) 
    { 
        // int a[] = { 9, -3, 3, -1, 6, -5 };
        int a[] = {1, 2, -3};
        
        /* Brute Force
         * 
         * Time Complexity: O(n^2)
         * Space Complexity: O(1)
         * 
             System.out.println(solve(a));
        
         */


        // Optimal
         System.out.println(solveOpt(a, a.length));
         
    }
}
