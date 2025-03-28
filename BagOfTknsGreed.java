import java.util.Arrays;

public class BagOfTknsGreed {
    // maximum score of the player with the given tokens and power, we have 2 ways to play the game (see notes once)

    public static int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int maxScore = 0;
        int n = tokens.length;
        int l=0, r=n-1;
        Arrays.sort(tokens);

        while(l<=r) {
            if(power >= tokens[l]) {
                power -= tokens[l];
                l++;
                score++;
                maxScore = Math.max(maxScore, score);
            }else if(score>=1) {
                power += tokens[r];
                r--;
                score--;
            }
            else
                break;
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] tokens = {100, 200, 300,400};
        int power = 200;
        int maxScore = bagOfTokensScore(tokens, power);
        System.out.println("The maximum score is: "+maxScore);
    }
}


// Time Complexity: O(nlogn)
// Space Complexity: O(1)