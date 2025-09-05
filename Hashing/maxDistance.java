package Hashing;

import java.util.HashMap;

public class maxDistance {
    
    public static int maxDistance(int[] arr) {
      
        // Stores element to first index mapping
        HashMap<Integer, Integer> mp = new HashMap<>(); 
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
          
            // If this is the first occurrence of the 
            // element, store its index
            if (!mp.containsKey(arr[i]))
                mp.put(arr[i], i);
          
            // Else update max distance
            else
                res = Math.max(res, i - mp.get(arr[i]));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 1};
        System.out.println(maxDistance(arr));
    }

}
