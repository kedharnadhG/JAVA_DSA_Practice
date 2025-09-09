package DQnA;

import java.util.*;

public class MinNoOfOprnsNeededToMakeAllEqToTarget {

    // Returns index of first element > target (i.e. upper_bound)
    // result is in range [0 .. a.length]
    static int upperBound(long[] a, long target) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }

    // Solve for one array b and multiple queries targets[]
    static void solve(long[] b, long[] targets) {
        int n = b.length;
        Arrays.sort(b);                    // sort ascending
        long[] prefix = new long[n + 1];   // prefix[i] = sum of first i elements (prefix[0]=0)
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + b[i - 1];
        }
        long total = prefix[n];

        for (long target : targets) {
            int cnt = upperBound(b, target);   // number of elements <= target
            // left part: make all cnt elements equal up to target (increase small ones)
            long leftPart = target * 1L * cnt - prefix[cnt];
            // right part: make all remaining elements down to target (decrease large ones)
            long rightPart = (total - prefix[cnt]) - target * 1L * (n - cnt);
            System.out.println(leftPart + rightPart);
        }
    }

    public static void main(String[] args) {
        // example (similar to your C++ usage)
        long[] b = {1, 2, 3, 4, 5};         // input array (no sentinels)
        long[] queries = {3, 2};            // sample queries
        solve(b, queries);

        // If you want to test the exact array you showed in C++:
        // long[] b2 = { /* your n values here */ };
        // long[] queries2 = { /* queries */ };
        // solve(b2, queries2);
    }
}
