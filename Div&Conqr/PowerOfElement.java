//approach: recursion
//TC: O(logn)
import java.util.*;
import java.math.*;;
public class PowerOfElement {

    //pow (a^b) definition
    public static long powerOfElement(long a, long b){
        long res=0, mid=0, finalResult=0;
        //base condition
        if(b==1){
            return a;
        }
        else{
            mid=b/2;
            res=powerOfElement(a, mid);
            finalResult = res*res;
            if(b%2 == 0){
                return finalResult;
            }
            else{
                return a * finalResult;
            }
        }
    }


    public static BigInteger powerOfBigElements(BigInteger a, int b){
        BigInteger result, finalResult;
        if(b==1){
            return a;
        }
        result = powerOfBigElements(a, b/2);
        finalResult = result.multiply(result);
        if(b%2==0){
            return finalResult;
        }
        else{
            return a.multiply(finalResult);
        }
    }



    public static void main(String[] args) {
        // long res = powerOfElement(2, 10);
        // System.out.println(res);


        //To get the result for big-numbers
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a and b values: ");
        BigInteger a=sc.nextBigInteger();
        int b= sc.nextInt();

        BigInteger result= powerOfBigElements(a,b);
        System.out.println(result);
    }
}
