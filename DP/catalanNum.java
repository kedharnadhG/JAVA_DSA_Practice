package DP;

//a catalan number is a number that can be expressed as a sum of two smaller catalan numbers, and the product of two smaller catalan numbers (widely used in combinatorics i.e counting problems).
public class catalanNum {


    public static int catalan(int n){
        int catalan[] = new int[n+2];
        catalan[0] = 1;
        catalan[1] = 1;

        for(int i =2; i<=n; i++){
            catalan[i] = 0;
            for(int j=0; j<i; j++){
                catalan[i] += catalan[j]*catalan[i-j-1];
            }
        }

        return catalan[n];
    }

    public static void main(String[] args) {
        int n1 = 3;
        System.out.println("catalan number at index "+n1+" is: "+catalan(n1));
        
        int n = 4;
        System.out.println("catalan number at index "+n+" is: "+catalan(n));

    }
    
}
