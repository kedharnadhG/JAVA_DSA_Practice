import java.util.*;
public class dequeImp {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        // deque.addFirst(4);
        // deque.addFirst(7);
        // deque.addFirst(9);
        
        // System.out.println("Deque data is: "+ deque);
       
       
        deque.addLast(4);
        deque.addLast(7);
        deque.addLast(9);
        
        System.out.println("Deque data is: "+ deque);

        //for stack op'n (LIFO)
        // deque.removeLast();
        // System.out.println("Deque data after the deletion is: "+ deque);

        //for Queue op'n (FIFO)
        deque.removeFirst();
        System.out.println("Deque data after the deletion is: "+ deque);


    }

}
