package QUEUE;
//Implementation of Stack DataStructure using Queue
// Time Complexity for Add: O(n)
// Time Complexity for remove: O(1)
// Space Complexity: O(n)

import java.util.*;
import java.util.LinkedList;
public class stackusingQueue {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>(); 

    //add an element in the stack
    // Time Complexity: O(n)
    public void add(int data){
        // 1. Move all the data elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.poll();   //removing element
        }

        // 2. Insert the new data in the Q1
        q1.add(data);
;
        // 3. move back all the data elements from q2 to q1
        while(!q2.isEmpty()){
            q1.add(q2.peek());
            q2.poll();
        }
    }

    //TO remove the elements from the stack
    // Time Complexity: O(1)
    static int remove(){
        if(q1.isEmpty()){
            System.out.println("Stack Underflow");
            System.exit(0);
        }

        int ele= q1.peek();
        q1.poll();

        return ele;
    }

    public static void main(String[] args) {
        stackusingQueue s = new stackusingQueue();
        
        //push operation in the stack
        s.add(2);
        s.add(5);
        s.add(7);
        s.add(10);

        //pop the element from the stack
        System.out.println("Deleted element is : "+ s.remove());   //here the last inserted element has to be deleted (i.e "10") since LIFO
        System.out.println("Deleted element is : "+ s.remove());   //here the last inserted element has to be deleted (i.e "7") since LIFO
    }
}
