package DQnA;

import java.util.Scanner;

public class ShootingCchefAarsiKrypto {
    


    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long m = sc.nextLong();
            long n = sc.nextLong();

            long[] b = new long[(int) n + 15];
            long[] k1 = new long[(int) n + 15];
            long[] k5 = new long[(int) n + 15];
            long[] sum_k1 = new long[(int) n + 15];
            long[] sum_k5 = new long[(int) n + 15];
            long[] sumr_k1 = new long[(int) n + 20];
            long[] sumr_k5 = new long[(int) n + 20];

            long p1 = 0, p2 = 0;

            for (int i = 1; i <= n; i++) {
                b[i] = sc.nextLong();
                if (b[i] == 1 || b[i] == 3) {
                    p1++;
                    k1[i] = i;
                }
                if (b[i] == 2 || b[i] == 3) {
                    p2++;
                    k5[i] = i;
                }
            }

            for (int i = 1; i <= n; i++) {
                sum_k1[i] = k1[i] + sum_k1[i - 1];
                sum_k5[i] = k5[i] + sum_k5[i - 1];
            }

            for (int i = (int) n; i >= 1; i--) {
                sumr_k1[i] = k1[i] + sumr_k1[i + 1];
                sumr_k5[i] = k5[i] + sumr_k5[i + 1];
            }

            long c1 = 0, c2 = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                if (k1[i] > 0) {
                    c1++;
                }

                long d1 = i * c1 - sum_k1[i];
                long d2 = sumr_k1[i] - i * p1;
                long r1 = d1 + d2;

                if (k1[i] > 0) {
                    p1--;
                }

                if (k5[i] > 0) {
                    c2++;
                }

                long d5 = i * c2 - sum_k5[i];
                long d6 = sumr_k5[i] - i * p2;
                long r5 = d5 + d6;

                if (k5[i] > 0) {
                    p2--;
                }

                sb.append(Math.abs(r1 - r5)).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

        sc.close();
    }

}
