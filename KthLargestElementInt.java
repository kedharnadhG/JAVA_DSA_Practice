public class KthLargestElementInt {
    public static int partition(int[] arr, int low, int high) {
        //considering first element as pivot of an array
        int pivot = arr[low];
        int i = low;
        for(int j = low +1; j <= high; j++) {
            if(arr[j] < pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[low];
        arr[low] = arr[i];
        arr[i] = tmp;

        //returning the index of pivot element
        return i;

    }



    public static int selectionProcedure(int[] arr, int low, int high, int k) {

        //divide (prartition algo)  1. Dividing the problem into subproblems
        int m = partition(arr, low, high);

        //(Q: why k-1) relationship between index-number and position-number
        if(m == k-1) {
            return arr[m];
        }
        else if(m > k-1) {
            // traversing towards left subarray
            //2. Conquer the subproblems via recursion
            return selectionProcedure(arr, low, m-1, k);
        }
        else {
            // traversing towards right subarray
            //2. Conquer the subproblems via recursion
            return selectionProcedure(arr, m+1, high, k);
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {50,30,70,90,10,34,89,98,13};
        int n = arr1.length;
        int k = 3;  //we want the 3rd largest element in the array

        //I want K'th largest element in the array (3rd largest means: ( n-k+1 (9-3+1 = 7) ) 7'th smallest element in the array) i.e the relation
        int thirdSmallest = selectionProcedure(arr1, 0, n-1, n-k+1); //select function returns the kth smallest element in the array

        System.out.println(k + "th smallest element in the array is: " + thirdSmallest);
    }
}
