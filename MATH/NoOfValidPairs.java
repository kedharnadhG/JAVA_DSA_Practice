package MATH;

import java.util.HashMap;
import java.util.Map;

public class NoOfValidPairs {
    

    public static long validPairs(long[] a, long[] b, int n) {
     
        HashMap<Long, Long> mapA = new HashMap<>(); 
        HashMap<Long, Long> mapB = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            mapA.put(a[i], mapA.getOrDefault(a[i], 0L) + 1);
            mapB.put(b[i], mapB.getOrDefault(b[i], 0L) + 1);
        }

        long count = 0;

        for (Map.Entry<Long, Long> entry : mapA.entrySet()) {
            long curr = entry.getKey();

            long cnt = 0;

            long j = curr;

            while (j <= 1000000) {
                cnt += mapB.getOrDefault(j, 0L);
                j += curr;
            }

            count += cnt * mapA.get(curr);
        }


        return count;
        
    }


    public static void main(String[] args) {
        // int n = 4;
        int n = 3;
        long[] a = new long[n + 1];
        long[] b = new long[n + 1];

        a[1] = 2;
        a[2] = 3;
        a[3] = 1;
        // a[4] = 4;

        b[1] = 4;
        b[2] = 6;
        b[3] = 8;
        // b[4] = 4;


        System.out.println("The number of valid pairs is: " + validPairs(a, b, n));
        

    }

}
