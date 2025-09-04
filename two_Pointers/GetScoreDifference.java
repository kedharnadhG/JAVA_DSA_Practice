package two_Pointers;

/* Prob Stmnt: 
 
        P1 and P2 are two players; in each player’s turn they will select the first element of the current array -> remove that element from the array -> add it to their sum; 
        -> If the latest removed element is even then we need to reverse the remaining before next player plays the game on array 

 */

public class GetScoreDifference {

    public static int getScoreDifference(int[] arr) {
        
        int n = arr.length;
        int p1Score = 0;
        int p2Score = 0;

        int start = 0;
        int end = n - 1;

        int turn = 1;

        boolean isReversed = false;

        while (start < end) {

            int selected = 0;

            if (turn % 2 != 0) {
                //it's p1-turn

                if (isReversed) {
                    p1Score += arr[end];
                    selected = arr[end];
                    end--;
                } else {
                    p1Score += arr[start];
                    selected = arr[start];
                    start++;
                }
            } else {
                //it's p2-turn
                if (isReversed) {
                    p2Score += arr[end];
                    selected = arr[end];
                    end--;
                } else {
                    p2Score += arr[start];
                    selected = arr[start];
                    start++;
                }
            }

            if (selected % 2 == 0) {
                if (isReversed == false) {
                    isReversed = true;
                } else {
                    isReversed = false;
                }
            }

            turn++;

        }
            
        return Math.abs(p1Score - p2Score);

    }


    public static void main(String[] args) {
        int[] numSequ = { 3, 6, 2, 3, 5 };

        int res = getScoreDifference(numSequ);
        System.out.println(res);
    }
}
