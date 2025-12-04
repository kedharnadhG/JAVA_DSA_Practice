package Trees.priorityQueue;

public class InsertionHeap {

    // MAX HEAP
    // Up-Heapify
    // the overall time complexity is ( O(n) + O(n) => O(n) ): the space complexity is O(n)

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void heapify(int[] arr, int n, int i) {

        //find the parent node
        int parent = (i-1)/2;

        if(arr[parent]>0){
            //if the parent node is greater than the parent node, if yes then swap them and call heapify on the parent node
            if(arr[i]>arr[parent]){
                swap(arr, i, parent);

                //recursively call heapify for the parent node for to ensure the heap property
                heapify(arr, n, parent);
            }

        }
    }

    public static int insert(int[] arr, int n, int key){

        //increase the size of the array / heap
        n++;

        //insert the key at the end of the array
        arr[n-1] = key;

        //call heapify to ensure the heap property, (Up-Heapify)
        heapify(arr, n, n-1);

        //return the size of the heap
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

        //val to add in the heap
        int value= 80;

        System.out.println("Before insertion operation elements in the heap: ");
        printArray(arr, n);

        //insert the value in the heap
        n = insert(arr, n, value);

        System.out.println("Total elements in the heap after insertion: " + n);
        System.out.println("After insertion operation elements in the heap: ");
        printArray(arr, n);
        
    }
}





/*HEAPIFY RULES (Min-Heap and Max-Heap)

    1. INSERT
    - Always insert at last index.
    - Fix by comparing with parent.
    - Use UP-HEAPIFY.

    2. DELETE ROOT
    - Move last element to root.
    - Fix by comparing with children.
    - Use DOWN-HEAPIFY.

    3. DECREASE KEY
    - Min-heap: value becomes smaller → may violate parent → UP
    - Max-heap: value becomes smaller → may violate children → DOWN

    4. INCREASE KEY
    - Min-heap: value becomes larger → may violate children → DOWN
    - Max-heap: value becomes larger → may violate parent → UP
*/