public class FactorialRec {
    public static int factNum(int num){
        if(num==0 || num==1) 
            return 1;
        else return num>0 ? num*factNum(num-1) : 0;
    }
    public static void main(String[] args) {
        int res = factNum(-5);
        System.out.println(res);
    }
}
