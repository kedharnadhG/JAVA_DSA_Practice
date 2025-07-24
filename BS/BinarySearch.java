//TC: O(log N)
// SC : O(1)
public class BinarySearch {

    public static int binSearch(int[] arr, int target){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return 0; //if youd don't find any value return 0
    }

    //Binary search using recursion
    public static int binarySearchRecur(int[] arr, int low, int  high, int target){
        if(low>high) return -1;
        
        int mid = low + high-low /2;

        if(arr[mid] == target) return mid;
        else if(target > arr[mid]) 
            return binarySearchRecur(arr, mid+1, high, target);
        else 
            return binarySearchRecur(arr, low, mid-1, target);
    }

    public static void main(String[] args) {
        int arr[] ={8,10,14,16,20,25}; //should be an sorted array
        // int foundInd= binSearch(arr, 15);
        // if(foundInd!=-1){
        //     System.out.println("element found at index : "+foundInd);
        // }
        // else{
        //     System.out.println("element not found");
        // }
        int target = 27;
        int res = binarySearchRecur(arr, 0, arr.length-1, target);
        if (res==-1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("element found at: "+res);
        }
    }
    
}
