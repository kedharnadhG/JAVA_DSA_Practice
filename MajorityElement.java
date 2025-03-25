public class MajorityElement {
    // Boyer-Moore Voting Algorithm 
    //Majority Element is that element which occurs more than n/2 times
    // Overall Time Complexity: O(n) + O(n) = O(2n) => O(n)
    // Space Complexity: O(1)
    public static int findMajority(int[] arr){
        //in greedy, the first element is the majority element
        int majEle = arr[0];
        int majECnt =1;
        for(int i=1; i<arr.length; i++){
            if(majEle == arr[i]){
                majECnt++;
            }else{
                majECnt--;
                if(majECnt == 0){
                    majEle = arr[i];
                    majECnt = 1;
                }
            }
        }

        // Step 2: Verify if the candidate is actually the majority element
        int count = 0;
        for(int num : arr) {
            if(num == majEle) {
                count++;
            }
        }
        
        // If the candidate appears more than n/2 times, return it
        if(count > arr.length / 2) {
            return majEle;
        } else {
            return -1; // Indicating no majority element exists
        }
        
    }
    public static void main(String[] args) {
        int[] arr= {1,2,3,1,2,1};
        int result = findMajority(arr);
        
        if(result == -1) {
            System.out.println("No majority element found");
        } else {
            System.out.println("Majority element: " + result);
        }
    }
}
