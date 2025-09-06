public class NthRootOfANumber {

    public static int func(int mid, int n, int m) {
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m) {
                return 2;
            }
        }
        if (ans == m) {
            return 1;
        }
        return 0;
    }


    public static int nthRoot(int n, int m) {
        
        int l = 1, h = m;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int midEl = func(mid, n, m); // (int) Math.pow(mid, n);
            if (midEl == 1) {
                return mid;
            } else if (midEl == 0) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        int n = 4, m = 64;
        System.out.println("The "+n+"th root of "+m+" is: "+nthRoot(n, m));
    }
}
