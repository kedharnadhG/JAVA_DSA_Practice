package DQnA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinmzConnectedComponentsAtllasianOA {
    


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long[] b = new long[n + 1];

            long totSum = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                b[i] = Long.parseLong(st.nextToken());
                totSum += b[i];
            }


            Arrays.sort(b, 2, n + 1);

            long answer = 0;

            //try all possible splits

            for (int split = 1; split <= n - 1; split++) {

                long splitSum = 0;

                //take first "split", smallest elements from index 2-onwards
                for (int j = 2; j <= split + 1; j++) {
                    splitSum += b[j];
                }

                long ans1 = splitSum * (totSum - splitSum);

                // take last "split", largest elements from index n-split-onwards
                long splitSum2 = 0;
                for (int j = n; j >= n - split + 1; j--) {
                    splitSum2 += b[j];
                }

                long ans = Math.min(ans1, splitSum2 * (totSum - splitSum2));

                if (ans <= c) {
                    answer = split;
                }

            }

            System.out.println( n - answer);
        }
    }

}
