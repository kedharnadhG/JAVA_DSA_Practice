import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesInArr {


    public static List<Integer> findDuplicates(int[] nums, List<Integer> dupes) {

        Set<Integer> unique = new HashSet<>();

        for(int num : nums) {
            if(!unique.add(num)){
                dupes.add(num);
            }
        }

        return dupes;

    }

    public static void main(String[] args) {
        int [] nums = { 1, 2, 3, 2, 4, 3 };

        List<Integer> dupes = new ArrayList<Integer>();

        System.out.println(findDuplicates(nums, dupes));

        
    }
}
