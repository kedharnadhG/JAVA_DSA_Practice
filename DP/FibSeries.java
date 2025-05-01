package DP;

import java.util.Arrays;

public class FibSeries {

    //Top-Down Approach (Memoization)
    /*
        public static int fib(int n){
            int a=0, b=1, c;

            if(n==1){
                return a;
            }
            else if(n==2){
                return b;
            }
            else{
                for(int i=2; i<=n; i++){
                    c=a+b;
                    a=b;
                    b=c;
                }
            }
            //if loop iterates till including n, then return 'b', else return 'c' but 'c' has to be initialized to 0 initially
            return b;
        }   

    */
 
 
    //Bottom-Up Approach (Tabulation)
    public static int fib(int n){
        int[] fibSeries = new int[n+1];

        Arrays.fill(fibSeries, -1);

        return fibHelper(n, fibSeries);

    }

    public static int fibHelper(int n, int[] fibSeries){

        if(n==0 || n==1){
            return n;
        }
        if(fibSeries[n] != -1){
            return fibSeries[n];
        }
        else{
            int x = fibHelper(n-1, fibSeries);
            int y = fibHelper(n-2, fibSeries);
            fibSeries[n] = x+y;
            return fibSeries[n];
        }
    }
 
 
 
    public static void main(String[] args) {
        
            int n=5;
            System.out.println("Fib series at index "+n+" is: "+fib(n));
            
            int n1=7;
            System.out.println("Fib series at index "+n1+" is: "+fib(n1));
        

    }

}
