public class LinkedList {
    Node head;
    class Node{
        int data; 
        Node next; //points to nextd-node

        Node(int d){
            data=d;
            next=null;
        }
    }

    //insert the node at the very begining in the linked list
    public void insertAtBegining(int newData){
        Node newNode = new Node(newData);
        newNode.next = head;
        head =newNode;
    }

    //implementation of insertion of a node after any node
    public void insertAfter(Node prev_Node, int newData){
        if(prev_Node==null){
            System.out.println("the previous node doesn't contain null values");
            return;
        }

        Node newNode = new Node(newData);
        newNode.next=prev_Node.next;
        prev_Node.next=newNode;
    }





    //insert the node at the very end in the linked list
    public void insertAtEnd(int newData){
        //initialize the newNode with the newData entered by the user
        Node newNode =new Node(newData);

        //checking LinkedList is empty 
        if(head==null){
            head=new Node(newData);
            return;
        }
        
        //if the LL has data (i.e not empty)
        newNode.next =null;
        //traversing the LinkedList to end of the Node
        Node temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next=newNode;
        return;

    }


    //implementation of deletion of a node in linked list
    void deleteNode(int position){
        //if linked list is empty
        if(head==null){
            return;
        }

        Node temp = head;
        //deletion from the begining
        if(position==0){
            head =temp.next;
            return;
        }

        //deletion is from other positionns apart from the begining
        for(int i=0; temp!=null && i<position-1; i++){
            temp = temp.next;
        }
        if(temp==null && temp.next==null){
            return;
        }
        temp.next =temp.next.next;

    }


    //Implementation of reversal of a linked list using an iterative approach
    //we need 3 pointers to iterate
    public void reverseLL(){
        Node curr=head;
        Node prev =null;
        Node nextPtr =null;

        while(curr!=null){
            nextPtr = curr.next;
            curr.next =prev;
            prev = curr;
            curr = nextPtr;
        }
        head =prev;
        return;
    }

    //implementation of reversal of a linked list using a recursive code
    public void reversalRec(Node curr, Node prev){
        //(base case is:) when reached last node of LinkedList
        if(curr.next==null){
            head=curr;
            curr.next=prev; //storing the last-but-one's addr in last node
            return;
        }

        Node nextPtr = curr.next;
        curr.next=prev;
        //Recursion concept
        reversalRec(nextPtr, curr);
    }


    //implementation of finding out the Middle node in a linked list
    //TWO-POINTER approach
    public void middleNode(){
        Node slowPtr= head, fastPtr = head;

        while(fastPtr!= null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("Middle data of a given linked list is: " + slowPtr.data);
    }


    //Implementation of finding out the Cycle(loop) in a linked list
    // -------- Floyd's cycle detection algorithm ---(V.IMP    INTERVIEW Question)
    public void detectLoop(){
        Node slowPtr= head, fastPtr = head;
        int flag=0;
        while(slowPtr!=null&& fastPtr!=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;

            //checking the meeting point
            if(slowPtr==fastPtr){
                flag=1;
                break;
            }
        }

        if(flag==0){
            System.out.println("No Loop(Cycle) detected");
        }
        else{
            System.out.println("Loop(Cycle) is Detected");
        }
        
    }


    //display all the nodes after the insertion
    public void printNodes(){
        Node current = head;
        while (current!=null) {
            System.out.print(current.data+" ");            
            current=current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList llist=new LinkedList();

        //function call
        
        llist.insertAtEnd(2);   
        llist.insertAtEnd(4);   
        llist.insertAtEnd(8);   
        llist.insertAtEnd(10);
        // System.out.println("Linked List after successful insertion of all the nodes");
        // llist.printNodes();

        // System.out.println("Linked List after successful insertion of 1 at begining");
        llist.insertAtBegining(1);
        // llist.printNodes();

        System.out.println("Linked List after successful insertion of 19 at begining");
        llist.insertAtBegining(19);
        // llist.printNodes();

        System.out.println();

        llist.insertAfter(llist.head.next.next.next, 13);
        llist.printNodes();

        // llist.printNodes();
        System.out.println();

        //deleting 4th element
        llist.deleteNode(3);
        System.out.println("after deleting 4th element, the lList is");
        llist.printNodes();
        System.out.println();


        //reversing of linked list
        // llist.reverseLL();

        //rever using recursive code
        // llist.reversalRec(llist.head, null);
        // System.out.println("After reversing the linked list is");
        // llist.printNodes();

        //finding Middle Node
        // llist.middleNode();

        /*
        // ---------Circular Linked List------
        Node temp=llist.head;
        //finding last element (for to make it circular)
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next=llist.head;
         */

        llist.detectLoop();
        System.out.println();


    }
}
