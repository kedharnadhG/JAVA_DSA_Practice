public class BalancedParanthesis {
    public static void balanceParanthesis(int n, int oc,int cc,String ans){
        if(oc == n & cc==n){
            System.out.println(ans);
            return;
        }
        if(oc<n){
            balanceParanthesis(n, oc+1, cc, ans +'(');
        }
        if(oc>cc){
            balanceParanthesis(n, oc, cc+1, ans+')');
        }
    }
    public static void main(String[] args) {
        balanceParanthesis(3,0,0,"");
    }
}
