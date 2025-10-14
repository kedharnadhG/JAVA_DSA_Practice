package two_Pointers;

public class MergeTwoSortedArrays {
    
    
    // Merge ar1[0..n1-1] and ar2[0..n2-1] into ar3
     
    /* using 2-ptrs :-> TC: O(n1 + n2)
        public static void mergeArrays(int[] ar1, int[] ar2, int[] ar3) {
            int i = 0, j = 0, k = 0;
            int n1 = ar1.length;
            int n2 = ar2.length;
    
            while (i < n1 && j < n2) {
    
                // Pick smaller of the two current elements and move ahead in the array of the picked element
                if (ar1[i] < ar2[j])
                    ar3[k++] = ar1[i++];
                else
                    ar3[k++] = ar2[j++];
            }
    
            // if there are remaining elements of the first array, move them
            while (i < n1)
                ar3[k++] = ar1[i++];
    
            // Else if there are remaining elements of the second array, move them
            while (j < n2)
                ar3[k++] = ar2[j++];
        }
    
    */
    

    /*Inplace
     
    */

    
    public static void main(String[] args) {
        int[] ar1 = { 1, 3, 5, 7 };
        int[] ar2 = { 2, 4, 6, 8 };
        int[] ar3 = new int[ar1.length + ar2.length];

        // using 2-pointers
        // mergeArrays(ar1, ar2, ar3);

        for (int value : ar3)
            System.out.print(value + " ");
    }
    
}
