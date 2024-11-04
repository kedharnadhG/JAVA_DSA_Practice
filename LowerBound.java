public class LowerBound {

    public static int lowerBound(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int result=-1;
        while(low<=high){
            int mid=low+ (high-low)/2;
            if(arr[mid]==target){
                result=mid;
                high=mid-1;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr= {2,7,7,8,8,10};
        int res= lowerBound( arr, 8 );
        if(res!=-1){
            System.out.println("first occurance of element found at index : "+res);
        }
        else{
            System.out.println("element not found");
        }
    }
    
}
