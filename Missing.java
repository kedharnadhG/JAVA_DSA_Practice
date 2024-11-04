/**
 * Missing
 */
public class Missing {

    public static void main(String[] args) {
        int arr[]={1,2,4,5,6,7};
        int n= arr.length;

        // (sum of nat_nums): TC- O(1)
        int sum_nat_nums = ((n+1)*(n+2))/2;
        int sum= 0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
        }

        int missingNumber = sum_nat_nums - sum;
        System.out.println("missing number is: "+ missingNumber);
    }
}