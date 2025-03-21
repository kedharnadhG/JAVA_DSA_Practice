public class SearchInSortedRotatedArray {

    // Overall TimeComplexity: O(logn)
    // SpaceComplexity: O(1)

    public static int findPivot(int[] A, int l, int h){
        if(l>h){
            return -1;
        }
        if(l==h){
            return l;
        }
        int mid = l + (h-l)/2;
        if(mid<h && A[mid]>A[mid+1]){
            return mid;
        }
        if(mid>l && A[mid]<A[mid-1]){
            return mid-1;
        }
        if(A[l]>=A[mid]){
            //left side is sorted, large pivot
            return findPivot(A, l, mid-1);
        }
        return findPivot(A, mid+1, h);
    }

    public static int binarysearch(int[] A, int l, int h, int target){
        if(l>h){
            return -1;
        }
        int mid = l + (h-l)/2;
        if(A[mid]==target){
            return mid;
        }
        if(A[mid]>target){
            //left side
            return binarysearch(A, l, mid-1, target);
        }
        return binarysearch(A, mid+1, h, target);
    }

    public static void main(String[] args) {
        int[] A = {5,6,7,8,9,10,1,2,3,};
        int target = 22;
        int foundIndex = -1;
        //1. find the pivot element of the array using binary search itself
        int pivot = findPivot(A, 0, A.length-1);
        System.out.println("pivot index: "+pivot);


        //2. find the target element using binary search
        if(pivot == -1){
            foundIndex=  binarysearch(A,0, A.length-1, target);
        }
        if(A[pivot] == target){
             
            System.out.println("element found at index: "+pivot);
            return;
        }
        if(target>= A[0]){
            //left side
            foundIndex = binarysearch(A,0, pivot-1, target);
        }
        else{
            foundIndex = binarysearch(A,pivot+1, A.length-1, target);
        }
        if(foundIndex == -1){
            System.out.println("element not found");
        }else{

            System.out.println("element found at index: "+foundIndex);
        }

    }
}
