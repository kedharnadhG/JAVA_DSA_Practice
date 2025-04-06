public class GasStationProbUsingGreedy {
    public static int gasStation(int A[], int B[]) {
        int n = A.length;
        int fuel = 0;
        int start = 0;
        int sum = 0;
        
        // what it is doing is that it is finding the sum of the difference between the two arrays because, 
        // if the sum of the difference between the two arrays is greater than or equal to 0, then the answer is the starting index of the gas station
        // if the sum of the difference between the two arrays is less than 0, then the answer is -1
        for(int i = 0; i < n; i++){
            sum += A[i] - B[i];
            fuel += A[i] - B[i];
            
            if(fuel < 0){
                start = i+1;
                fuel = 0;
            }
        }

        if(sum >= 0){
            return start%n;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        //int A[] = {1,2,3,4,5};   // A[i] is the amount of gas in the ith gas station
        //int B[] = {3,4,5,1,2};      // B[i] is the cost of gas in the ith gas station, to reach the next gas station
        
        int A[] = {1, 2};   // A[i] is the amount of gas in the ith gas station
        int B[] = {2, 1};      // B[i] is the cost of gas in the ith gas station, to reach the next gas station
        
        System.out.println("the starting Index of the gas station is : "+gasStation(A,B) + "  to complete the journey where it started");
    }
}



// Overall TC: O(n)
// SC: O(1)