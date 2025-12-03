import java.util.*;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        //1. sort the intervals based on the start-values of the interval --    TC: O(nlogn)
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0])); //lambda expression

        //2. merge the intervals, iterating over all the intervals --    TC: O(n) 
        //looking for the overlapping and non-overlapping pairs of intervals
        //using a linkedlist for storing the non-overlapping intervals
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals ){
            //if the list is empty or the current interval does not overlap with the last interval in the list
            //no overlapping i.e LASTEND < CURRENTSTART  "[0]->start, [1]->end"
            if(merged.isEmpty() || merged.getLast()[1] <interval[0]) {
                merged.add(interval);
            }
            //overlapping
            else{
                //if the current interval overlaps with the last interval in the list
                //update the end value of the last interval in the list
                merged.getLast()[1] = Math.max(interval[1], merged.getLast()[1]);
            }
        }
        // new int[merged.size()][] (because we have to return a 2D array, and the size of the 2D array is the size of the linkedlist)
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{8,10},{15,18},{2,6}};
       int[][] res = merge(intervals);
       for (int[] interval : res) {
           System.out.print(" " + Arrays.toString(interval));
       }
    }
}
