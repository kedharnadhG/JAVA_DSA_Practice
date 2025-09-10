package DQnA;

import java.util.*;

public class PenguinPairs {

    public static long countPairs(long noOfPenguins, long[] male, long[] female) {
        
        List<Long> p1m = new ArrayList<Long>();
        List<Long> p1f = new ArrayList<Long>();
        List<Long> p2m = new ArrayList<Long>();
        List<Long> p2f = new ArrayList<Long>();

        for (int i = 0; i < noOfPenguins; i++) {
            if (male[i] < 0) {
                p2m.add(Math.abs(male[i]));

            } else {
                p1m.add(male[i]);
            }
            if (female[i] < 0) {
                p2f.add(Math.abs(female[i]));
            } else {
                p1f.add(female[i]);
            }
        }

        Collections.sort(p1m);
        Collections.sort(p1f);
        Collections.sort(p2m);
        Collections.sort(p2f);


        long count = 0;

        int j = 0, i = 0;

        while (i < p1m.size() && j < p2f.size()) {

            if (p2f.get(j) > p1m.get(i)) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        int k = 0, l = 0;
        
        while (k < p2m.size() && l < p1f.size()) {

            if (p2m.get(k) > p1f.get(l)) {
                count++;
                k++;
                l++;
            } else {
                // move pointer, who fails the condition
                k++;     // male should be greater than girl, if he's not greater, then he's not a pair
            }

        }
        
        return count;

    }
    

    public static void main(String[] args) {
        long noOfPenguins = 7;

        long[] male = { -1900, -2000, -2500, 1500, 1600, 2500, -2500 };
        long[] female = { 1800, -1550, 2200, -1550, 2100, -2500, -1700 };


        System.out.println("The number of penguin pairs is: " + countPairs(noOfPenguins, male, female));
    }
}
