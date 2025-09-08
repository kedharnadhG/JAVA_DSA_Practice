package DQnA;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.LongStream;

public class MinzTotDissatisfaction {


    // Code forces contest
    // doc link : https://docs.google.com/document/d/1h-3UTy-lnT1wtBLn_YU6WVzgpSuitS2Gh12_lvZOCNE/edit?tab=t.0



    public static void reverse(long[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            long temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }


    public static long minDissatisfaction(int n, int[] a, int[] b) {
        long sum = 0;
        long[] A = new long[n];

        for (int i = 0; i < n; i++) {
            sum = sum + b[i] * n - a[i];

            A[i] = a[i] - b[i];

        }
        
        Arrays.sort(A);
        reverse(A);

        for (int j = 1; j <= n; j++) {

            sum = sum + A[j - 1] * j;
        }

        return sum;
        
    }
    
    public static void main(String[] args) {
        int n = 10;
        int[] a = { 5, 12, 31, 20, 30, 29, 41, 7, 5, 3 };
        int[] b = { 10, 4, 45, 55, 17, 30, 32, 1, 5, 15 };

        System.out.println(minDissatisfaction(n, a, b));

    }
}
