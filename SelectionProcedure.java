public class SelectionProcedure {

    public static int partition(int[] arr, int low, int high) {
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

        return i;

    }



    public static int selectionProcedure(int[] arr, int low, int high, int k) {

        //divide (prartition algo)
        int m = partition(arr, low, high);

        if(m == k-1) {
            return arr[m];
        }
        else if(m > k-1) {
            //left subarray
            return selectionProcedure(arr, low, m-1, k);
        }
        else {
            //right subarray
            return selectionProcedure(arr, m+1, high, k);
        }

    }

    public static void main(String[] args) {
        int[] arr = {70,50,60,10,20,30,80,15};
        int n = arr.length;
        int k = 3;  //we want the 3rd smallest element in the array

        int thirdSmallest = selectionProcedure(arr, 0, n-1, k); //select function returns the kth smallest element in the array

        System.out.println(thirdSmallest);
    }
}
