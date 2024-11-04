import java.util.*;
public class FiboRecr {
    public static int fibonacciFind(int n){
        //base case condition
        if(n<=1){
            return n;
        }
        //recursive function call
        else return fibonacciFind(n-1)+fibonacciFind(n-2);
    }
    public static void main(String[] args) {
        //fibonacci of given number
        Scanner sc= new Scanner(System.in);
        int res= fibonacciFind(sc.nextInt());
        System.out.println(res);
        sc.close();
    }
}
