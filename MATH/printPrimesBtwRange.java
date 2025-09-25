package MATH;
// Sieve of Eratosthenes to print all primes between 2 numbers

import java.util.*;

public class printPrimesBtwRange {

    public static List<Integer> sieve(int n) {
        
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        int limit = (int) Math.sqrt(n);

        for (int p = 2; p <= limit; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= n; i += p) {
                    primes[i] = false;
                }
            }

        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (primes[i]) {
                result.add(i);
            }
        }
        return result;
    }
    

    // Function to find primes in a range [start, end] using a segmented sieve
    public static void printPrimesBtwRange(int low, int high) {
        
        List<Integer> primes = sieve(high);

        for (int prime : primes) {
            if (prime >= low && prime <= high) {
                System.out.print(prime + " ");
            }
        }


    }


    public static void main(String[] args) {
        int low = 2, high = 100;
        printPrimesBtwRange(low, high);
    }


}
