package Hashing;

import java.util.HashMap;
import java.util.Scanner;

/*
    

    Definition :-> [i……j] is good if sum[i……j]%k == length of that subarray 

    Time Complexity :-> O(n)

 */

public class CountNoOfGoodSubArrays {

    /* 0-based indexing
     
        public static Long countGoodSubarrays(long[] b) {
            int n = b.length;
            long p[] = new long[n];
    
            p[0] = b[0];
            for (int i = 1; i < n; i++) {
                p[i] = p[i - 1] + b[i];
            }
    
            System.out.println(p[0] + " " + p[1] + " " + p[2] + " " + p[3]);
    
            long count = 0;
            HashMap<Long, Long> freq = new HashMap<>();
            freq.put(0L, 1L);
    
            for (int i = 0; i < n; i++) {
                long y = p[i] - (i +1);
    
                count += freq.getOrDefault(y, 0L);
                freq.put(y, freq.getOrDefault(y, 0L) + 1);
    
            }
    
            return count;
    
        }
            
        public static void main(String[] args) {
            long[] b = { 1, 1, 1, 4 };
            System.out.println("Count of good subarrays: " + countGoodSubarrays(b));
        }

     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] b = new long[n + 1];
        long[] p = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextLong();
            p[i] = p[i - 1] + b[i];
        }

        long count = 0;
        HashMap<Long, Long> freq = new HashMap<>();
        freq.put(0L, 1L);

        for (int j = 1; j <= n; j++) {
            long y = p[j] - j;
            count += freq.getOrDefault(y, 0L);
            freq.put(y, freq.getOrDefault(y, 0L) + 1);
        }

        System.out.println(count);
    }

}
