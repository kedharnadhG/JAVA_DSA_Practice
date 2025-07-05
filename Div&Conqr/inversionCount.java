import java.lang.reflect.Array;
import java.util.Arrays;

public class inversionCount {

    //function definition of counting of number of inversions via bruteforce approach    TimeComplexity: O(n^2)
    public static int inversioncount(int[] arr, int n) {
        int count = 0;
        // condition1 - via loops i <j
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                //condition2 - arr[i] > arr[j]
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    //     ------------------------ Merge Procedure  ------------------------   //
    //function to implement the merge procedure
    public static int mergeProcedure(int[] arr, int l, int mid, int h) {
        int swap = 0;
        // taken extra space : So SC - O(n)        
        int[] lsubarray = Arrays.copyOfRange(arr, l, mid + 1); //left subarray, mid+1 is not included
        int[] rsubarray = Arrays.copyOfRange(arr, mid + 1, h + 1); //right subarray, h+1 is not included

        int i = 0, j = 0, k = l;

        while(i < lsubarray.length && j < rsubarray.length) {
            if (lsubarray[i] <= rsubarray[j]) {
                arr[k++] = lsubarray[i++];
            } else {
                arr[k++] = rsubarray[j++];

                //assignment problem: here we are assigning the value to the "swap" variable. 
                //we are adding the difference of the mid index and the current index of the left subarray to the swap variable. This is because this is the number of elements in the left subarray that are smaller than the current element in the right subarray. 
                //hence we are counting the number of inversions.
                //assignment problem
                // Count of remaining elements in left subarray (see chatGPT)


                /*
                 
                    🧠 Why swap += (mid + 1) - (l + i)?
                        Let’s break it down:
                
                        l + i → actual index in the original array of current element in left subarray.
                
                        mid + 1 → start of right subarray.
                
                        So, (mid + 1) - (l + i) → number of remaining elements in the left subarray that are greater than rsubarray[j].
                
                        Because:
                
                        lsubarray[i] > rsubarray[j] → So every element from i to end of lsubarray will also be greater (since left & right are sorted).
                
                        These are inversions — so we count them all in one go.
                        
                
                        let : 
                        
                            arr = [1, 5, 2, 6]
                
                            Merge step for [1, 5] and [2, 6]:

                            i = 0 (1), j = 0 (2) → 1 < 2 → no inversion

                            i = 1 (5), j = 0 (2) → 5 > 2 → inversion found

                            Now:

                            l = 0, mid = 1, i = 1

                            swap += (1 + 1) - (0 + 1) = 2 - 1 = 1

                            That’s correct — 5 is greater than 2, and there’s only one element (5) left in lsubarray, so 1 inversion.
                 
                 */


                swap += (mid +1) - (l + i);
            }
        }

        while(i < lsubarray.length) {
            arr[k++] = lsubarray[i++];
        }

        while(j < rsubarray.length) {
            arr[k++] = rsubarray[j++];
        }

        return swap;
    }


    // function definition of counting of number of inversions via Divide and Conquer Approach    TimeComplexity: O(nlogn)
    public static int inversionCountOpt(int[] arr, int l, int h) {
        int count =0;
        if (l < h) {
            // 1. Divide tha array into subproblems
            int mid = l + (h - l) / 2;

            //2. Conquer the subproblems via the concept of recursion
            //left subarray
            count += inversionCountOpt(arr, l, mid);
            //right subarray
            count += inversionCountOpt(arr, mid + 1, h);

            //3. Cobine the results of left and right subarray to get the final solution
            count += mergeProcedure(arr, l, mid, h);
            
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {70,50,60,10,20,30,80,15};
        int arr1[] = {5,4,3,2,1};
        int n= arr1.length;
        int count = inversioncount(arr1,n);
        System.out.println("the inversion count of a given array using brute force approach is: " + count);


        int countOpt = inversionCountOpt(arr1,0, n-1);
        System.out.println("the inversion count of a given array using divide and conquer approach is: " + countOpt);

    }
}
