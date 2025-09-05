package Hashing;

import java.util.HashMap;
import java.util.Map;

public class SameNumDistLessThanEqK {
    

    public static boolean sameNearNumDistLEqK(int[] nums, int k) {
        Map<Integer, Integer> numIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIdx.containsKey(nums[i]) && i - numIdx.get(nums[i]) <= k) {
                return true;
            }
            numIdx.put(nums[i], i);
        }
        return false;
    }
 
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1, 2, 3};
        int k = 2;
        if (sameNearNumDistLEqK(nums, k)) {
            System.out.println("There are two equal numbers within distance " + k);
        } else {
            System.out.println("No two equal numbers found within distance " + k);
        }
    }


}
