import java.util.ArrayList;
import java.util.Collections;

// the overall time complexity is O(N^2)
// the space complexity is O(N)

public class JobScheduling {
    char id;
    int deadline, profit;

    public JobScheduling() {} // empty constructor because we are using arraylist ()

    public JobScheduling(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public void printJobSequence(ArrayList<JobScheduling> arr, int MaxDeadline) {
        // 1.Sort the array on the basis of profit in descending order
        //lambda expressions   TC: O(nlogn)
        Collections.sort(arr, (a,b)->b.profit-a.profit); // (a-b) because we need to sort in descending order

        //2. Store the job-ids on the basis of the max profit and given deadline   TC: O(n^2)

        // to track the allotted jobs
        boolean[] result = new boolean[MaxDeadline];
        
        char[] jobs = new char[MaxDeadline];

        for (int i = 0; i < arr.size(); i++) {
            //find the first free slot, traverse starting from the deadline-1 to 0 since if slots are full
            for(int j = Math.min(MaxDeadline-1, arr.get(i).deadline-1); j>=0; j--) {
                if(result[j] == false) {
                    result[j] = true;
                    jobs[j] = arr.get(i).id;
                    break;
                }
            }
        }

        for(char i : jobs) {
            System.out.print(i + " ");
        }

        System.out.println(" ");
    }

    public static void main(String[] args) {

        ArrayList<JobScheduling> arr = new ArrayList<>();

        arr.add(new JobScheduling('1',5, 55));
        arr.add(new JobScheduling('2',2, 65));
        arr.add(new JobScheduling('3',7, 75));
        arr.add(new JobScheduling('4',3, 60));
        arr.add(new JobScheduling('5',2, 70));
        arr.add(new JobScheduling('6',1, 50));
        arr.add(new JobScheduling('7',4, 85));
        arr.add(new JobScheduling('8',5, 68));
        arr.add(new JobScheduling('9',3, 45));
        

        JobScheduling job = new JobScheduling();

        job.printJobSequence(arr,7);


    }
}
