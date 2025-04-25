public class FindAnyPeakElementInArr {

    // public static int peakElement(int[] arr, int n) {
    //     int low = 0;
    //     int high = n-1;
    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         if (mid > 0 && mid < n-1) {
    //             if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
    //                 return mid;
    //             }
    //             else if (arr[mid-1] > arr[mid]) {
    //                 // left side
    //                 high = mid - 1;
    //             }
    //             else {
    //                 low = mid + 1;
    //             }
    //         }
    //         else if (mid == 0) {
    //             if (arr[mid] > arr[mid+1]) {
    //                 return mid;
    //             }
    //             else {
    //                 return mid+1;
    //             }
    //         }
    //         else if (mid == n-1) {
    //             if (arr[mid] > arr[mid-1]) {
    //                 return mid;
    //             }
    //             else {
    //                 return mid-1;
    //             }
    //         }
    //         }
    //     return -1;
    // }

    public static int findPeak(int[] arr, int low, int high, int n) {
        int m = low + (high-low)/2;
        if( (m==0 || arr[m]>=arr[m-1]) && (m == n-1 || arr[m]>=arr[m+1]) ){  //m==0 || m==n-1 for to check the edge-cases
            return m;
        }
        else if(m>0 && arr[m-1]>=arr[m]){
            return findPeak(arr, low, m-1, n);
        }
        else{
            return findPeak(arr, m+1, high, n);
        }
        
    }
    public static void main(String[] args) {
        int[] arr = {7,2,3,4,3,1};
        int n = arr.length;
        int peakInd = -1;
        // peakInd = peakElement(arr, n);
        // if (peakInd != -1) {
        //     System.out.println("Peak Element is present at index " + peakInd + " in the given array.");
        // }
        // else {
        //     System.out.println("Peak Element is not present in the given array.");
        // }


        peakInd = findPeak(arr, 0, n-1, n);
        if (peakInd != -1) {
            System.out.println("Peak Element is present at index " + peakInd + " in the given array.");
        }
        else {
            System.out.println("Peak Element is not present in the given array.");
        }
    }
}
