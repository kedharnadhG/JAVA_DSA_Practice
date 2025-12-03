// problem statement: array ele's are givem, each element the number itself is the rank
// Question: each child must have at least one candy, and the child with the highest rank must have the maximum number of candies when compared to it's neighbors.
public class CandyDistUsingGreedy {

    public static int candyDist(int[] arr, int n) {
        int sum=0;
        //lets create an array which contains every element has one Candy
        int candy[] = new int[arr.length];
        for(int i=0; i<n; i++) {
            candy[i] = 1;
        }

        //iterating over left to right         TC: O(n)
        for(int i=1; i<n; i++) {
            if(arr[i] > arr[i-1]) {
                candy[i] = candy[i-1] + 1;
            }
        }

        //iterating over right to left           TC: O(n)
        for(int i=n-2; i>=0; i--) {
            if(arr[i] > arr[i+1]) {
                candy[i] = Math.max(candy[i], candy[i+1] + 1); //we are comparing the value of candy[i] and candy[i+1] + 1, because if the value of candy[i+1] + 1 is greater than candy[i], then we will update the value of candy[i]
            }
        }

        //sum of candies         TC: O(n)
        for(int i=0; i<n; i++) {
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        // int[] arr = {1,5,2,5,1};
        int[] arr = {0,2,4,3,2,1,1,3,5,6,4,0,0};
        int n = arr.length;
        int res = candyDist(arr, n);
        System.out.println(res);
    }
}



// The Overall Time Complexity: O(n) + O(n) + O(n) = O(3n) => O(n)
// The Space Complexity: O(n)

// we can optimise the space complexity by using constant space, using [SLOPE Concept], TC: O(n), SC: O(1), which is in the notes(DS-2) ,please refer once
