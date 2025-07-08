public class maxSubArraySum {


    public static int[] maxSubArray(int[] nums) {
        int currSum =0;
        int maxSum = nums[0];

        int subArrStartPos = -1;
        int subArrEndPos = -1;

        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            
            if (currSum == 0) {
                start = i;
            }

            currSum += nums[i];

            if(currSum>maxSum){
                maxSum = currSum;
                subArrStartPos = start;
                subArrEndPos = i;
            }

            if(currSum<0){
                currSum=0;
            }

        }
        return new int[] { maxSum, subArrStartPos, subArrEndPos };
    }

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        
        int[] max  = maxSubArray(arr);

        System.out.println(" The maximum subarray sum is: " + max[0]);
        System.out.println(" The starting index of the subarray is: " + max[1]);
        System.out.println(" The ending index of the subarray is: " + max[2]);
    }
}
