package Hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxAndMinFreq {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {0, 2, 5, 3, 1, 2, 4};
 
        Map<Integer, Integer> map = new HashMap<>();
        int maxiFreq = Integer.MIN_VALUE, maxiElement = arr[0];
        int miniFreq = Integer.MAX_VALUE, miniElement = arr[0];
 
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
 
        for (Map.Entry<Integer, Integer> num : map.entrySet()){
            if (num.getValue() >= maxiFreq){
                maxiFreq = num.getValue();
                maxiElement = num.getKey();
            }
            if (num.getValue() <= miniFreq){
                miniFreq = num.getValue();
                miniElement = num.getKey();
            }
        }
 
 
 
        System.out.println("Max frequency element: " + maxiElement + " with frequency: " + maxiFreq);
        System.out.println("Min frequency element: " + miniElement + " with frequency: " + miniFreq); 
    }
}
