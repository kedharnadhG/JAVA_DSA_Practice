package MATH;

import java.util.ArrayList;
import java.util.Collections;
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
    
    // how to find the prime-factors is pending , 20/9 also pending  21/9 also pending  21/9 also pending
    

    public static void main(String[] args) {
        int n = 12;

        List<Integer> listOfFactors = new ArrayList<>();
        factors(n, listOfFactors);

        Collections.sort(listOfFactors);
        System.out.println(listOfFactors);


    }
}
