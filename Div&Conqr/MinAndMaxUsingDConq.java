public class MinAndMaxUsingDConq {
    static class Pair {
    int min;
    int max;        
    } 

    public static Pair findMinAndMax(int[] arr, int i, int j) {

        //let's create the object
        Pair minMax = new Pair();
        Pair minMaxLeft = new Pair();
        Pair minMaxRight = new Pair();

        // 1. Small Problem : TC: O(1) / C
        // if it has only one element
        if (i == j) {
            minMax.min = arr[i];
            minMax.max = arr[i];
            return minMax;
        }

        // if it has two elements
        else if(i == j-1) {
            if(arr[i] < arr[j]) {
                minMax.min = arr[i];
                minMax.max = arr[j];
            }
            else {
                minMax.min = arr[j];
                minMax.max = arr[i];
            }
            return minMax;
        }

        // 2. Big Problem
        else{
            //1. Divide the problem into subproblems
            int mid = i + (j-i)/2;   // TC: O(1) / C

            //2. Solve the subproblems
            //Conquer the left subarray
            minMaxLeft = findMinAndMax(arr, i, mid);     // TC: T(n/2)

            //Conquer the right subarray
            minMaxRight = findMinAndMax(arr, mid+1, j);   // TC: T(n/2)

            //3. Combine the subproblems, to get the final Min and Max   TC: O(1)
            minMax.min = Math.min(minMaxLeft.min, minMaxRight.min);
            minMax.max = Math.max(minMaxLeft.max, minMaxRight.max);

            return minMax;
        }
    }

    public static void main(String[] args) {
        int[] arr = {20,50,10,15,25,55};
        int n = arr.length;
        Pair minMax = findMinAndMax(arr, 0, n-1);
        System.out.println("The Minimum value in the given array is: " +minMax.min);
        System.out.println("The Maximum value in the given array is: " +minMax.max);

    }
}
