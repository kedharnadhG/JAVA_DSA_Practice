package Trees.priorityQueue;

public class DeletionHeap {

    //Deletion in Max-Heap

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


    public static int delete(int[] arr, int n){
        // try to delete the root

        //delete the last node, 
        int lastNode = arr[n-1];

        //replace the last node with the root node
        arr[0] = lastNode;

        //decrease the size of the array
        n--;

        //call heapify to ensure the heap property, (Down-Heapify)
        heapify(arr, n, 0);

        return n;

    }



    public static void printArray(int[] arr, int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        
         //maximum size of the heap
         int MAX = 100;

         int[] arr = new int[MAX];
         
         //initialize values
         arr[0] = 100;
         arr[1] = 70;
         arr[2] = 60;
         arr[3] = 50;
         arr[4] = 55;
 
         // take current size of the heap/array
         int n = 5;
 
         System.out.println("Before delete operation elements in the heap: ");
         printArray(arr, n);
 
         //insert the value in the heap
         n = delete(arr, n);
 
         System.out.println("After delete operation elements in the heap: ");
         printArray(arr, n);

    }
    
}
