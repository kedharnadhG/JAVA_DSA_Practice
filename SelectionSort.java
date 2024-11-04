import java.util.*;
public class SelectionSort {
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            //min_idx is responsible for to store the index of minumumvalue in every iteration
            int min_idx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min_idx]){
                    min_idx=j;
                }
            }
            if(min_idx != i){
                //swap is required
                int tmp= arr[min_idx];
                arr[min_idx]=arr[i];
                arr[i]=tmp;
            }
        }
    }
    public static void selectionSortDesc(int[] arr){
        for(int i=0;i<arr.length;i++){
            //min_idx is responsible for to store the index of minumumvalue in every iteration
            int max_idx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[max_idx]){
                    max_idx=j;
                }
            }
            if(max_idx != i){
                //swap is required
                int tmp= arr[max_idx];
                arr[max_idx]=arr[i];
                arr[i]=tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={50,25,38,44,99,16,11,21};
        selectionSort(arr);
        System.out.println("after Selection ascending sorting the array is: "+ Arrays.toString(arr));
        
        System.out.println("********************");
        
        selectionSortDesc(arr);
        System.out.println("after Selection descending sorting the array is: "+ Arrays.toString(arr));

    }
}
