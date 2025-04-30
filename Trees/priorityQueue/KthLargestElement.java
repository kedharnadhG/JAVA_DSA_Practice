package Trees.priorityQueue;

import java.util.PriorityQueue;

public class KthLargestElement {
    
    //we can implement using 3-appraoaches, Min_Heap, Max_Heap, Sorting

    //Implementing using Min_Heap


    //the overall time complexity is O((n-k)logn)
    public static int kthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int num: arr){
            minheap.add(num);

            //deletion of elements from the minheap (n-k) times
            if(minheap.size()>k){
                minheap.poll();
            }

        }

        return minheap.peek();
    }


    //the overall time complexity is O(klogn)
    public static int kthLargestElementusingMaxHeap(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> b-a);

        for(int num: nums){
            maxheap.add(num);
        }

        // we need to delete k-times from the maxheap
        int res = 0;
        for(int i=0; i<k; i++){
            res = maxheap.poll();
        }
        return res;

    }


    public static void main(String[] args) {
        
        int k=2;
        int[] arr = {3,2,1,5,6,4};
        // int res = kthLargestElement(arr, k);
        int res = kthLargestElementusingMaxHeap(arr, k);
        System.out.println(k + "th largest element in the array is: " + res);
    }
}
