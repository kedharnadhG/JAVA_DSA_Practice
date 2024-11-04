//Implementation of QUeue dataStructure using Stacks
//Time Complexity: enQueue: O(1)
//Time Complexity: deQueue: O(n)
//Space Complexity: O(n)


import java.util.*;

public class queueusingStack {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();


    //insertion of new element in the stack
    // Time Complexity: O(1)
    static void enqueue(int data){
        stack1.push(data);
    }

    //to remove the element from the stack
    //  Time Complexity: O(n)
    static int dequeue(){
        int ele;

        if(stack1.empty() && stack2.empty()){
            System.out.println("Queue is Empty");
            System.exit(0);
        }

        //pushing the elements of stack1 by popping to the Stack2, to achieve the FIFO
        if(stack2.empty()){
            while (!stack1.empty()) {
                ele = stack1.pop();
                stack2.push(ele);
            }
        }

        //to return the deleted element from the queue
        ele = stack2.pop();
        return ele;
    }

    public static void main(String[] args) {
        queueusingStack q = new queueusingStack();

        //insertion of elements in the queue
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);     //the data in stack is like this [4,3,2,1]


        //deletion of element in the queue   (we want to delete '1' first, since FIFO)
        //FIFO (First In First Out)
        System.out.println("Deleted Element is: "+q.dequeue());
        System.out.println("Deleted Element is: "+q.dequeue());


    }
}
