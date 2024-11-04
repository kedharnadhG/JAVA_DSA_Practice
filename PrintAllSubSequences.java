import java.util.*;
public class PrintAllSubSequences {

    public static void printSequences(int[] arr, int index, ArrayList<Integer> tempArr){
        //base case
        if(index == arr.length){
            //print all the sequences ---- but don't print empty entries
            if(tempArr.size()>0){
                System.out.println(tempArr);
            }
            return;
        }

        //Recursive calls

        //Include
        printSequences(arr, index+1, tempArr);
        //adding the value in the tempArray
        tempArr.add(arr[index]);

        //Don't Include
        printSequences(arr, index+1, tempArr);
        //remove the value in the tempArray  --backtracking
        //we need to remove the last-entry
        tempArr.remove(tempArr.size()-1);

    }

    public static void main(String[] args) {
        int[] arr ={1,2};
        
        System.out.println("For the array: "+ Arrays.toString(arr)); //to print the 1d-array, for 2D-array "deepToString"
        printSequences(arr, 0, new ArrayList<Integer>());
        
        System.out.println("*********************************");
        
        int[] arr2 ={1,2,3};
        
        System.out.println("For the array: "+ Arrays.toString(arr2)); //to print the 1d-array, for 2D-array "deepToString"
        printSequences(arr2, 0, new ArrayList<Integer>());
        
    }
}
