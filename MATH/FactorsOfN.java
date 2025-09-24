package MATH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FactorsOfN {

    public static void factors(int n, List<Integer> listOfFactors) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    listOfFactors.add(i);
                } else {
                    listOfFactors.add(i);
                    listOfFactors.add(n / i);
                }
            }
        }
    }
    
    // how to find the prime-factors is pending ,
            
    /*
        
        Time Complexity: O(√n)
        Space Complexity: O(log n)
    
     */            
    public static HashMap<Long, Long> primeFactors(int n) {
        //function to find the prime factors & their count

        HashMap<Long, Long> factrCnt = new HashMap<>();

        while (n % 2 == 0) {
            factrCnt.put(2L, factrCnt.getOrDefault(2L, 0L) + 1);
            n /= 2;
        }


        for (int i = 3; i <= Math.sqrt(n); i += 2) {

            //while i divides n, increment it's count

            while (n % i == 0) {
                factrCnt.put((long) i, factrCnt.getOrDefault((long) i, 0L) + 1);
                n /= i;
            }

        }
        
        if (n > 2) {
            factrCnt.put((long) n, factrCnt.getOrDefault((long) n, 0L) + 1);
        }

        return factrCnt;
    }
    

    public static void main(String[] args) {
        int n = 12;

        List<Integer> listOfFactors = new ArrayList<>();
        factors(n, listOfFactors);

        Collections.sort(listOfFactors);
        System.out.println(listOfFactors);


        System.out.println("Prime factors of " + n + " are: ");
        HashMap<Long, Long> factrCnt = primeFactors(n);

        for (Long key : factrCnt.keySet()) {
            System.out.println(key + " : " + factrCnt.get(key));
        }

    }
}
