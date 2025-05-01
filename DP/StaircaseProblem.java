package DP;

public class StaircaseProblem {

    public static int totalWays(int n){
        int prev1 = 1, prev2 = 1, curr;

        for(int i=2; i<=n; i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        
        int n2 = 2;
        System.out.println("For to reach " +n2 +" stairs Total ways= "+totalWays(n2));
      
        int n1 = 3;
        System.out.println("For to reach " +n1 +" stairs Total ways= "+totalWays(n1));
        
        int n = 4;
        System.out.println("For to reach " +n +" stairs Total ways= "+totalWays(n));
      
        int n3 = 5;
        System.out.println("For to reach " +n3 +" stairs Total ways= "+totalWays(n3));


    }
    
}
