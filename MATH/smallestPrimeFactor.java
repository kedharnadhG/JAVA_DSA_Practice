package MATH;

public class smallestPrimeFactor {
    static final int MAXN = 1000000;
    static int[] spf = new int[MAXN + 1];
    

    static void computeSPF() {

        // initializing the spf with the number itself, bcoz the smallest prime factor of a number is itself
        for (int i = 2; i <= MAXN; i++) {
            spf[i] = i;
        }

        // sieve-process 
        for (int i = 2; i * i <= MAXN; i++) {
            if (spf[i] == i) {  // i is prime
                for(int j = i*i; j<=MAXN; j+=i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }

        
    }
    

    public static void main(String[] args) {
        
        computeSPF();

        // spf for the first 20-numbers
        for (int i = 2; i <= 20; i++) {
            System.out.println(i + " : " + spf[i]);
        }
        
    }
}
