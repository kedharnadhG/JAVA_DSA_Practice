import java.util.ArrayList;
import java.util.Arrays;

public class RowWithMax1s {

    public static int lowerBound(ArrayList<Integer> arr, int n, int key) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) >= key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }


    public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int ind = -1, cnt_max = -1;
        for (int i = 0; i < n; i++) {
            int cntOnes = m - lowerBound(matrix.get(i), m, 1);
            if (cntOnes > cnt_max) {
                cnt_max = cntOnes;
                ind = i;
            }
        }
        return ind;
    }

    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 0)));
        
        
        int n = 3, m = 3;
        System.out.println("The row with the maximum number of 1's is: " +
                           rowWithMax1s(matrix, n, m));
    }
}
