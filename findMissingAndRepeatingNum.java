public class findMissingAndRepeatingNum {

    /* Optimal-1 using HashMap (better)
     * 
     * Time Complexity: O(2n)
     * Space Complexity: O(n)
     
        public static int[] findMissingAndRepeating(int[] arr) {
            int n = arr.length;
            // int res[] = new int[2];
            repeating = -1;
            missing = -1;
    
            int[] hashArr = new int[n + 1];
    
            for (int i = 0; i < n; i++) {
                hashArr[arr[i]]++;
            }
    
            for (int i = 1; i <= n; i++) {
                if (hashArr[i] == 2) {
                    repeating = i;
                }
    
                else if (hashArr[i] == 0) {
                    missing = i;
                }
                    
                if( repeating != -1 && missing != -1 ){
                    break;
                }
            }
    
            return new int[] { missing, repeating };
        }
            
     */

    /* Optimal-2 using Math 
         Time Complexity: O(n)
         Space Complexity: O(1) 
         
         public static int[] findMissingAndRepeatingMath(int[] arr) {
             int n = arr.length;
     
             long sn = (n * (n + 1)) / 2;
             long s2n = (n * (n + 1) * (2 * n + 1)) / 6; // sum of squares of first n natural numbers
     
             long s1 = 0, s2 = 0;
     
             for (int i = 0; i < n; i++) {
                 s1 += arr[i];
                 s2 += arr[i] * arr[i];
             }
             
             long val1 = s1 - sn;     // x - y    -----> (1)
             long val2 = s2 - s2n; // x^2 - y^2 = (x-y) * (x+y)
             
             val2 = val2 / val1; // x+y     -----> (2)
             
             long x= ( val1 + val2 ) / 2; // x = (x+y)/2 (summing up the two equations)
             long y = x - val1;    // missing number
     
     
             return new int[] { (int) y , (int) x };       
     
         }
             
    */


    /* Optimal-3 using XOR
      
     */
    public static int[] findMissingAndRepeatingXor(int[] arr) {
        int n = arr.length;

        int xr = 0;

        for (int i = 0; i < n; i++) {
            xr = xr ^ arr[i];
            xr = xr ^ (i + 1);
        }

        int bitNo = 0;
        while (true) {
            if ((xr & (1 << bitNo)) != 0) {
                break;
            }
            bitNo++;
        }
        //we can use this also
        // int rsb = xr & ~(xr - 1);   // rightmost set bit

        //segregating with 0-th bits & 1-bits
        int zero=0, one=0;
        for (int i = 0; i < n; i++) {
            // part of 1-bits club
            if ((arr[i] & (1 << bitNo)) != 0) {
                one = one ^ arr[i];
            }
            // part of 0-bits club
            else {
                zero = zero ^ arr[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            // part of 1-bits club
            if ((i & (1 << bitNo)) != 0) {
                one = one ^ i;
            }
            // part of 0-bits club
            else {
                zero = zero ^ i;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == one) {
                cnt++;
            }
        }
        if (cnt == 2) {
            return new int[] { zero, one };
        } else {
            return new int[] { one, zero };
        }
        
    }



    public static void main(String[] args) {
        int[] arr = { 4, 3, 6, 2, 1, 1 };
        // int[] res = findMissingAndRepeating(arr);
        // int[] res = findMissingAndRepeatingMath(arr);

        int[] res = findMissingAndRepeatingXor(arr);
        System.out.println("The missing number is: " + res[0]);
        System.out.println("The repeating number is: " + res[1]);
    }
}
