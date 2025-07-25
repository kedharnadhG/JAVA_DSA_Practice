public class MedianOfTwoSortedArrs {
    //The overall time complexity is O(log(min(n1,n2))) because of binary search, and the space complexity is O(1).
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;

        //make sure that finding median for short array first, minding the TIME COMPLEXITY w.r.t size
        if (n1 > n2) {
            return findMedianSortedArrays(arr2, arr1);
        }
        int low = 0;
        int high = n1;
        
        //How many elements we want on left-side of median?
        int left = (n + 1) / 2;

        while(low <= high) {
            int mid1 = (low + high) >> 1; //low + (high - low) / 2
            int mid2 = left - mid1;

            int r1 = (mid1 < n1) ?  arr1[mid1] : Integer.MAX_VALUE  ;
            int r2 = (mid2 < n2) ?  arr2[mid2] : Integer.MAX_VALUE  ;
            int l1 = (mid1 -1 >= 0) ? arr1[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2 -1 >= 0) ? arr2[mid2-1] : Integer.MIN_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if(n % 2 == 1) {
                    return Math.max(l1, l2);
                }else{
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }
            else if(l1 > r2) {
                high = mid1 - 1;
            }
            else{
                low = mid1 + 1;
            }
            
        }
        return 0.0;
    }
    public static void main(String[] args) {
        // int[] arr1 = {7,12,14,15};
        // int[] arr2 = {1,2,3,4,9,11};
        int[] arr1 = {2,4};
        int[] arr2 = {1,3,4};
        double res = findMedianSortedArrays(arr1, arr2);
        System.out.println("Median is: "+ res);
    }
}
