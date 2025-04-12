package Trees.priorityQueue;

public class HeapSort {


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapify(int[] arr, int n, int i) {
        
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        //check if the left child is larger than the root
        if (l < n && arr[l] > arr[largest])
            largest = l;
        
        //check if the right child is larger than the root
        if (r < n && arr[r] > arr[largest])
            largest = r;

        //check if the largest element is not the root
        if (largest != i) {
            //swap the root with the largest element and call heapify on the largest element
            swap(arr, i, largest);

            heapify(arr, n, largest);
        }

    }


    public static void printArray(int[] arr, int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void heapSort(int[] arr, int n) {

        //build heap (rearrange array) , (n/2 - 1) is the last parent node
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--) {

            // Move current root to end
            swap(arr, i, 0);
    
            // call max heapify on the reduced heap, to maintain heap property to the index 0 to i
            heapify(arr, i, 0);
        }

    }



    public static void main(String[] args) {
        
        int[] arr = {12,11,5,13,7};

        heapSort(arr, arr.length);

        printArray(arr, arr.length);
    }
}
