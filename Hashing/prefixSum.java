package Hashing;

public class prefixSum {
    

    static int[] prefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i <n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }
 
    static int optimizedSum(int[] prefix, int l, int r) {
        if(l == 0) {
            return prefix[r];
        }
        return prefix[r] - prefix[l - 1];
    }
 
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] prefix = prefixSum(nums);
 
        int l = 0, r = 9; // Example range [l, r]
        System.out.println("Optimized Sum: " + optimizedSum(prefix, l, r));
    }


}
