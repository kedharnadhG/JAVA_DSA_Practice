package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NoOfStepsToMakeAllpilesEql {

    public static int minSteps(int arr[]) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); // TreeMap to store the frequency of elements in the array (descending order)

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        int stepsCnt = 0;

        // after converting the map to a list it look like :-> [ [5, 2],[4, 2], [2, 1]]
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        for (int i = 0; i < list.size() - 1; i++) {

            System.out.println(list.get(i));

            list.get(i + 1).setValue(list.get(i).getValue() + list.get(i + 1).getValue());

            stepsCnt += list.get(i).getValue();

            list.get(i).setValue(0);

            System.out.println(list);
        }
        
        return stepsCnt;
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = { 4, 5, 5, 2, 4 };

        System.out.println("No of steps to make all piles equal: " + minSteps(nums));
    }
}



/* Output: 
            5=2
            [5=0, 4=4, 2=1]
            4=4
            [5=0, 4=0, 2=5]
            No of steps to make all piles equal: 6

 */