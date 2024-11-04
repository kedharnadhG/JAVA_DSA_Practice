import java.util.*;
public class StairCase {
    
    public static int countWays(int totStairs){
        if(totStairs<=1){
            return totStairs;
        }
        return countWays(totStairs-1)+countWays(totStairs-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of stair cases ");
        int stairs= sc.nextInt();
        int res= countWays(stairs+1);
        System.out.println(res);

    }
}
