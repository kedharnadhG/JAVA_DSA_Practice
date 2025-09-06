public class NoOfUnitsForGivenBudgetMSOA {

    /* Microsoft Online Assessment:
    
        Doc:  https://docs.google.com/document/d/1iq1JaJbxu8s0AfAjrktgW7W_FvR2G-Z-RJhTmEavIMQ/edit?tab=t.0
    
        Time Complexity: O(Large_value * n)
        Space Complexity: O(1)
     
        public static int solveBF(int n, int[] required, int[] stock, int[] cost, int budget) {
            int units = 0;
    
            int i = 1;
            boolean flag = false;
            while (flag == false) {
    
                int sum = 0;
                for (int j = 0; j < n; j++) {       // O(n) time
    
                    int req = required[j] * i;
                    int diff = req - stock[j];
    
                    if (diff < 0) {
                        diff = 0;
                    }
                    sum += diff * cost[j];
    
                }
    
                if (sum <= budget) {
                    units = i;
                    i++;
                } else {
                    flag = true;
                }
            }
    
            return units;
        }
            
        
     */



     // Time Complexity: O(N * log(1e9))
    public static long solnBinarySearch(int n, int[] required, int[] stock, int[] cost, int budget) {
        long maxUnits =0;
        long low = 0;
        
        long high = (long)1e9;

        while (low <= high) {
            
            long mid = low + (high - low) / 2;

            long sum = 0;

            for (int i = 0; i < n; i++) {
                long req = required[i] * mid;
                long diff = req - stock[i];

                if (diff < 0) {
                    diff = 0;
                }
                sum += diff * cost[i];
            }

            if (sum <= budget) {
                maxUnits = mid;
                low = mid + 1;
            }else{
                high = mid-1;
            }
            
        }

        return maxUnits;
     }

    public static void main(String[] args) {
        int n = 4;
        int[] required = { 2, 2, 3, 1 };
        int[] stock = { 3, 2, 1, 4 };
        int cost[] = { 2, 3, 1, 6 };

        int budget = 30;

        // int res = solveBF(n, required, stock, cost, budget);

        // using binary search
        long res = solnBinarySearch(n, required, stock, cost, budget);
        System.out.println("No of units for given budget is: " + res);
    }
}
