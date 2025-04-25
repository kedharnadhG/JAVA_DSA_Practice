package QUEUE;
import java.util.*;
import java.util.LinkedList;
public class queueImplementation {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        //to insert data in the queue
        for(int i=0; i<10; i++){
            q.add(i);
        }

        System.out.println("Queue looks like"+ q);

        //To print the topmost element in the queue
        System.out.println("The topmost element in the queue before deletion is:"+ q.peek());

        //To remove element from the queue  [it deletes first element, since it is FIFO]
        q.remove();

        //To print the topmost element in the queue
        System.out.println("The topmost element in the queue after deletion is:"+ q.peek());

        // the size of the current queue
        System.out.println("The size of the queue is: "+ q.size());

    }
}
