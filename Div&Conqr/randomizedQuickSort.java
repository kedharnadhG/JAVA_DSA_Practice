public class randomizedQuickSort {


     //function todo the partition of an array
    public static int partition(int[] arr, int l, int h){

        int randomIndex = l + (int) Math.random() % (h - l + 1);

        // swapping the random element with the first element and then everything is same as quicksort
        int temp = arr[randomIndex];
        arr[randomIndex] = arr[l];
        arr[l]= temp;

        int pivot = arr[l];
        int i = l;
        for(int j=l+1; j<=h; j++){
            if(arr[j]< pivot){
                i=i+1;
                //swap(arr[i], arr[j])
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        //swap (arr[l], arr[i])
        //to get the correct position of the pivot element
        int tmp = arr[l];
        arr[l] = arr[i];
        arr[i] = tmp;

        return i;
    }




    // function of the quicksort algorithm
    public static void quickSort(int[] arr, int l, int h){
        if(l<h){
            // 1. Divide the array into 2 subproblems
            int m = partition(arr, l, h);

            //2. Conquer the subproblems via the recursion
            quickSort(arr, l, m-1);
            quickSort(arr, m+1, h);

        }
    }

    //function to display the array
    public static void printArr(int[] arr, int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }


      public static void main(String[] args) {
        int[] arr = {50,30,70,90,10,34,89,98,13};
        int n = arr.length;
        System.out.println("Array before sorting is: ");
        printArr(arr, n);

        quickSort(arr, 0, n-1);


        System.out.println("Array after sorting is");
        printArr(arr, n);


    }
    
}
