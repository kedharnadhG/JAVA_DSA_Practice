import java.util.HashMap;

public class subarraysWithXorK {


    // optimal approach : O(n)  (using hashmap + prefixSum)
    public static int subarraysCntWithXorK(int[] arr, int k) {
        int cnt = 0;
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int XR = 0;

        for (int i = 0; i < n; i++) {

            // prefix XOR till index i:
            XR ^= arr[i];

            //By formula: x = xr^k:
            int x = XR ^ k;

            //If x is present in the map:
            if (map.containsKey(x)) {
                cnt += map.get(x);
            }

            //If xr is present in the map:
            if (map.containsKey(XR)) {
                map.put(XR, map.getOrDefault(XR, 0) + 1);
            } else {
                map.put(XR, 1);
            }

        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = subarraysCntWithXorK(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }
}
