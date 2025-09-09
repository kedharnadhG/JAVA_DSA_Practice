package DQnA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DeliveryMenCchef {
    

    public static void main(String[] args) {
        try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[n];
            Integer[] diff = new Integer[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long baseSum = 0;
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                baseSum += b[i];
                diff[i] = a[i] - b[i];
            }

            Arrays.sort(diff, Collections.reverseOrder());

            long[] prefix = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + diff[i - 1];
            }

            long maxTip = 0;
            for (int i = 0; i <= n; i++) {
                if (i <= x && (n - i) <= y) {
                    maxTip = Math.max(maxTip, baseSum + prefix[i]);
                }
            }

            System.out.println(maxTip);

            /*
                sample input:
                        5 3 3
                        1 2 3 4 5
                        5 4 3 2 1
                sample output:        21 
            
             */

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}


