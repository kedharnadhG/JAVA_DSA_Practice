package MATH;

import java.util.*;

// submission link : https://www.codechef.com/viewsolution/1194812258

public class TotalNoOfFactors {
    
    private static final long MAXN = 1000000;
    private static final long MOD = 1000000007;
    private static long[] spf = new long[(int) MAXN + 1];
    

    public static void computeSPF() {
        
        for (int i = 2; i <= MAXN; i++) {
            spf[i] = i; // initializing the smallest prime factor (spf) of a number to itself

        }
        
        for (int i = 2; i * i <= MAXN; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= MAXN; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

    }


    public static Map<Long, Long> factorize(long val) {
        Map<Long, Long> factors = new HashMap<>();

        while (val != 1) {
            long d = spf[(int) val];
            factors.put(d, factors.getOrDefault(d, 0L) + 1);
            val /= d;
        }

        return factors;
        
    }





    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();    // 3
        int m = sc.nextInt();    // 3

        computeSPF();

        // computing hashMap for m
        Map<Long, Long> b1 = new HashMap<>();
        for (int i = 2; i <= m; i++) {
            Map<Long, Long> factors = factorize(i);

            for (Map.Entry<Long, Long> entry : factors.entrySet()) {
                b1.put(entry.getKey(), b1.getOrDefault(entry.getKey(), 0L) + entry.getValue());
            }
        }

        long[] b = new long[n + 1];
        
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt(); // 1 2 3

            Map<Long, Long> b5 = new HashMap<>(b1);
            Map<Long, Long> factors = factorize(b[i]);

            // merging both hashmaps ( factors(b[i]) &  factors(m) )
            for (Map.Entry<Long, Long> entry : factors.entrySet()) {
                b5.put(entry.getKey(), b5.getOrDefault(entry.getKey(), 0L) + entry.getValue());

            }

            long g = 1;
            for (Map.Entry<Long, Long> entry : b5.entrySet()) {
                g = (g * ((entry.getValue() % MOD + 1) % MOD)) % MOD;

            }

            System.out.println(g + " ");

        }
        
        sc.close();


    }


}
