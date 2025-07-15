public class MergeSort {

    //function to do the combine task by mergeProcedure
    public static void mergeProcedure(int[] arr, int l, int mid, int r){
        int i,j,k;
        // 'n1' - size of left subarray
        // n2 - size of the right subarray

        int n1 = mid - l +1;
        int n2 = r-mid;

        //create a left and right subarray
        int[] lsubarray = new int[n1];
        int[] rsubarray = new int[n2];

        //copy the elements into left & right subarray
        for(i =0; i<n1; i++){
            lsubarray[i] = arr[l+i];
        }

        for(j=0; j<n2; j++){
            rsubarray[j] = arr[mid+1+j] ;
        }

        //comparision among elements in the left and right subarray
        i=0;
        j=0;
        k=l;

        while(i<n1 && j< n2)
        {
            if(lsubarray[i]<= rsubarray[j]){
                arr[k++]= lsubarray[i++];
            }
            else{
                arr[k++]= rsubarray[j++];
            }
        }

        //copy the remaining elements (if any of the subarray got completed)

        //copy the remaining elements from leftSubArray
        while(i<n1){
            arr[k]= lsubarray[i];
            i=i+1;
            k=k+1;
        }

        //copy the remaining elements from rightSubArray
        while(j<n2){
            arr[k]= rsubarray[j];
            j=j+1;
            k=k+1;
        }
    }



    //function to do merge sort
    public static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            // 1. Divide the array into various subProblems
            int mid= l + (r-l)/2;
            
            //2. Conquer the subProblems via the recursion
            mergeSort(arr, l, mid);   // left-subArray Recursive call
            
            mergeSort(arr, mid+1, r);   // Right-subArray Recursive call

            //3. Combine - mergeProcedure
            mergeProcedure(arr,l, mid, r);        

        }
    }

    //To display the array
    public static void printArray(int[] arr, int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }



    public static void main(String[] args) {

        int arr[]= {50,20,40,90,88,11,13};
        int n= arr.length;

        System.out.println("Array before sort is: ");
        printArray(arr, n); 

        mergeSort(arr, 0, n-1);

        System.out.println();
        System.out.println("Array after sort is: ");
        printArray(arr, n);
    }
}
