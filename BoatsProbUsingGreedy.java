import java.util.Arrays;

public class BoatsProbUsingGreedy {
    public static int numRescueBoats(int[] people, int limit) {
        //sort the array in descending order
        // TC: O(nlogn), SC: O(1)
        Arrays.sort(people);
        int n = people.length;
        int light = 0, heavy = n - 1;
        int btCnt = 0;
        while(light <= heavy) {
            if(people[light] + people[heavy] <= limit) {
                light++;
                heavy--;
            }
            else {
                heavy--;
            }
            btCnt++;
        }
        return btCnt;
    }
    public static void main(String[] args) {
        // int[] people = {3,5,3,4};
        // int limit = 5;
        int[] people = {3,2,2,1};
        int limit = 3;
        int res = numRescueBoats(people, limit);
        System.out.println("Number of boats required: " + res);
    }
}
