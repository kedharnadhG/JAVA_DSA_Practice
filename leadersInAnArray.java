import java.util.ArrayList;

public class leadersInAnArray {

    public static ArrayList<Integer> leaders(int[] arr) {
        
        int n = arr.length;

        int maxi = Integer.MIN_VALUE;

        ArrayList<Integer> ans = new ArrayList<>();

        int j = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > maxi) {
                maxi = arr[i];
                ans.add(arr[i]);
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};

        ArrayList<Integer> ans = leaders(arr);

        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}
