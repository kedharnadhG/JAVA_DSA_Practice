package DP;

public class SubsetSumK {

    public static boolean isSubsetSum(int arr[], int n, int sum) {
        //let't take 2d array of size n+1 by sum+1
        boolean subset[][] = new boolean[n+1][sum+1];

        //base case (if sum is zero, then true)
        for(int i=0; i<=n; i++){
            subset[i][0] = true;    //sum is zero i.e first column is true
        }

        // if sum is not 0 and the set is empty, then false
        for(int i=1; i<=sum; i++){
            subset[0][i] = false;   //first row is false
        }

        //fill the remaining array
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1] <= j){ // we include when the current element is less than or equal to sum
                    subset[i][j] = subset[i-1][j] || subset[i-1][j-arr[i-1]]; //if we can get sum by including the current element or excluding the current element
                }
                else{
                    subset[i][j] = subset[i-1][j]; //if we can't get sum by including the current element, then we can't get sum by excluding the current element
                }
            }
        }
        return subset[n][sum];
        

    }
    
    public static void main(String[] args) {
        int arr[] = {6, 3, 2, 1};
        int sum = 5;
        System.out.println("Is subset sum possible? : "+isSubsetSum(arr, arr.length, sum));

    }

}
