public class sumOfDigits {
    
    public static int sumOfdigits(int num) {
        if(num==0) return 0;
        return num%10 + sumOfdigits(num/10);
    }


    public static void main(String[] args) {
        int num= 912;
        int res = sumOfdigits(num);
        System.out.println(res);
    }
    
}
