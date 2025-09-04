package sorting;
import java.util.*;;
public class InsertionSort {
    public static void insertionSort(int[] arr){
        for(int i=1; i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                //swap between arr[j] and arr[j-1]
                int tmp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=tmp;
                
                j--;
            }
        }
    }
    public static void insertionSortDesc(int[] arr){
        for(int i=1; i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j]>arr[j-1]){
                //swap between arr[j] and arr[j-1]
                int tmp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=tmp;
                
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr= {70,20,50,30,90,5,15};
        insertionSort(arr);
        System.out.println("after Insertion ascending sorting ascending the array is: "+ Arrays.toString(arr));
        
        System.out.println("***************");

        insertionSortDesc(arr);
        System.out.println("after Insertion descending sorting the array is: "+ Arrays.toString(arr));
    }
}
