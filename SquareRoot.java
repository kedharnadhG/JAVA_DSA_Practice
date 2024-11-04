import java.util.*;
public class SquareRoot {

    public static int sqrroot(int num){
        int low=0, high=num,res=-1;   //here the value of 'high' can "n/2" also ---> bcoz, the sq.root of any number is lies within "n/2" range only
        while (low<=high) { 
            int mid=low+(high-low)/2;
            int val=mid*mid;
            if(val == num){
                return mid;
            }
            else if(val<num){
                // storing mid value as we need to report the floor value in case of non-perfect square root number
                res=mid;
                low=mid+1;
            }
            else    
                high=mid-1;
        }
        return res;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number you want to find the square root for:");
            int x= sc.nextInt();
            int res = sqrroot(x);
            if(res!=-1){
                System.out.println("the square root for : "+x + " is : " + res);
            }
            else{
                System.out.println("element not found");
            }
        }
    }
}
