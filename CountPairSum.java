public class CountPairSum {

    public static int countPairSum(int[] ar1, int ar2[],int target){
        int count =0;
        int m=ar1.length, n=ar2.length;
        int l=0, r=n-1;
        while (l<m && r>=0) {
            if(ar1[l] + ar2[r]==target){
                count++;
                l++;
                r--;
            }
            else if(ar1[l] + ar2[r]<target){
                l++;
            }
            else
                r--;
            
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7};
        int[] arr2= {2,3,5,8};
        int sum=10;
        int res = countPairSum(arr1,arr2,sum);
        System.out.println(res);
    }
}
