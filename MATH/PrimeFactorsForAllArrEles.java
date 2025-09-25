package MATH;

import java.util.HashMap;
import java.util.Map;

// The overall TC :-> O(n * 20 + sqrt(10^6))

public class PrimeFactorsForAllArrEles {

    static final int MAXN = 1000000;
    static int[] spf = new int[MAXN + 1];


    public static void computeSPF() {

        // initializing the spf with the number itself, bcoz the smallest prime factor of a number is itself
        for (int i = 2; i <= MAXN; i++) {
            spf[i] = i;
        }

        // sieve-process 
        for (int i = 2; i * i <= MAXN; i++) { // i*i :-> we need to check only till sqrt(n)
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j <= MAXN; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

    }
    

    // Function to return the prime factorization of a number using its smallest prime factor
    public static Map<Integer, Integer> primeFactorization(int val) {
        
        Map<Integer, Integer> factors = new HashMap<>();
        
        while (val != 1) {
            int d = spf[val];
            factors.put(d, factors.getOrDefault(d, 0) + 1);
            val /= d;
        }

        return factors;
    }



    public static void main(String[] args) {

        computeSPF();


        int n = 6;
        int[] b = new int[n + 1];

        b[1] = 6;
        b[2] = 12;
        b[3] = 18;
        b[4] = 24;
        b[5] = 30;
        b[6] = 36;

        for (int i = 1; i <= n; i++) {
            
            Map<Integer, Integer> factors = primeFactorization(b[i]);

             System.out.println("For index i -> " + i);
            // Print the prime factorization
            for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            System.out.println();
        
        
        
        }
    }


}
