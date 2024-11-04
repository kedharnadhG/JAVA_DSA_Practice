public class TilingProblem {

    public static int getWays(int n){
        //Base case
        if(n<=3){
            return n;
        }
        //Recursive call
        return getWays(n-1)+getWays(n-2);
    }

    public static void main(String[] args) {
        System.out.println("For n = " +1 +"  Total ways= "+getWays(1));
        System.out.println("For n = " +2 +"  Total ways= "+getWays(2));
        System.out.println("For n = " +3 +"  Total ways= "+getWays(3));
        System.out.println("For n = " +4 +"  Total ways= "+getWays(4));
        System.out.println("For n = " +5 +"  Total ways= "+getWays(5));
    }
}
