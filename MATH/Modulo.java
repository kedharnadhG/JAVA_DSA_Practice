package MATH;

import java.util.Scanner;

public class Modulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();         // 5
        int b = sc.nextInt();         // 8
        int k = sc.nextInt(); // 9 
        
        // (a+b)%k = (a%k + b%k)%k
        System.out.println((a % k + b % k) % k);

        // (a*b)%k = (a%k * b%k)%k
        System.out.println(((a % k) * (b % k)) % k);

        // ( a-b)%k = (a%k - b%k)%k
        System.out.println((a % k - b % k + k) % k);

        // adding k -> 2-times (k+k = 2*k)
        System.out.println((a % k - b % k + 2*k) % k);
        
    }
}
